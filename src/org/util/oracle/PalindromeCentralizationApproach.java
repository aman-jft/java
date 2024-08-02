package org.util.oracle;

import java.util.HashSet;
import java.util.Set;

public class PalindromeCentralizationApproach {
    public static Set<String> findAllPalindromesUsingCenter(String input) {
        Set<String> palindromes = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            palindromes.addAll(findPalindromes(input, i, i + 1));
            palindromes.addAll(findPalindromes(input, i, i));
        }
        return palindromes;
    }

    private static Set<String> findPalindromes(String input, int low, int high) {
        Set<String> result = new HashSet<>();
        System.out.println(low+" "+ high);
        while (low >= 0 && high < input.length() && input.charAt(low) == input.charAt(high)) {
            System.out.println(input.substring(low, high + 1));
            result.add(input.substring(low, high + 1));
            low--;
            high++;
        }
        return result;
    }

    public static void main(String[] args) {

        final Set<String> aabaa = findAllPalindromesUsingCenter("ABBA");
        System.out.println(aabaa);
    }
}
