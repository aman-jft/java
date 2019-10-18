package org.util.thread.a1;

public class Solution {
	
	public static void main(String[] args) {
//		run1();
//		run2();
		run3();
	}
	
	public static void run1() {
		ThreadSample ts = new ThreadSample();
		ThreadSample ts1 = new ThreadSample();
		Runnable r1 = ()-> {
			ts.m1();
		};
		Runnable r2 = ()-> {
			ts1.m2();
		};
		
		new Thread(r1).start();
		new Thread(r2).start();
	}
	
	public static void run2() {
		
		Runnable r1 = ()-> {
			ThreadSample.s1();
		};
		Runnable r2 = ()-> {
			ThreadSample.s2();
		};
		
		new Thread(r1).start();
		new Thread(r2).start();
	}
	
	public static void run3() {
		ThreadSample ts = new ThreadSample();
		ThreadSample ts1 = new ThreadSample();
		Runnable r1 = ()-> {
			ts.m3();
		};
		Runnable r2 = ()-> {
			ts1.m4();
		};
		
		new Thread(r1).start();
		new Thread(r2).start();
	}
}