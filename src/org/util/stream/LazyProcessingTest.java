package org.util.stream;

import java.util.Comparator;
import java.util.OptionalInt;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LazyProcessingTest {

	public static void main(String[] args) {
		//slazy();
		System.out.println("##############");
		active();
	}
	public static void lazy() {
		IntStream s = new Random().ints().peek((i)->System.out.println(String.format("%d / %d = 4", i, 5))).filter(i-> i%5==4);
		System.out.println("*********Termination Operator*********");
		OptionalInt op = s.limit(10).findFirst();
		System.out.println("******************");
		System.out.println(op.isPresent()?op.getAsInt():"No Value");
	}
	
	public static void active() {
		IntStream s = new Random().ints().peek(i-> System.out.println("All : " + i)).filter(i-> i%5==4).peek(i-> System.out.println("Filter : " + i));
		System.out.println("*********Termination Operator*********");
		OptionalInt op = s.limit(10).sorted().peek(System.out::println).findFirst();
		System.out.println("******************");
		System.out.println(op.isPresent()?op.getAsInt():"No Value");
	}
}
