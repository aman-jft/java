package org.util.puzzles;

import java.util.stream.IntStream;

public class HunderedDoors {
	public static void main(String[] args) {
		/*
		 * Find out all the divisor of each number. If it is in pair to two then door will be closed.
		*/
		IntStream.rangeClosed(1, 100).filter(i -> findDivisor(i) % 2 != 0).forEach(System.out::println);
	}

	public static long findDivisor(int n) {
		return IntStream.rangeClosed(1, new Double(Math.sqrt(n)).intValue()).filter(i -> n % i == 0)
				.flatMap(i -> IntStream.of(i, n / i)).distinct().count();
	}
}
