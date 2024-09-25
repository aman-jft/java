package org.util.leetcode.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* */
public class ArraySum {
//    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
    public Integer[][] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        List<List<Integer>> pair = new ArrayList<>();

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                pair.add(Arrays.asList(left+1, right+1));
//                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return pair.stream()
                .map(sublist -> sublist.stream().toArray(Integer[]::new))  // Convert each sublist to int[]
                .toArray(Integer[][]::new);
    }

// https://leetcode.com/problems/3sum/description/
    public Integer[][] threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        // Sort the array to simplify the logic
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates to avoid redundant triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the second and third elements of the triplet
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }


        Integer[][] array = triplets.stream().map(sublist -> sublist.stream().toArray(Integer[]::new)).toArray(Integer[][]::new);
        System.out.println(Arrays.deepToString(array));
        return triplets.stream()
                .map(sublist -> sublist.stream().toArray(Integer[]::new))  // Convert each sublist to int[]
                .toArray(Integer[][]::new);   // Collect the arrays into a 2D array
    }

    public static void main(String[] args) {
        ArraySum arraySum = new ArraySum();
        int[] numbers = {2, 2,7, 7};
        int target = 9;
        Integer[][] result = arraySum.twoSum(numbers, target);
        System.out.println("Indices of the two numbers that add up to " + target + " are: " + Arrays.deepToString(result));


        int[] nums = {-1, 0, 1, 2, -1, -4};
        Integer[][] integers = arraySum.threeSum(nums);
        System.out.println("Triplets that sum to 0 are: " + Arrays.deepToString(integers));
        /*
        * Output:
        * Indices of the two numbers that add up to 9 are: 1, 2
        * Triplets that sum to 0 are: [[-1, -1, 2], [-1, 0, 1]]
        * */
    }
}
