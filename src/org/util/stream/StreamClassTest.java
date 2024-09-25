package org.util.stream;

import java.util.Arrays;

public class StreamClassTest {
    // List.toArray() vs Stream.toArray()
    public static void testToArray() {
        String input = "ABCD";
        char[] charArray = input.toCharArray();
        Character[] array = input.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        // List.toArray()
        System.out.println("1. " + Arrays.toString(Arrays.asList(1,2,3,4,5).toArray(new Integer[5])));
        System.out.println("2. " + Arrays.toString(Arrays.asList(1, 2, 3, 4, 5).toArray(new Integer[0])));


        System.out.println(array);
        System.out.println(charArray);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(charArray));
    }

    // Stream.collect()
    public static void main(String[] args) {
        testToArray();
    }
}
