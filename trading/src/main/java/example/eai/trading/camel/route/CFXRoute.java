package example.eai.trading.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.spring.SpringRouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class FTPConsumerRoute.
 */
//@Component
public class CFXRoute extends SpringRouteBuilder {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CFXRoute.class);

	/**
	 * 
	 * @throws Exception
	 *             the exception
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
	public void configure() throws Exception {
		from("serviceEndpoint").process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("{}", exchange.getIn().getBody());
				}// if
			}
		}).to("file://test");
	}// configure()

}// class
