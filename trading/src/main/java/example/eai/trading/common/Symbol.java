package example.eai.trading.common;

import org.apache.commons.lang.StringUtils;

/**
 * The Enum Symbol.
 */
public enum Symbol {

	/** The fb. */
	Facebook("FB", 22.25),

	/** The Google. */
	Google("GOOG", 485.12),

	/** The Microsoft. */
	Microsoft("MSF", 12.23),

	/** The Oracle. */
	Oracle("ORCL", 56.44),

	/** The Yahoo. */
	Yahoo("YHOO", 18.69),

	/** The Bank of America. */
	BankOfAmerica("BAC", 12.56),

	/** The JP morgan a nd chase. */
	JPMorganAndChase("JPM", 35.78),

	/** The Wells fargo. */
	WellsFargo("WFC", 40.32),

	/** The Intel. */
	Intel("INTL", 60.25);

	/** The symbol. */
	private String code;

	/** The price. */
	private double price;

	/**
	 * Instantiates a new symbol.
	 * 
	 * @param inCode
	 *            the in symbol
	 */
	private Symbol(final String inCode, final double inPrice) {
		code = inCode;
		price = inPrice;
	}

	/**
	 * Gets the symbol.
	 * 
	 * @return the symbol
	 */
	public String getCode() {
		return code;
	}// getCode()

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}// getPrice()

	/**
	 * Gets the symbol.
	 * 
	 * @param inCode
	 *            the in code
	 * @return the symbol
	 */
	public static Symbol getSymbol(String inCode) {

		Symbol symbol = null;

		final Symbol[] symbols = values();

		for (Symbol currentSymbol : symbols) {
			if (StringUtils.equalsIgnoreCase(inCode, currentSymbol.getCode())) {
				symbol = currentSymbol;
				break;
			}// if
		}// for

		return symbol;
	}// getSymbol()

}// class
