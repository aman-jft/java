package org.util.goldmansachs;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortAlpha {
    public static void main(String[] args) {
        System.out.println(sort("acact"));
    }

    public static StringBuilder sort(String str) {
        final Map<Character, Long> collect = str.chars()
                                                .mapToObj(operand -> Character.valueOf((char) operand))
                                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return IntStream.range(97, 97 + 26)
                        .mapToObj(operand -> Character.valueOf((char) operand))
                        .peek(System.out::println)
                        .filter(value -> collect.containsKey(value))
                        .map(character -> IntStream.rangeClosed(1, collect.get(character)
                                                                          .intValue())
                                                   .collect(StringBuilder::new, (stringBuilder, value) -> stringBuilder.append(character), StringBuilder::append))
                        .peek(System.out::println)
                        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
    }
}
