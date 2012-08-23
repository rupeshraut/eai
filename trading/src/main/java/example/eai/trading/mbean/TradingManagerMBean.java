package example.eai.trading.mbean;

/**
 * The Class TradingMBean.
 */
public interface TradingManagerMBean {

	/**
	 * Gets the info.
	 * 
	 * @return the info
	 */
	String getInfo();

	/**
	 * Start.
	 * 
	 * @return true, if successful
	 */
	boolean start();

	/**
	 * Stop.
	 * 
	 * @return true, if successful
	 */
	boolean stop();
}
