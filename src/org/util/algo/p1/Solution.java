package org.util.algo.p1;

/**
 * Find all possible combination of given number array they can be added
 * [1,2,3,4] 1+2+3+4 1+2+3,1+3+4,1+2+4, 2+3+4, 1+2, 1+3, 1+4, 2+3, 2+4, 3+4
 */
public class Solution {
	//public static int[] n = {1,2,3,4};
	//public static char[] n = {'1','2','3','4','5','6'};
	public static char[] n = {'a','b','c','d','e','f'};
	public static void main(String[] args) {
		run();
	}

	private static void run() {
		combinations(0,"");
	}
	
	public static void combinations(int l, String number) {
		System.out.println(number);
		//System.out.println(String.format("L:%d, number:%s", l, number));
		
		for(int i=l;i<n.length;i++) {
			//System.out.println(number);
			number +=n[i];
			combinations(i+1, number);
			number = number==""?"":number.substring(0, number.length()-1);
		}
	}
}
