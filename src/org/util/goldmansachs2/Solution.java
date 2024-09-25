package org.util.goldmansachs2;

import java.util.*;

public class Solution {

  private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

  static int[] longestUniformSubstring(String input){
    int longestStart = -1;
    int longestLength = 0;

    int startIndex = 0;
    int maxLength = 1;
    for(int i=1; i< input.length();i++) {
        if(input.charAt(i)==input.charAt(i-1)) {
          maxLength++;
        } else {
          if(maxLength>longestLength) {
            longestStart = startIndex;
            longestLength = maxLength;
          }
          startIndex = i;
          maxLength = 1;
        }
    }
    // todo: implement the longestUniformSubstring logic
    return new int[]{ longestStart, longestLength };
  }

  public static void main(String[] args) {
     testCases.put("", new int[]{-1, 0});
     testCases.put("10000111", new int[]{1, 4});
    testCases.put("aab", new int[]{0, 2});
    // todo: implement more tests, please
    // feel free to make testing more elegant

    boolean pass = true;
    for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
      int[] result = longestUniformSubstring(testCase.getKey());
      pass = pass && (Arrays.equals(result, testCase.getValue()));
    }
    if(pass){
      System.out.println("All tests pass!");
    } else {
      System.out.println("At least one failure! :( ");
    }
  }
}