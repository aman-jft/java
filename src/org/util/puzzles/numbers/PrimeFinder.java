package org.util.puzzles.numbers;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeFinder {
    public static Integer INTER_RANGE_LIMIT = 10;

    public static void main(String[] args) {

        final PrimeFinder primeFinder = new PrimeFinder();
        Long before = System.currentTimeMillis();
        final List<Integer> integers = primeFinder.divideAndFind(1, 100000);
        System.out.println("Time taken: " + (System.currentTimeMillis() - before));
        System.out.println(integers.size());
          System.out.println(integers);

//
//        final List<AbstractMap.SimpleImmutableEntry> ranges = primeFinder.divide(1, 100);
//        System.out.println(ranges);
    }

    private List<Integer> divideAndFind(Integer a1, Integer a2) {
        // Divide into smaller ranges
        Integer interRange = a2 / INTER_RANGE_LIMIT - 1;
        Map<Integer, Integer> ranges = new HashMap<>();
        Integer startWith = a1;
        for (Integer i = 1; i <= INTER_RANGE_LIMIT; i++) {
            ranges.put(startWith, startWith + interRange);
            startWith = startWith + interRange + 1;
        }

        return ranges.entrySet()
            .stream()
            .map(this::find)
            .flatMap(integers -> integers.stream())
            .collect(Collectors.toList());
    }

    private List<Integer> find(Map.Entry<Integer, Integer> range) {
        // Find prime
        return IntStream.range(range.getKey(), range.getValue())
            //.peek(System.out::println)
            .filter(this::isPrime3)
            .boxed()
            .collect(Collectors.toList());
    }
//
//
//    private List<AbstractMap.SimpleImmutableEntry> divide(Integer a1, Integer a2) {
//        if ((a2 - a1) > INTER_RANGE_LIMIT) {
//            final int interval = ((int) (a2 - a1) / INTER_RANGE_LIMIT)+1;
//
//        } else {
//            return Arrays.asList(new AbstractMap.SimpleImmutableEntry<Integer, Integer>(a1, a2));
//        }
//    }
    /**
     * Naive Approach
     * Time taken: 2447
     * 9592
     */
    private Boolean isPrime(Integer number) {
        if (number < 2)
            return false;              // Number should not be less than 1
        if (number == 2)
            return true;
        final boolean anyMatch = IntStream.range(2, number - 1)
            .anyMatch(i -> number % i == 0);
        return !anyMatch;
    }

    /**
     * Time taken: 95
     * 9592
     * <p>
     * <p>
     * If a number n is not a prime, it can be factored into two factors a and b:
     * <p>
     * n = a * b
     * Now a and b can't be both greater than the square root of n,
     * since then the product a * b would be greater than sqrt(n) * sqrt(n) = n.
     * So in any factorization of n, at least one of the factors must be
     * less than or equal to the square root of n, and if we can't find any factors
     * less than or equal to the square root, n must be a prime.
     */
    private Boolean isPrime3(Integer num) {
        if (num == 1)
            return false;
        if (num <= 3)
            return true;
        if (num % 2 == 0 || num % 3 == 0 || num % (int) Math.sqrt(num) == 0)
            return false;
        for (int i = 4; i < (int) Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
