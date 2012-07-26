package example.eai.trading.testcase;

import java.util.Random;

import example.eai.trading.common.Symbol;

public class Test {

	public static void main(String[] args) {

		Random random = new Random();

		for (int i = 0; i < 25; i++) {
			int ordinal = random.nextInt(Symbol.values().length);
			System.err.println(ordinal + "\t" + Symbol.values()[ordinal]);
		}
	}
}
