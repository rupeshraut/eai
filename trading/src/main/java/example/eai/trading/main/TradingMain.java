package example.eai.trading.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class SpringCamelMain.
 */
public class TradingMain {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/camel-context.xml");
		Thread.sleep(Long.MAX_VALUE);
	}

}
