package org.util.coforge;

import java.util.ArrayList;
import java.util.List;

public class Test1 {


    public static void main(String[] args) {
        String input = "aaaabaa";
        String pattern = "aaa";
        final List<String> strings = subStrings(input, pattern);
        final long count = strings.stream()
                                  .filter(s -> pattern.equals(s))
                                  .count();
        System.out.println(count);
    }

    // Sliding window
    private static List<String> subStrings(String input, String pattern) {
        List<String> subStrings = new ArrayList<>();
        if(pattern.length()<1 || pattern.length()>input.length()) {
            return subStrings;
        }
        for(int i=0;i<=input.length()-pattern.length();i++) {
            String str = input.substring(i, i+pattern.length());
            System.out.println(str);
            subStrings.add(str);
        }
        return subStrings;
    }
}
