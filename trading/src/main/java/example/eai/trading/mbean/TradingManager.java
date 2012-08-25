package example.eai.trading.mbean;

import javax.management.MBeanRegistration;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class TradingMBeanImpl.
 */
public class TradingManager implements TradingManagerMBean, MBeanRegistration {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(TradingManager.class);

	/** The application context. */
	private AbstractApplicationContext applicationContext;

	/**
	 * 
	 * @see javax.management.MBeanRegistration#postDeregister()
	 */
	@Override
	public void postDeregister() {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("executing postDeregister()");
		}// if
	}// postDeregister()

	/**
	 * 
	 * 
	 * @param arg0
	 *            the arg0
	 * @see javax.management.MBeanRegistration#postRegister(java.lang.Boolean)
	 */
	@Override
	public void postRegister(Boolean arg0) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("executing postRegister()");
		}// if
	}// postRegister()

	/**
	 * 
	 * 
	 * @throws Exception
	 *             the exception
	 * @see javax.management.MBeanRegistration#preDeregister()
	 */
	@Override
	public void preDeregister() throws Exception {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("executing preDeregister()");
		}// if
	}// preDeregister()

	/**
	 * 
	 * 
	 * @param arg0
	 *            the arg0
	 * @param arg1
	 *            the arg1
	 * @return the object name
	 * @throws Exception
	 *             the exception
	 * @see javax.management.MBeanRegistration#preRegister(javax.management.MBeanServer
	 *      , javax.management.ObjectName)
	 */
	@Override
	public ObjectName preRegister(MBeanServer arg0, ObjectName arg1) throws Exception {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("executing preRegister()");
		}// if
		return null;
	}// preRegister()

	/**
	 * Start.
	 * 
	 * @return true, if successful
	 * @see example.eai.trading.mbean.TradingManagerMBean#start()
	 */
	@Override
	public boolean start() {

		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/camel-context.xml");
			return true;
		}// if

		if (!applicationContext.isRunning()) {
			applicationContext.refresh();
			applicationContext.start();
			return true;
		}// if
		return false;
	}

	/**
	 * Stop.
	 * 
	 * @return true, if successful
	 * @see example.eai.trading.mbean.TradingManagerMBean#stop()
	 */
	@Override
	public boolean stop() {
		if (applicationContext.isRunning()) {
			applicationContext.stop();
			return true;
		}// if
		return false;
	}

	/**
	 * Gets the info.
	 * 
	 * @return the info
	 * @see example.eai.trading.mbean.TradingMBean#getInfo()
	 */
	@Override
	public String getInfo() {
		return TradingManager.class.getName();
	}
}
