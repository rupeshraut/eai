/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.ws.processor;

/**
 *
 * @author rupesh
 */
public interface ProcessingStrategyFactory {

    String STRATEGY_A = "STRATEGY_A";
    String STRATEGY_B = "STRATEGY_B";
    String STRATEGY_C = "STRATEGY_C";
    /**
     *
     * @param strategyName
     * @return
     */
    Processor getStrategy(String strategyName);
}
