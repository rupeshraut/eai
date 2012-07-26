package example.eai.trading.camel.processor.request;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.eai.trading.common.Constants;
import example.eai.trading.oxm.domain.QuoteRequestType;
import example.eai.trading.oxm.domain.RequestType;
import example.eai.trading.oxm.repository.JAXBRepository;

/**
 * The Class QuoteRequestProcessor.
 */
public class QuoteRequestProcessor implements Processor {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(QuoteRequestProcessor.class);

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
		final RequestType requestType = (RequestType) exchange.getIn().getBody();
		final QuoteRequestType quoteRequestType = requestType.getQuoteRequest();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("==========================================================");
			LOGGER.info("Quote Request");
			LOGGER.info("==========================================================");
			LOGGER.info("Symbol {}", quoteRequestType.getSymbol());
			LOGGER.info("Timestamp {}", quoteRequestType.getTimestamp().getTime());
			LOGGER.info("==========================================================");
		}// if

		// setting quote response
		exchange.getOut().setHeader(Constants.RESPONSE_TYPE, Constants.QUOTE_RESPONSE);
		exchange.getOut().setBody(JAXBRepository.createQuoteResponse(quoteRequestType.getSymbol()));
	}// process()
}
