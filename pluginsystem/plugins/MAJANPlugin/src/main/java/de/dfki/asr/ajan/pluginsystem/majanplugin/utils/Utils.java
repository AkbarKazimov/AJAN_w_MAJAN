/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.asr.ajan.pluginsystem.majanplugin.utils;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.slf4j.Logger;

/**
 *
 * @author akka02
 */
public class Utils {
    public static void printRDF4JModel(Model model, Logger logger){
        logger.info("Start--Statements--\nSize:"+model.size());
        model.forEach((statement) -> {
            logger.info(statement.toString());
        });
        logger.info("End--Statements--");
    }
}
