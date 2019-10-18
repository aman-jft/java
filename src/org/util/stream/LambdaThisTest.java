package org.util.stream;

import java.util.OptionalInt;
import java.util.Random;

public class LambdaThisTest {
	int i=0;
	public static void main(String[] args) {
		new LambdaThisTest().test();
	}
	
	public void test() {
		this.i=5;
		// this inside lambda always refers to its surrounding class.
		OptionalInt op = new Random().ints().peek((i)->System.out.println(String.format("%d / %d = 4", i, this.i))).filter(i-> i%this.i==4).findFirst();
		System.out.println("******************");
		System.out.println(op.isPresent()?op.getAsInt():"No Value");
	}
}
