package example.eai.trading.camel.processor.response;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.eai.trading.oxm.domain.QuoteResponseType;
import example.eai.trading.oxm.domain.ResponseType;

/**
 * The Class QuoteRequestProcessor.
 */
public class QuoteResponseProcessor implements Processor {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(QuoteResponseProcessor.class);

	/**
	 * 
	 * @param exchange
	 *            the exchange
	 * @throws Exception
	 *             the exception
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		final ResponseType responseType = (ResponseType) exchange.getIn().getBody();
		final QuoteResponseType quoteResponseType = responseType.getQuoteResponse();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("==========================================================");
			LOGGER.info("Quote Response");
			LOGGER.info("==========================================================");
			LOGGER.info("Symbol {}", quoteResponseType.getSymbol());
			LOGGER.info("Price {}", quoteResponseType.getPrice());
			LOGGER.info("Timestamp {}", quoteResponseType.getTimestamp().getTime());
			LOGGER.info("==========================================================");
		}// if

	}// process()
}
