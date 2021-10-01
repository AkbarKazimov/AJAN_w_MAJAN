/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.dfki.asr.ajan.pluginsystem.majanplugin.vocabularies;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

/**
 *
 * @author root
 */
public class MAJANVocabulary {
        public final static ValueFactory FACTORY = SimpleValueFactory.getInstance();
        
        // MAC Vocabulary
        public final static IRI MacProblemInstanceObj = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#MACProblemInstance");
        public final static IRI MacProblemInstanceIdPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasMacProblemId");
        public final static IRI NumberOfAgentsPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasNumberOfAgents");
        public final static IRI MustLinkConnectionsPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#mustLinkConnections");
        public final static IRI MustConnectPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#mustConnect");        
        public final static IRI CannotLinkConnectionsPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#cannotLinkConnections");
        public final static IRI CannotConnectPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#cannotConnect");        
        public final static IRI ParticipantsPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasParticipants");        
        public final static IRI WelcomeNamespace = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#");
        public final static IRI CsgpNamespace = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/csgp_ontology#");
        public final static IRI AjanNamespace = FACTORY.createIRI("http://www.ajan.de/ajan-ns#");
        public final static IRI ClanNamespace = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/cluster_analysis_ontology#");
        public final static IRI MacNamespace = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/mac_ontology#");
        public final static IRI MembersPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/mac_ontology#hasMembers");        
        public final static IRI SolutionOfPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/mac_ontology#isSolutionOf");
        public final static IRI MemberOfPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/mac_ontology#isMemberOf");        


        // CSGP Vocabulary
        public final static IRI CsgpSolverType = FACTORY.createIRI("http://welcome/ajan/agentcoordination#CSGPSolver");
        public final static IRI CoalitionGeneratorType = FACTORY.createIRI("http://welcome/ajan/agentcoordination#CoalitionGenerator");
        public final static IRI MinCoalitionSizePre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#minCoalitionSize");
        public final static IRI MaxCoalitionSizePre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#maxCoalitionSize");        
        public final static IRI FeasibleCoalitionsPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#feasibleCoalitions");        
        public final static IRI CsgpCoalitionObj = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/csgp_ontology#CsgpCoalition");        
        public final static IRI CsgpSolverPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#solver");        
        public final static IRI CsgpSolutionPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#csgpSolution");        
        public final static IRI CsgpCoalitionStructureObj = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/csgp_ontology#CsgpCoalitionStructure");        
        public final static IRI CsgpValuePre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/csgp_ontology#value");        
        public final static IRI CsgpCsRankPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/csgp_ontology#csRank");
        public final static IRI CsgpSolutionOfPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/csgp_ontology#solutionOf");        

        
        // HDBSCAN Vocabulary
        public final static IRI HdbscanType = FACTORY.createIRI("http://welcome/ajan/agentcoordination#HDBSCAN");
        public final static IRI PerfectMatchScorePre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasPerfectMatchScore");        
        public final static IRI SubjectOfSimilarityPre = FACTORY.createIRI("http://www.ajan.de/ajan-ns#hasSubject");
        public final static IRI ObjectOfSimilarityPre = FACTORY.createIRI("http://www.ajan.de/ajan-ns#hasObject");
        public final static IRI SimilarityScorePre = FACTORY.createIRI("http://www.ajan.de/ajan-ns#hasSimilarityScore");
        public final static IRI ClusteringObj = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/cluster_analysis_ontology#Clustering");
        public final static IRI ClusterObj = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/cluster_analysis_ontology#Cluster");
        public final static IRI ClusterOfPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/cluster_analysis_ontology#isClusterOf");

       
        // Broadcast
        public final static IRI BROADCAST = FACTORY.createIRI("http://www.ajan.de/behavior/bt-ns#Broadcast");

       

}
