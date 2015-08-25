package example.eai.trading.camel.processor.request;

import java.util.Random;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import example.eai.trading.common.Symbol;
import example.eai.trading.oxm.domain.BuySellIndicatorTypeEnum;
import example.eai.trading.oxm.repository.JAXBRepository;

public class TradeRequestProducerProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		int quantity = new Random().nextInt(500);

		int ordinal = new Random().nextInt(Symbol.values().length);
		final Symbol symbol = Symbol.values()[ordinal];

		exchange.getOut().setBody(JAXBRepository.createTradeRequest(symbol.getCode(), quantity, BuySellIndicatorTypeEnum.BUY));
	}// process
}