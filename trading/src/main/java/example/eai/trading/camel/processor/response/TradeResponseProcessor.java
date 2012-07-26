package example.eai.trading.camel.processor.response;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.eai.trading.oxm.domain.ResponseType;
import example.eai.trading.oxm.domain.TradeResponseType;

/**
 * The Class QuoteRequestProcessor.
 */
public class TradeResponseProcessor implements Processor {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(TradeResponseProcessor.class);

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
		final TradeResponseType tradeResponseType = responseType.getTradeResponse();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("==========================================================");
			LOGGER.info("Trade Response");
			LOGGER.info("==========================================================");
			LOGGER.info("Symbol {}", tradeResponseType.getSymbol());
			LOGGER.info("Buy/Sell Indicator {}", tradeResponseType.getBuySellIndicator());
			LOGGER.info("Quantity {}", tradeResponseType.getQuantity());
			LOGGER.info("Quote Price {}", tradeResponseType.getQuotePrice());
			LOGGER.info("Price {}", tradeResponseType.getPrice());
			LOGGER.info("Timestamp {}", tradeResponseType.getTimestamp().getTime());
			LOGGER.info("==========================================================");
		}// if

	}// process()
}
