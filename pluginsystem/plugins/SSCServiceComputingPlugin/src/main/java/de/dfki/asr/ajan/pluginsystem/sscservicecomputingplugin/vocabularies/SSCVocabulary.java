/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.dfki.asr.ajan.pluginsystem.sscservicecomputingplugin.vocabularies;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

/**
 *
 * @author ejara
 */
public class SSCVocabulary {
    public final static ValueFactory FACTORY = SimpleValueFactory.getInstance();
    public final static IRI SSCType = FACTORY.createIRI("http://welcome/ajan/servicecomputing#");
    public final static IRI SSCName = FACTORY.createIRI("http://www.ajan.de/behavior/scs-ns#SSCPlugin");
    public final static IRI SSCPred = FACTORY.createIRI("http://www.ajan.de/behavior/scs-ns#hasResultOffer");
    public final static IRI profileFilter = FACTORY.createIRI("http://www.daml.org/services/owl-s/1.1/Profile.owl#Profile");
    public final static IRI servicesFilter = FACTORY.createIRI("http://www.daml.org/services/owl-s/1.1/Service.owl#Service");
}
