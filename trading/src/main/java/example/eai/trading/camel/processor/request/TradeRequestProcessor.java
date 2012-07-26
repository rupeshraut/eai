package example.eai.trading.camel.processor.request;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.eai.trading.common.Constants;
import example.eai.trading.oxm.domain.RequestType;
import example.eai.trading.oxm.domain.TradeRequestType;
import example.eai.trading.oxm.repository.JAXBRepository;

/**
 * The Class QuoteRequestProcessor.
 */
public class TradeRequestProcessor implements Processor {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(TradeRequestProcessor.class);

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
		final TradeRequestType tradeRequestType = requestType.getTradeRequest();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("==========================================================");
			LOGGER.info("Trade Request");
			LOGGER.info("==========================================================");
			LOGGER.info("Symbol {}", tradeRequestType.getSymbol());
			LOGGER.info("Buy/Sell Indicator {}", tradeRequestType.getBuySellIndicator());
			LOGGER.info("Quantity {}", tradeRequestType.getQuantity());
			LOGGER.info("Timestamp {}", tradeRequestType.getTimestamp().getTime());
			LOGGER.info("==========================================================");
		}// if

		// setting quote response
		exchange.getOut().setHeader(Constants.RESPONSE_TYPE, Constants.TRADE_RESPONSE);
		exchange.getOut().setBody(JAXBRepository.createTradeResponse(tradeRequestType.getSymbol(), tradeRequestType.getQuantity(), tradeRequestType.getBuySellIndicator()));
	}// process()
}
