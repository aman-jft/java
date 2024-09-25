package org.util.leetcode.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsCombinations {
    
    // Method to generate all permutations
    public static void generatePermutations(char[] array, int start, int end) {
        if (start == end) {
            System.out.println(String.valueOf(array));
        } else {
            for (int i = start; i <= end; i++) {
                swap(array, start, i);
                generatePermutations(array, start + 1, end);
                swap(array, start, i); // backtrack
            }
        }
    }

    // Helper method to swap elements
    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Method to generate all combinations
    public static void generateCombinations(char[] array, int start, List<Character> currentCombination, int combinationSize) {
        if (currentCombination.size() == combinationSize) {
            System.out.println(currentCombination);
            return;
        }
        
        for (int i = start; i < array.length; i++) {
            currentCombination.add(array[i]);
            generateCombinations(array, i + 1, currentCombination, combinationSize);
            currentCombination.remove(currentCombination.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        char[] array = {'c', 'a', 't'};
        Arrays.sort(array);
        // Generate all permutations
        System.out.println("Permutations:");
        generatePermutations(array, 0, array.length - 1);

        // Generate all combinations
        System.out.println("\nCombinations:");
        for (int i = 1; i <= array.length; i++) {
            System.out.println("Combinations of size " + i + ":");
            generateCombinations(array, 0, new ArrayList<>(), i);
        }
    }
}
