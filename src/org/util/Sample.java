package org.util;

import java.util.Arrays;
/*
* Find the common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: strs = ["flower","flow","flight"]
* Output: "fl"
* */
public class Sample {
    public static void main(String[] args) {
        String[] arr = {"dooo", "doo"};
        String[] arr1 = {"flower", "float", "floght"};
        String[] arr2 = {"do", "done", "do", "dpple"};
        System.out.println(Arrays.toString(arr) + " -> " + run(arr));
        System.out.println(Arrays.toString(arr1) + " -> " +run(arr1));
        System.out.println(Arrays.toString(arr2) + " -> " +run(arr2));
    }


    static String run(String[] arr) {
        String output = "";
        for (int i = 0; i < arr[0].length(); i++) {
            if (arr[0].length() <= i) break;
//            System.out.println("Checking for index: " + i);
            char ch = arr[0].charAt(i);
//            System.out.println("ch: " + ch);
            for (String input : arr) {
                if (input.length() <= i || ch != input.charAt(i)) {
//                    System.out.println("Checking: " + input);
                    return output;
                }
            }

            output += ch;
        }
        return output;
    }
}
