package example.eai.trading.camel.processor.request;

import java.util.Random;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import example.eai.trading.common.Symbol;
import example.eai.trading.oxm.repository.JAXBRepository;

/**
 * The Class QuoteRequestProducerProcessor.
 */
public  class QuoteRequestProducerProcessor implements Processor {
	
	/* (non-Javadoc)
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		int ordinal = new Random().nextInt(Symbol.values().length);
		final Symbol symbol = Symbol.values()[ordinal];
		exchange.getOut().setBody(JAXBRepository.createQuoteRequest(symbol.getCode()));
	}// process
}