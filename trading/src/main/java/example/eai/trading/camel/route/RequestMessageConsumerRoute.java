package example.eai.trading.camel.route;

import org.apache.camel.spring.SpringRouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import example.eai.trading.camel.processor.request.QuoteRequestProcessor;
import example.eai.trading.camel.processor.request.TradeRequestProcessor;
import example.eai.trading.common.Constants;

/**
 * The Class MessageProducerRoute.
 */
@Component
public class RequestMessageConsumerRoute extends SpringRouteBuilder {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestMessageConsumerRoute.class);

	/**
	 *
	 * @throws Exception the exception
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
	public void configure() throws Exception {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(this.getClass().getName());
		}// if

			from("wmq:queue:jms/EaiInboundQueue")
			.unmarshal("jaxb")
			.choice()
			.when(header(Constants.REQUEST_TYPE).isEqualTo(Constants.QUOTE_REQUEST))
				.process(new QuoteRequestProcessor())
			.when(header(Constants.REQUEST_TYPE).isEqualTo(Constants.TRADE_REQUEST))
				.process(new TradeRequestProcessor())
			.end()
			.to("wmq:queue:jms/EaiOutboundQueue");
	}// configure

}// class
