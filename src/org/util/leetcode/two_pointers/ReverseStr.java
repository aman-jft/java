package org.util.leetcode.two_pointers;

/*
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * */
public class ReverseStr {
    public static String reverseWords(String s) {

        int LEFT = s.length(), RIGHT = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                LEFT = i + 1;
            } else if (i == 0) {
                LEFT = i;
            }
            if (LEFT < RIGHT) {
                sb.append(s.substring(LEFT, RIGHT));
                LEFT = i;
                RIGHT = i;
                if(i!=0) sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
