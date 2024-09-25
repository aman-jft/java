package org.util.leetcode.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
* */
class PairSumMin {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        List<List<Integer>> pairs= new ArrayList();
        while(left<right) {
            pairs.add(Arrays.asList(nums[left++], nums[right--]));
        }
        return pairs.stream().map(l -> l.get(0)+l.get(1)).max(Integer::compareTo).get();
    }

    public static void main(String[] args) {
        PairSumMin s = new PairSumMin();
       // System.out.println(s.minPairSum(new int[]{3,5,2,3}));
        System.out.println(s.minPairSum(new int[]{4,1,5,1,2,5,1,5,5,4}));

    }
}