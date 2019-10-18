package org.util.stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class EffectiveFinalTest {
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		int x=5;
		//x=6;		// Lambda give compile time error that x should be final or effective final.
		OptionalInt op = IntStream.range(1,10).filter(i-> i==x).findFirst();
		System.out.println(op.isPresent()?op.getAsInt():"No Value");
	}
}
