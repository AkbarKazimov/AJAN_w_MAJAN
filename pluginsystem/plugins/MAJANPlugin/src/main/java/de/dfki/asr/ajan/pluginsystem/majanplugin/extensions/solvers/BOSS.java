/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.asr.ajan.pluginsystem.majanplugin.extensions.solvers;

import general.Combinations;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author akka02
 */
public class BOSS {
    public Map<int[][], Double[]> run(int numOfAgents, Collection<Map.Entry<Double, Double>> coalitions){
       /* System.out.println("num:" + numOfAgents);
        
        for (Map.Entry<Double, Double> entry : coalitions) {
            System.out.println("Coalition: "+
                    Arrays.toString(Combinations.convertCombinationFromBitToByteFormat(entry.getKey().intValue(), numOfAgents)));
            System.out.println("Value: "+entry.getValue());
        }*/
        
        csgpSolver.BOSS boss=new csgpSolver.BOSS();
        return boss.execute(numOfAgents, coalitions); 
    }
    public Map<int[][], Double[]> run(int numOfAgents, Map<int[], Double> coalitions){
       /* System.out.println("num:" + numOfAgents);
        
        for (Map.Entry<int[], Double> entry : coalitions.entrySet()) {
            System.out.println("Coalition: "+Arrays.toString(entry.getKey()));
            System.out.println("Value: "+entry.getValue());
        }*/
        
        csgpSolver.BOSS boss=new csgpSolver.BOSS();
        return boss.execute(numOfAgents, coalitions); 
    }
}
