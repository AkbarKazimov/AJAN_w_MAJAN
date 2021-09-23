/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.dfki.asr.ajan.pluginsystem.sscservicecomputingplugin.extensions;

import de.dfki.asr.ajan.behaviour.nodes.common.AbstractTDBLeafTask;
import de.dfki.asr.ajan.behaviour.nodes.common.BTUtil;
import de.dfki.asr.ajan.behaviour.nodes.common.EvaluationResult;
import de.dfki.asr.ajan.behaviour.nodes.common.LeafStatus;
import de.dfki.asr.ajan.behaviour.nodes.common.TreeNode;
import de.dfki.asr.ajan.behaviour.nodes.query.BehaviorConstructQuery;
import de.dfki.asr.ajan.behaviour.nodes.query.BehaviorSelectQuery;
import de.dfki.asr.ajan.common.AJANVocabulary;
import de.dfki.asr.ajan.pluginsystem.extensionpoints.NodeExtension;
import de.dfki.asr.ajan.pluginsystem.sscservicecomputingplugin.vocabularies.SSCVocabulary;
import de.dfki.fastdownwardcaller.*;
import de.dfki.isem.*;
import de.dfki.s2m2.MatchingResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.binary.Base64;
import org.cyberborean.rdfbeans.annotations.RDF;
import org.cyberborean.rdfbeans.annotations.RDFBean;
import org.cyberborean.rdfbeans.annotations.RDFSubject;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.LinkedHashModel;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFHandler;
import org.eclipse.rdf4j.rio.Rio;
import org.slf4j.LoggerFactory;
import ro.fortsoft.pf4j.Extension;

/**
 *
 * @author ejara
 */
