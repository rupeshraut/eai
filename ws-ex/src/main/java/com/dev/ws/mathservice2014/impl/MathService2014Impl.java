package com.dev.ws.mathservice2014.impl;

import com.dev.ws.mathservice2014.Mathservice2014;
import com.dev.ws.processor.ProcessingStrategyFactory;
import com.dev.ws.processor.Processor;
/**
 * The Class MathService2014Impl.
 */
public class MathService2014Impl implements Mathservice2014 {

    private final ProcessingStrategyFactory processingStrategyFactory;

    public MathService2014Impl(ProcessingStrategyFactory processingStrategyFactory) {
        System.out.println("created new instance of MathService2014Impl " + processingStrategyFactory);
        this.processingStrategyFactory = processingStrategyFactory;
    }

    /**
     * Adds the.
     *
     * @param valOne the val one
     * @param valTwo the val two
     * @return the int
     * @see com.dev.ws.mathservice2014.Mathservice2014#add(int, int)
     */
    @Override
    public int add(int valOne, int valTwo) {
        Processor processor = processingStrategyFactory.getStrategy(ProcessingStrategyFactory.STRATEGY_A);
        processor.process("STRATEGY_A");

        processor = processingStrategyFactory.getStrategy(ProcessingStrategyFactory.STRATEGY_B);
        processor.process("STRATEGY_B");

        processor = processingStrategyFactory.getStrategy(ProcessingStrategyFactory.STRATEGY_C);
        processor.process("STRATEGY_C");

        return (valOne + valTwo);
    }

}
