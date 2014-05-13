package example.eai.trading.camel.route;


import org.apache.camel.spring.SpringRouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import example.eai.trading.camel.processor.request.QuoteRequestProducerProcessor;
import example.eai.trading.common.Constants;

/**
 * The Class MessageProducerRoute.
 */
@Component
public class QuoteRequestProducerRoute extends SpringRouteBuilder {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(QuoteRequestProducerRoute.class);

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

		from("timer://quoteRequestTimer?fixedRate=true&period=5000").process(new QuoteRequestProducerProcessor())
				.setHeader(Constants.REQUEST_TYPE, constant(Constants.QUOTE_REQUEST)).to("wmq:queue:jms/EaiInboundQueue");
	}// configure

}// class
