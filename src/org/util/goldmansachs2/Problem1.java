package org.util.goldmansachs2;


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// class Solution {
//
// }


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There is one meeting room in the firm.
 * There are N meetings –
 * (Start time, end time)
 * (0,6)
 * (1,2)
 * (3,4)
 * (4,9)
 * (5,7)
 * (5,9)
 * (8,9)
 * Generate a schedule – with the objective of being able to accommodate the max number of meetings.
 * Sample input: {{0, 6}, {1, 2}, {3, 4}, {4, 9} ,{5, 7}, {5, 9}, {8, 9}}
 */
/*
(0,3)
(1,4)
(3,4)

A, B, C  -> A, AC, B, C
 */







public class Problem1 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");

        for (String string : strings) {
            System.out.println(string);
        }


        Integer[][] inputArr = {{0, 6}, {1, 2}, {3, 4}, {4, 9}, {5, 7}, {5, 9}, {8, 9}};
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(0, 6));
        input.add(Arrays.asList(1, 2));
        input.add(Arrays.asList(3, 4));
        input.add(Arrays.asList(4, 9));
        input.add(Arrays.asList(5, 7));
        input.add(Arrays.asList(5, 9));
        input.add(Arrays.asList(8, 9));
        for (
                int i = 0; i < input.size(); i++) {
            List<List<Integer>> combination = new ArrayList<>();
            List<Integer> first = input.get(i);
            combination.add(first);
            combination(input, combination, i);
            System.out.println(combination);
        }
    }


    public static void combination(List<List<Integer>> input, List<List<Integer>> combination, int startMeetingIndex) {
        if (startMeetingIndex >= input.size()) {
            return;
        }
        for (int i = startMeetingIndex + 1; i < input.size(); i++) {
            List<Integer> currentMeeting = input.get(i);
            Integer startTime = currentMeeting.get(0);
            List<Integer> lastMeeting = combination.get(combination.size() - 1);
            if (lastMeeting.get(1) <= startTime) {
                combination.add(currentMeeting);
                combination(input, combination, i);
            }

        }
    }
}
