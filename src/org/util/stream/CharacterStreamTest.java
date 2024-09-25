package org.util.stream;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
/*
* https://leetcode.com/discuss/study-guide/1497123/subarrays-vs-subsequence-vs-subsets


* A subarray is a contiguous part of array and maintains relative ordering of elements. For an array/string of size n,
*  there are n*(n+1)/2 non-empty subarrays/substrings.

* A subsequence maintain relative ordering of elements but may or may not be a contiguous part of an array.
*  For a sequence of size n, we can have 2^n-1 non-empty sub-sequences in total.

* A subset MAY NOT maintain relative ordering of elements and can or cannot be a contiguous part of an array.
* For a set of size n, we can have (2^n) sub-sets in total.
* */
public class CharacterStreamTest {
    public static Set<Character> findNonUniqueCharacters(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.EMPTY_SET; // Return an empty set if input is null or empty
        }

        Map<Character, Long> charFrequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println( charFrequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                        .map(character -> character.toString())
                .collect(Collectors.joining(",")));
        return charFrequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        String testString = "aabbcdeff";
        Set<Character> result = findNonUniqueCharacters(testString);
        System.out.println("Non-unique characters: " + result); // [a, b, f]
    }
}
