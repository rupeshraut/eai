package example.eai.trading.camel.route;

import org.apache.camel.spring.SpringRouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import example.eai.trading.camel.processor.response.QuoteResponseProcessor;
import example.eai.trading.camel.processor.response.TradeResponseProcessor;
import example.eai.trading.common.Constants;

/**
 * The Class MessageProducerRoute.
 */
@Component
public class ResponseMessageConsumerRoute extends SpringRouteBuilder {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseMessageConsumerRoute.class);

	/**
	 * 
	 * @throws Exception
	 *             the exception
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
	public void configure() throws Exception {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(this.getClass().getName());
		}// if
		
		from("wmq:queue:jms/EaiOutboundQueue")
		.unmarshal("jaxb")
		.choice()
		.when(header(Constants.RESPONSE_TYPE).isEqualTo(Constants.QUOTE_RESPONSE))
			.process(new QuoteResponseProcessor())
		.when(header(Constants.RESPONSE_TYPE).isEqualTo(Constants.TRADE_RESPONSE))
			.process(new TradeResponseProcessor());
	}// configure

}// class
