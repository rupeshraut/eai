package com.dev.ws.mathservice2014.impl;

import com.dev.ws.mathservice2014.Mathservice2014;

/**
 * The Class MathService2014Impl.
 */
public class MathService2014Impl implements Mathservice2014 {

	/**
	 * Adds the.
	 * 
	 * @param valOne
	 *            the val one
	 * @param valTwo
	 *            the val two
	 * @return the int
	 * @see com.dev.ws.mathservice2014.Mathservice2014#add(int, int)
	 */
	@Override
	public int add(int valOne, int valTwo) {
		return (valOne + valTwo);
	}

}