@Extension
@RDFBean("ssc:ServiceComputing")
public class SSCServiceComputing extends AbstractTDBLeafTask implements NodeExtension, TreeNode {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SSCServiceComputing.class);
    private final ValueFactory FACT = SimpleValueFactory.getInstance();
    
    @Getter
    @Setter
    @RDFSubject
    private String url;
    
    @RDF("rdfs:label")
    @Getter @Setter
    private String label;
   
    @RDF("ssc:serviceRequest")
    @Getter @Setter
    private BehaviorConstructQuery serviceRequestQuery;
   
    @RDF("ssc:serviceOffer")
    @Getter @Setter
    private BehaviorSelectQuery serviceOfferQuery;
    
    @RDF("ssc:filterModel")
    @Getter @Setter
    private String selectedFilter;
    
    @RDF("ssc:domainDefinition")
    @Getter @Setter
    private BehaviorConstructQuery domainDefinitionQuery;
    
    @RDF("ssc:problemInit")
    @Getter @Setter
    private BehaviorConstructQuery problemInitQuery;
    
    @RDF("ssc:problemGoal")
    @Getter @Setter
    private BehaviorConstructQuery problemGoalQuery;
    
    @Override
    public Resource getType() {
        return SSCVocabulary.SSCType;
    }
           
    @Override
    public String toString() {
        return "SSC Plugin (" + this.getUrl() + ")";
    }
    
    @Override
    public void end() {
        LOG.info("SSC Plugin (" + getStatus() + ")");
    }
    
    @Override
    public EvaluationResult.Result simulateNodeLogic(final EvaluationResult result, final Resource root) {
        return EvaluationResult.Result.UNCLEAR;
    }
    
    @Override
    public LeafStatus executeLeaf() {
        try {
            if (executeServiceComputing()) {
                String report = toString() + " SUCCEEDED";
		LOG.info(report);
		return new LeafStatus(Status.SUCCEEDED, report);
            } else {
                String report = toString() + " FAILED";
		LOG.info(report);
		return new LeafStatus(Status.FAILED, report);
            }
        } catch (URISyntaxException | IOException ex) {  //ToDo Elena: change to the specific Exception
            LOG.debug(toString() + ex);
            LOG.info(toString() + " FAILED due to service selection errors");
            return  new LeafStatus(Status.FAILED, toString() + " FAILED due to service selection errors");
        }
    }
    
    private boolean executeServiceComputing() throws URISyntaxException, IOException {
        boolean flag;
        if(selectedFilter.isEmpty()){
            executePlanner();
            flag = true;
        } else if (!selectedFilter.isEmpty()){
            executeMatchmaker();
            flag = true;
        } else
            flag=false;
        return flag;
    }
    
    @SuppressWarnings("null")
    private void executeMatchmaker() throws URISyntaxException, IOException{
        
        //Create the final model for the request
        Repository repoRequest = BTUtil.getInitializedRepository(this.getObject(), serviceRequestQuery.getOriginBase());
        Model requestModel = serviceRequestQuery.getResult(repoRequest);
        
        
        Model owlStatement = requestModel.filter(null, org.eclipse.rdf4j.model.vocabulary.RDF.TYPE, SSCVocabulary.profileFilter);
        
        IRI ontoHeader = FACT.createIRI("http://localhost:8080/WelcomeServicesRequest/Request.owl");
        IRI profileImported = FACT.createIRI("http://www.daml.org/services/owl-s/1.1/Profile.owl");
        IRI serviceImported = FACT.createIRI("http://www.daml.org/services/owl-s/1.1/Service.owl");
        IRI processImported = FACT.createIRI("http://www.daml.org/services/owl-s/1.1/Process.owl");
        IRI welcomeImported = FACT.createIRI("https://raw.githubusercontent.com/gtzionis/WelcomeOntology/main/welcome.ttl");
                
        Literal com = FACT.createLiteral("This is the service request", "en");
        requestModel.add(ontoHeader, org.eclipse.rdf4j.model.vocabulary.RDF.TYPE, org.eclipse.rdf4j.model.vocabulary.OWL.ONTOLOGY);
        requestModel.add(ontoHeader, org.eclipse.rdf4j.model.vocabulary.RDFS.COMMENT, com);
        requestModel.add(ontoHeader, org.eclipse.rdf4j.model.vocabulary.OWL.IMPORTS, profileImported);
        requestModel.add(ontoHeader, org.eclipse.rdf4j.model.vocabulary.OWL.IMPORTS, serviceImported);
        requestModel.add(ontoHeader, org.eclipse.rdf4j.model.vocabulary.OWL.IMPORTS, processImported);
        requestModel.add(ontoHeader, org.eclipse.rdf4j.model.vocabulary.OWL.IMPORTS, welcomeImported);
        
        System.out.println("The final model used for the serv request is ");
        //requestModel.forEach(System.out::println);
        
        //Create the final model for the offers
        Repository repoOffer = BTUtil.getInitializedRepository(this.getObject(), serviceOfferQuery.getOriginBase());
        //Model tripleServOffer = serviceOfferQuery.getResult(repoOffer);
        List<BindingSet>  tripleServOffer = serviceOfferQuery.getResult(repoOffer);
        Model mergedModel = getModelfromBindingResult(tripleServOffer);
        List<Model> offerModel = getModelListByService(mergedModel); 
        //List<Model> offerModel = createOfferList(tripleServOffer);
        
        if(offerModel.size()>0 && requestModel.size()>0){
            //create temp files from service and offer models
            String myPath = getClass().getResource("/").toURI().toString();
            String offers = "/tempOffers/";
            String request = "/tempRequest/";
            URI offersURI = new URI(myPath.concat(offers));
            URI requestURI = new URI(myPath.concat(request));
            Path pathFolderOffer = Paths.get(offersURI);
            Path pathFolderRequest = Paths.get(requestURI);
            Files.createDirectories(pathFolderOffer);
            Files.createDirectories(pathFolderRequest);

            File myAbsoluteFile = null;  
            FileOutputStream outFile = null;
            int indexList = 0;
            Iterator<Model> itModelList = offerModel.iterator();
            System.out.println(offerModel.size() + " models were received");
            while(itModelList.hasNext()){
                myAbsoluteFile = new File(pathFolderOffer.toString().concat("/Offer".concat(Integer.toString(indexList)).concat(".owl")));
                outFile = new FileOutputStream(myAbsoluteFile);
                RDFHandler writer = Rio.createWriter(RDFFormat.RDFXML , outFile);
                Rio.write(itModelList.next(), writer);
                indexList++;
            }
            //Iterator<Statement> itRequestModel = requestModel.iterator();
            File requestFile = null;
            //while(itRequestModel.hasNext()){
                requestFile = new File(pathFolderRequest.toString().concat("/Request".concat(".owl")));
                outFile = new FileOutputStream(requestFile);
                RDFHandler writer = Rio.createWriter(RDFFormat.RDFXML , outFile);
                Rio.write(requestModel, writer);
            //}  
            outFile.close();
            
            //Call the matchmaker
            String filterModelName = "matchmakerResources/filter/isem/" + this.getSelectedFilter();
            System.out.println("filter model " + filterModelName);
            
            String modelFileLocation = "matchmakerResources/default_model.xml";
            System.out.println("model file name " + modelFileLocation);
            
            ClassLoader classLoader = getClass().getClassLoader();
            File filterModelFileResources = new File(classLoader.getResource(filterModelName).getFile());
            System.out.println("filter model path " + filterModelFileResources.getPath());
            
            File modelFileResources = new File(classLoader.getResource(modelFileLocation).getFile());
            System.out.println("model path " + modelFileResources.getPath());
            
            if (Files.exists(pathFolderOffer) && Files.exists(requestFile.toPath()) && Files.exists(modelFileResources.toPath()) && Files.exists(filterModelFileResources.toPath())) {
                String[] isemParam = {requestFile.toPath().toString(), pathFolderOffer.toString(), modelFileResources.toPath().toString(), filterModelFileResources.toPath().toString()};
                //@SuppressWarnings("UseOfObsoleteCollectionType")
		//Map<URI, Vector<MatchingResult>> matchingResult = ISeMCLITool.setParameters(isemParam);
                String proposedOffer = "http://localhost:8080/services/FirstReceptionService.owl#FirstReceptionService";
                //for(URI resultURI : matchingResult.keySet()) {
                //    System.out.println(resultURI.toString() + ":");
                    
                //    @SuppressWarnings("UseOfObsoleteCollectionType")
                //    Vector<MatchingResult> ranking = matchingResult.get(resultURI);
                 //   String proposedOffer;
                //    if(ranking.isEmpty())
                //        proposedOffer = "http://localhost:8080/WelcomeServicesOffers/FirstReceptionService.owl#FirstReceptionService";
                //    else{
                    //Only the first result will be post-processed. 
                //        MatchingResult result = ranking.get(0);
                //        proposedOffer = result.getServiceOffer().toString();
                        System.out.println("\n The proposed offer is " + proposedOffer);
                //    }
                    IRI offer_proposal = FACT.createIRI(proposedOffer);                       
                    Statement nameStatement = FACT.createStatement(SSCVocabulary.SSCName, SSCVocabulary.SSCPred, offer_proposal);
                    Model responseModel = new LinkedHashModel();   
                    responseModel.add(nameStatement);
                        
                    if (serviceRequestQuery.getTargetBase().toString().equals(AJANVocabulary.EXECUTION_KNOWLEDGE.toString())) {
			this.getObject().getExecutionBeliefs().update(responseModel);
                    } else if (serviceRequestQuery.getTargetBase().toString().equals(AJANVocabulary.AGENT_KNOWLEDGE.toString())) {
				this.getObject().getAgentBeliefs().update(responseModel);
                    } else {
				this.getObject().getLocalServicesBeliefs().update(responseModel);
                    }
		//}  
            }
        }        
    }

    private Model getModelfromBindingResult(List<BindingSet> listTriples){ 
        Iterator<BindingSet> itrListTriples = listTriples.iterator();
        Set<String> usedBindings;
        Iterator<String> itPosSingleTriple; 
        List<Value> tripleResult;
        BindingSet singleTriple;
        Model modelFromBinding;
        ModelBuilder builder = new ModelBuilder();
        while(itrListTriples.hasNext()){
            singleTriple =  itrListTriples.next();
            usedBindings = singleTriple.getBindingNames();
            itPosSingleTriple = usedBindings.iterator();
            tripleResult = new ArrayList<>();
            
            while(itPosSingleTriple.hasNext()){
                tripleResult.add(singleTriple.getValue(itPosSingleTriple.next()));                    
            }
           
            IRI subject = SSCVocabulary.FACTORY.createIRI(tripleResult.get(0).toString());
            IRI predicate = SSCVocabulary.FACTORY.createIRI(tripleResult.get(1).toString());
            IRI context = SSCVocabulary.FACTORY.createIRI(tripleResult.get(3).toString());
            if(tripleResult.get(2) instanceof Literal){
                Literal object = SSCVocabulary.FACTORY.createLiteral(tripleResult.get(2).toString());
                //tripleStatement = PDDLConverterVocabulary.FACTORY.createStatement(subject, predicate, object);
                builder.namedGraph(context).subject(subject).add(predicate, object);                
            }
            else{
                IRI object = SSCVocabulary.FACTORY.createIRI(tripleResult.get(2).toString());
                builder.namedGraph(context).subject(subject).add(predicate, object);
                //tripleStatement = PDDLConverterVocabulary.FACTORY.createStatement(subject, predicate, object);
            }
            //modelFromBinding.add(tripleStatement);
          
        }
        modelFromBinding = builder.build();
        System.out.println("There are ".concat(Integer.toString(modelFromBinding.size())).concat(" statements in the model"));
        return modelFromBinding;
    }
    
    private List<Model> getModelListByService(Model model){ 
       List<Model> fullModelList = new ArrayList<>();
       Set<Resource> ctxList = model.contexts();
       System.out.println("The list of context are " + ctxList);
       Iterator<Resource> itCtx = ctxList.iterator();
       
       while(itCtx.hasNext()){
           Resource ctx = itCtx.next();
           Model segmented = model.filter(null, null, null, ctx);
           fullModelList.add(segmented);
           System.out.println("For the context " + ctx.toString() + " the model is");
           //segmented.forEach(System.out::println);
       }
       return fullModelList;
    }
    /*private List<Model> createOfferList(Model m){
        List<Model> fullModelList;
        fullModelList = new ArrayList<>();
        
        //Extract the resources of type ontology and store them as a list
        List<Value> onto;
        List<String> ontoList = new ArrayList<>();
        Resource node = Models.objectIRI(m.filter(null, org.eclipse.rdf4j.model.vocabulary.RDF.TYPE, org.eclipse.rdf4j.model.vocabulary.OWL.ONTOLOGY)).orElse(null);
        if(node!=null){
            onto = RDFCollections.asValues(m, node, new ArrayList<Value>());
            for (Value ontoIt : onto) {
                ontoList.add(ontoIt.toString());
            }
            System.out.println("\n\n ******* the list of onto elements are ****** " + ontoList);
        }
        //Obtain the list of services from the model
        
        Model modelServices;        
        modelServices = m.filter(null, org.eclipse.rdf4j.model.vocabulary.RDF.TYPE, SSCVocabulary.servicesFilter);
        Model segmentedModel;        
        String serviceNamespace;
        for (Statement st: modelServices) {
            segmentedModel = new LinkedHashModel();
            IRI obj = (IRI)st.getSubject();
            serviceNamespace = obj.getNamespace();
            System.out.println("The services are " + obj);
            System.out.println("The namespace of the service is " + serviceNamespace);
            Model modelOnto;
            if(ontoList.contains(serviceNamespace)){
                IRI ontoDescrip = FACT.createIRI(serviceNamespace);
                modelOnto = m.filter(ontoDescrip, null, null);
                segmentedModel.addAll(modelOnto);
                modelOnto.getNamespaces().stream().forEach(segmentedModel::setNamespace);
            
                Model servDescrip = m.filter(obj, null , null);
                segmentedModel.addAll(servDescrip);
                servDescrip.getNamespaces().stream().forEach(segmentedModel::setNamespace);
                //Retrieve the object of the statements "describedBy" and "presents"
                for (Statement stServices: servDescrip) {
                    IRI objServ = (IRI)stServices.getObject();
                    if(!stServices.getPredicate().toString().contains(org.eclipse.rdf4j.model.vocabulary.RDF.TYPE.toString())){
                        Model modelProPro = m.filter(objServ, null , null);
                        segmentedModel.addAll(modelProPro);
                        modelProPro.getNamespaces().stream().forEach(segmentedModel::setNamespace);
                        /*for (Statement stProProStatement: modelProPro) {
                            Value paramTyp = stProProStatement.getObject();
                            if(!(paramTyp instanceof Literal)){
                                Model modelParam = model.filter((IRI)paramTyp, null , null);
                                segmentedModel.addAll(modelParam);
                                modelParam.getNamespaces().stream().forEach(segmentedModel::setNamespace);
                            }
                        }*/
                    /*}               
                }
            }
            System.out.println("The final resulted model is ");
            segmentedModel.forEach(System.out::println);
            System.out.println("The number of triples for the service ".concat(obj.toString()).concat(" is ").concat(Integer.toString(segmentedModel.size())));
            fullModelList.add(segmentedModel);
        }
        System.out.println("I created ".concat(Integer.toString(fullModelList.size())).concat(" models to create the files"));
        return fullModelList;
    }*/
    
    private void executePlanner() throws URISyntaxException, IOException{
        //Get the Domain
        Repository repoDomain = BTUtil.getInitializedRepository(this.getObject(), domainDefinitionQuery.getOriginBase());
        Model domainModel = domainDefinitionQuery.getResult(repoDomain);
        
        repoDomain = BTUtil.getInitializedRepository(this.getObject(), problemInitQuery.getOriginBase());
        Model problemInitModel = problemInitQuery.getResult(repoDomain);
        
        repoDomain = BTUtil.getInitializedRepository(this.getObject(), problemGoalQuery.getOriginBase());
        Model problemGoalModel = problemGoalQuery.getResult(repoDomain);
        
        //Create the folder
        String myPath = getClass().getResource("/").toURI().toString();
        String plannerFolder = "/planner/"; 
        URI plannerFolderURI = new URI(myPath.concat(plannerFolder));
        Path plannerFolderPath = Paths.get(plannerFolderURI);
        Files.createDirectories(plannerFolderPath);
        FileOutputStream outFile;
        
        //Decode the problemFile
        Base64 decoder = new Base64(); 
        for(Statement st:domainModel){
            //This loop should be run only once
            System.out.println("This message should appear only once. One PDDL domain in the LSR");
            Literal encodedObject = (Literal)st.getObject();
            byte[] encodedDomain = encodedObject.toString().getBytes();
            byte[] imgBytes = decoder.decode(encodedDomain);            
            File myAbsoluteFile = new File(plannerFolderPath.toString().concat("/WelcomeDomain.pddl"));  
            outFile = new FileOutputStream(myAbsoluteFile);
            outFile.write(imgBytes);
            outFile.flush();
            outFile.close();
        }
        
        //Create the Init
        Iterator<Statement> itProblemModel = problemInitModel.iterator();
        while(itProblemModel.hasNext()){
            File initFile = new File(plannerFolderPath.toString().concat("/WelcomeInit.pddl"));
            outFile = new FileOutputStream(initFile);
            RDFHandler writer = Rio.createWriter(RDFFormat.RDFXML, outFile);
            Rio.write(itProblemModel.next(), writer);
        } 
        
        //Create the Goal
        Iterator<Statement> itGoalModel = problemGoalModel.iterator();
        while(itGoalModel.hasNext()){
            File goalFile = new File(plannerFolderPath.toString().concat("/WelcomeGoal.pddl"));
            outFile = new FileOutputStream(goalFile);
            RDFHandler writer = Rio.createWriter(RDFFormat.RDFXML, outFile);
            Rio.write(itGoalModel.next(), writer);
        }  
    }
}
