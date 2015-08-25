/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.ws.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author rupesh
 */
@Component("processorB")
@Scope(value = "prototype")
public class ProcessorB implements Processor {

    
    private static final Log LOG = LogFactory.getLog(ProcessorB.class);

    /**
     *
     * @param e
     * @return
     */
    @Override
    public Object process(Object e) {
        if (LOG.isInfoEnabled()) {
            LOG.info("proceesing using "+getClass().getName());
        }//if
        return e;
    }//process

}
