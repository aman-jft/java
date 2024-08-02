package org.util.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * The output will show the first ten elements generated by this process.
 * Let's walk through the first few iterations to understand the output:
 *
 *     Initial queue: [2020, 2018, 2005, 1967, 2000]
 *     Poll 2020 (largest), add 2019 back: Queue becomes [2019, 2018, 2005, 1967, 2000], print 2020
 *     Poll 2019, add 2018 back: Queue becomes [2018, 2018, 2005, 1967, 2000], print 2019
 *     Poll 2018, add 2017 back: Queue becomes [2018, 2017, 2005, 1967, 2000], print 2018
 *     Poll 2018, add 2017 back: Queue becomes [2017, 2017, 2005, 1967, 2000], print 2018
 *     Poll 2017, add 2016 back: Queue becomes [2017, 2016, 2005, 1967, 2000], print 2017
 *     Poll 2017, add 2016 back: Queue becomes [2016, 2016, 2005, 1967, 2000], print 2017
 *     Poll 2016, add 2015 back: Queue becomes [2016, 2015, 2005, 1967, 2000], print 2016
 *     Poll 2016, add 2015 back: Queue becomes [2015, 2015, 2005, 1967, 2000], print 2016
 *     Poll 2015, add 2014 back: Queue becomes [2015, 2014, 2005, 1967, 2000], print 2015
 *
 * The output is:
 *
 * yaml
 *
 * 2020
 * 2019
 * 2018
 * 2018
 * 2017
 * 2017
 * 2016
 * 2016
 * 2015
 * 2015
 *
 * The code snippet demonstrates how to use a priority queue with a custom comparator
 * and a stream to perform operations on the elements in a specific order.
 */
public class PriortyQueueTest {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
		/*Stream.of(2005,2020,2000,1967,2018)
        .map(YearWrapper::new)
        .sorted()
        .limit(10)
        .peek(year -> year.decreaseYear())
        .forEach(System.out::println);*/


        PriorityQueue<Integer> queue = Stream.of(2005,2020,2000,1967,2018)
                .collect(Collectors.toCollection(() -> new PriorityQueue(Comparator.reverseOrder())));

        Stream.generate(() -> {
            Integer year = queue.poll();
            queue.add(year - 1);
            return year;
        }).limit(10).forEach(System.out::println);
    }
}
