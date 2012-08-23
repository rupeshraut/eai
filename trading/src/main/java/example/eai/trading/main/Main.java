package example.eai.trading.main;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.eai.trading.mbean.TradingManager;

/**
 * The Class Main.
 */
public class Main {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {
		
		final TradingManager beanImpl = new TradingManager();
		final String mbeanName = "example.eai.trading.mbean:type=TradingManagerMBean";
		final ObjectName objectName = new ObjectName(mbeanName);
		final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		mbs.registerMBean(beanImpl, objectName);
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Trading Manager Mbean server started");
		}// if
		TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
	}// main

}// class
