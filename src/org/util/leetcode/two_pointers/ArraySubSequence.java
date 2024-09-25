package org.util.leetcode.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySubSequence {

    public static List<List<Integer>> generateSubsequences(int[] arr) {
        // Helper function to generate subsequences
        return generateSubsequencesHelper(arr, 0);
    }

    private static List<List<Integer>> generateSubsequencesHelper(int[] arr, int index) {
        System.out.println("Called : " + index);
        // Base case: If the index is out of bounds, return a list with an empty subsequence
        if (index == arr.length) {
            System.out.println("->  " +index);
            List<List<Integer>> subsequences = new ArrayList<>();
            subsequences.add(new ArrayList<>()); // Empty subsequence
            return subsequences;
        }

        // Recursive case: Get all subsequences excluding the current element
        List<List<Integer>> subsequences = generateSubsequencesHelper(arr, index + 1);

        // Additional subsequences that include the current element
        List<List<Integer>> moreSubsequences = new ArrayList<>();

        for (List<Integer> subsequence : subsequences) {
            // Create a new subsequence that includes the current element
//            System.out.println(" => " + subsequence);
            List<Integer> newSubsequence = new ArrayList<>(subsequence);
            newSubsequence.add(0, arr[index]);
            System.out.println(subsequence + " => " +arr[index] + " <= " + newSubsequence);
            moreSubsequences.add(newSubsequence);
        }

        // Combine both lists of subsequences
        subsequences.addAll(moreSubsequences);
        return subsequences;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        List<List<Integer>> subsequences = generateSubsequences(arr);

        // Print all subsequences
        for (List<Integer> subsequence : subsequences) {
            System.out.println(subsequence);
        }
    }
}
