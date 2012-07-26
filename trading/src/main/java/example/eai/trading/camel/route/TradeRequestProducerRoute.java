package example.eai.trading.camel.route;

import java.util.Random;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.spring.SpringRouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import example.eai.trading.common.Constants;
import example.eai.trading.common.Symbol;
import example.eai.trading.oxm.domain.BuySellIndicatorTypeEnum;
import example.eai.trading.oxm.repository.JAXBRepository;

/**
 * The Class MessageProducerRoute.
 */
@Component
public class TradeRequestProducerRoute extends SpringRouteBuilder {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(TradeRequestProducerRoute.class);

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

		from("timer://tradeRequestTimer?fixedRate=true&period=5000").process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				int quantity = new Random().nextInt(500);

				int ordinal = new Random().nextInt(Symbol.values().length);
				final Symbol symbol = Symbol.values()[ordinal];

				exchange.getOut().setBody(JAXBRepository.createTradeRequest(symbol.getCode(), quantity, BuySellIndicatorTypeEnum.BUY));
			}// process
		}).setHeader(Constants.REQUEST_TYPE, constant(Constants.TRADE_REQUEST)).to("wmq:queue:jms/EaiInboundQueue");

	}// configure

}// class
