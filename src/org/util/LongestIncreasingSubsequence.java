package org.util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    // Function to find and print all longest increasing subsequences
    public static void findAllLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return;

        // Array of lists to store subsequences ending at each index
        List<List<Integer>> lis = new ArrayList<>();

        // Initialize with each number being a subsequence itself
        for (int i = 0; i < n; i++) {
            lis.add(new ArrayList<>());
            lis.get(i).add(nums[i]);
        }
        System.out.println(lis);
        // Build the LIS array of lists
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis.get(i).size() < lis.get(j).size() + 1) {
                    // Copy the increasing subsequence at index j and append nums[i]
                    lis.set(i, new ArrayList<>(lis.get(j)));
                    lis.get(i).add(nums[i]);
                }
            }
        }

        // Find the length of the longest increasing subsequences
        System.out.println(lis);
        int maxLength = 0;
        for (List<Integer> seq : lis) {
            if (seq.size() > maxLength) {
                maxLength = seq.size();
            }
        }

        // Print all subsequences with the maximum length
        System.out.println("All longest increasing subsequences:");
        for (List<Integer> seq : lis) {
            if (seq.size() == maxLength) {
                System.out.println(seq);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 20, 2, 1, 10, 1, 2, 3, 4, 40, 5, 6, 9, 7, 8};
        findAllLIS(nums);
    }
}
