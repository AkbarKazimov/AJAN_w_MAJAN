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
        public final static IRI MustLinkConnectionsPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasMustLinkConnections");
        public final static IRI MustConnectPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasMustConnect");        
        public final static IRI CannotLinkConnectionsPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasCannotLinkConnections");
        public final static IRI CannotConnectPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasCannotConnect");        
        public final static IRI ParticipantsPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasParticipants");        
        public final static IRI WelcomeNamespace = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#");
        public final static IRI CsgpNamespace = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/csgp_ontology#");
        public final static IRI AjanNamespace = FACTORY.createIRI("http://www.ajan.de/ajan-ns#");
        public final static IRI ClanNamespace = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/cluster_analysis_ontology#");
        public final static IRI MacNamespace = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/mac_ontology#");
        public final static IRI HAS_MEMBERS = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/mac_ontology#hasMembers");        
        public final static IRI SolutionOfPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/mac_ontology#isSolutionOf");
        public final static IRI MemberOfPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/mac_ontology#isMemberOf");
        

        // CSGP Vocabulary
        public final static IRI BOSSType = FACTORY.createIRI("http://welcome/ajan/agentcoordination#BOSS");
        public final static IRI CsgpSolverType = FACTORY.createIRI("http://welcome/ajan/agentcoordination#CSGPSolver");
        public final static IRI CoalitionGeneratorType = FACTORY.createIRI("http://welcome/ajan/agentcoordination#CoalitionGenerator");
        public final static IRI MinCoalitionSizePre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasMinCoalitionSize");
        public final static IRI MaxCoalitionSizePre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasMaxCoalitionSize");        
        public final static IRI FeasibleCoalitionsPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasFeasibleCoalitions");        
        public final static IRI CsgpCoalitionObj = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#CSGPCoalition");        
        public final static IRI CsgpSolverPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#solver");        
        public final static IRI CsgpSolutionPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#csgpSolution");        
        public final static IRI COALITION_STRUCTURE = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#CoalitionStructure");        
        public final static IRI CsgpValuePre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/csgp_ontology#value");        
        public final static IRI CsgpCsRankPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/csgp_ontology#csRank");
        public final static IRI CsgpSolutionOfPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/csgp_ontology#solutionOf");        
        public final static IRI HAS_VALUE = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasValue");        
        public final static IRI HAS_SOLUTION = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasSolution");        
        public final static IRI HAS_RANK = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasRank");        
        public final static IRI HAS_SOLUTION_OF = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasSolutionOf");        

        
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

        public final static IRI ChcUseCaseObj = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#CHCUseCase");
        public final static IRI UseCaseIdPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#hasId");
        public final static IRI ComputedForPre = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#isComputedForProblemId");
        public final static IRI ChcDistanceScoreObj = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#CHCDistanceScore");
        public final static IRI DistanceScorePre = FACTORY.createIRI("http://www.ajan.de/ajan-ns#hasDistanceScore");
        public final static IRI LccUseCaseObj = FACTORY.createIRI("http://localhost:8090/rdf4j/repositories/welcome_ontology#LCCUseCase");
        
        public final static IRI SquareRootType = FACTORY.createIRI("http://www.ajan.de/behavior/bt-ns#SquareRoot");
        
        public final static IRI MATH_SUBJECT = FACTORY.createIRI("http://www.ajan.de/ajan-ns#MathSubject");
        public final static IRI math_HAS_VALUE = FACTORY.createIRI("http://www.ajan.de/ajan-ns#hasValue");
        public final static IRI math_HAS_RESULT_PREDICATE = FACTORY.createIRI("http://www.ajan.de/ajan-ns#hasResultPredicate");
        

}
