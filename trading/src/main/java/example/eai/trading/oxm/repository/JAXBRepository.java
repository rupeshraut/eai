package example.eai.trading.oxm.repository;

import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.eai.trading.common.Symbol;
import example.eai.trading.oxm.domain.BuySellIndicatorTypeEnum;
import example.eai.trading.oxm.domain.CodeTypeEnum;
import example.eai.trading.oxm.domain.FaultType;
import example.eai.trading.oxm.domain.FaultTypeEnume;
import example.eai.trading.oxm.domain.ObjectFactory;
import example.eai.trading.oxm.domain.QuoteRequestType;
import example.eai.trading.oxm.domain.QuoteResponseType;
import example.eai.trading.oxm.domain.RequestType;
import example.eai.trading.oxm.domain.ResponseType;
import example.eai.trading.oxm.domain.RoutingContextType;
import example.eai.trading.oxm.domain.TradeRequestType;
import example.eai.trading.oxm.domain.TradeResponseType;

/**
 * The Class Main.
 */
public class JAXBRepository {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(JAXBRepository.class);

	/** The Constant OBJECT_FACTORY. */
	private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

	/** The jaxb context. */
	private static JAXBContext jaxbContext;

	/** The marshaller. */
	private static Marshaller marshaller;

	static {
		try {
			jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			marshaller = jaxbContext.createMarshaller();
		} catch (JAXBException e) {
			LOGGER.error("error occurred while creating JAXB marshaller", e);
		}// try-catch
	}// static

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public static void main(final String[] args) throws JAXBException {

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("\n{}", createRoutingContext());
		}// if

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("\n{}", createQuoteRequest(Symbol.Microsoft.getCode()));
		}// if

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("\n{}", createQuoteResponse(Symbol.Microsoft.getCode()));
		}// if

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("\n{}", createTradeRequest(Symbol.Microsoft.getCode(), 100, BuySellIndicatorTypeEnum.BUY));
		}// if

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("\n{}", createTradeResponse(Symbol.Microsoft.getCode(), 100, BuySellIndicatorTypeEnum.BUY));
		}// if

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("\n{}", createFaultResponse());
		}// if

	}// main()

	/**
	 * Creates the routing context.
	 * 
	 * @return the string
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public static String createRoutingContext() throws JAXBException {
		final StringWriter stringWriter = new StringWriter();
		try {
			final RoutingContextType routingContextType = OBJECT_FACTORY.createRoutingContextType();
			routingContextType.setTimestamp(getCalendar());
			routingContextType.setInvoker("Invoker");
			UUID uuid = UUID.randomUUID();
			routingContextType.setMessageId(uuid.toString());
			final JAXBElement<RoutingContextType> requestElement = OBJECT_FACTORY.createRoutingContext(routingContextType);

			marshaller.marshal(requestElement, stringWriter);
		} finally {
			IOUtils.closeQuietly(stringWriter);
		}// finally

		return stringWriter.toString();
	}// createRequest()

	/**
	 * Creates the request.
	 * 
	 * @param inSymbol
	 *            the in symbol
	 * @return the string
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public static String createQuoteRequest(final String inSymbol) throws JAXBException {
		final StringWriter stringWriter = new StringWriter();
		try {
			final QuoteRequestType quoteRequestType = OBJECT_FACTORY.createQuoteRequestType();
			quoteRequestType.setSymbol(inSymbol);
			quoteRequestType.setTimestamp(getCalendar());

			final RequestType requestType = OBJECT_FACTORY.createRequestType();
			requestType.setQuoteRequest(quoteRequestType);

			final JAXBElement<RequestType> requestElement = OBJECT_FACTORY.createRequest(requestType);

			marshaller.marshal(requestElement, stringWriter);

		} finally {
			IOUtils.closeQuietly(stringWriter);
		}// finally

		return stringWriter.toString();
	}// createRequest()

	/**
	 * Creates the response.
	 * 
	 * @param inSymbol
	 *            the in symbol
	 * @return the string
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public static String createQuoteResponse(final String inSymbol) throws JAXBException {
		final StringWriter stringWriter = new StringWriter();
		try {
			final QuoteResponseType quoteResponseType = OBJECT_FACTORY.createQuoteResponseType();
			quoteResponseType.setSymbol(inSymbol);
			quoteResponseType.setPrice(Symbol.getSymbol(inSymbol).getPrice());
			quoteResponseType.setTimestamp(getCalendar());

			final ResponseType responseType = OBJECT_FACTORY.createResponseType();
			responseType.setQuoteResponse(quoteResponseType);

			final JAXBElement<ResponseType> requestElement = OBJECT_FACTORY.createResponse(responseType);

			marshaller.marshal(requestElement, stringWriter);
		} finally {
			IOUtils.closeQuietly(stringWriter);
		}// finally

		return stringWriter.toString();
	}// createRequest()

	/**
	 * Creates the fault response.
	 * 
	 * @return the string
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public static String createFaultResponse() throws JAXBException {
		final StringWriter stringWriter = new StringWriter();
		try {
			final FaultType faultType = OBJECT_FACTORY.createFaultType();
			faultType.setCode(CodeTypeEnum.A_100);
			faultType.setType(FaultTypeEnume.ERROR);
			faultType.setDetail("Error detials");

			final ResponseType responseType = OBJECT_FACTORY.createResponseType();
			responseType.setFault(faultType);

			final JAXBElement<ResponseType> requestElement = OBJECT_FACTORY.createResponse(responseType);

			marshaller.marshal(requestElement, stringWriter);
		} finally {
			IOUtils.closeQuietly(stringWriter);
		}// finally

		return stringWriter.toString();
	}// createRequest()

	/**
	 * Creates the trade request.
	 * 
	 * @param inSymbol
	 *            the in symbol
	 * @param inQuantity
	 *            the in quantity
	 * @param inBuySellIndicatorTypeEnum
	 *            the in buy sell indicator type enum
	 * @return the string
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public static String createTradeRequest(final String inSymbol, final int inQuantity, final BuySellIndicatorTypeEnum inBuySellIndicatorTypeEnum)
			throws JAXBException {
		final StringWriter stringWriter = new StringWriter();
		try {
			final TradeRequestType tradeRequestType = OBJECT_FACTORY.createTradeRequestType();
			tradeRequestType.setSymbol(inSymbol);
			tradeRequestType.setBuySellIndicator(inBuySellIndicatorTypeEnum);
			tradeRequestType.setQuantity(inQuantity);
			tradeRequestType.setTimestamp(getCalendar());

			final RequestType requestType = OBJECT_FACTORY.createRequestType();
			requestType.setTradeRequest(tradeRequestType);

			final JAXBElement<RequestType> requestElement = OBJECT_FACTORY.createRequest(requestType);

			marshaller.marshal(requestElement, stringWriter);
		} finally {
			IOUtils.closeQuietly(stringWriter);
		}// finally

		return stringWriter.toString();
	}// createRequest()

	/**
	 * Creates the fault response.
	 * 
	 * @param inSymbol
	 *            the in symbol
	 * @param inQuantity
	 *            the in quantity
	 * @param inBuySellIndicatorTypeEnum
	 *            the in buy sell indicator type enum
	 * @return the string
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public static String createTradeResponse(final String inSymbol, final int inQuantity, final BuySellIndicatorTypeEnum inBuySellIndicatorTypeEnum)
			throws JAXBException {
		final StringWriter stringWriter = new StringWriter();
		try {
			final TradeResponseType tradeResponseType = OBJECT_FACTORY.createTradeResponseType();
			tradeResponseType.setSymbol(inSymbol);
			tradeResponseType.setBuySellIndicator(inBuySellIndicatorTypeEnum);
			tradeResponseType.setQuantity(inQuantity);
			tradeResponseType.setQuotePrice(Symbol.getSymbol(inSymbol).getPrice());
			tradeResponseType.setTimestamp(getCalendar());
			tradeResponseType.setPrice(inQuantity * Symbol.getSymbol(inSymbol).getPrice());

			final ResponseType responseType = OBJECT_FACTORY.createResponseType();
			responseType.setTradeResponse(tradeResponseType);

			final JAXBElement<ResponseType> requestElement = OBJECT_FACTORY.createResponse(responseType);

			marshaller.marshal(requestElement, stringWriter);
		} finally {
			IOUtils.closeQuietly(stringWriter);
		}// finally

		return stringWriter.toString();
	}// createRequest()

	/**
	 * Gets the calendar.
	 * 
	 * @return the calendar
	 */
	private static Calendar getCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar;
	}// getCalendar()

}// Main
