package org.util.thread.sequence;

/*
 * Print in sequence Two threads printing odd & even number respectively 
 * T1	: 1 3 5 7 9
 * T2	: 2 4 6 8
 * O/P	: 1 2 3 4 5 6 7 8 9
 * */
public class Solution {
	static int i = 1;
	static Object lock = new Object();
	private static Runnable odd = () -> {
		while (i < 10) {
			synchronized (lock) {
				if (i % 2 == 1) {
					System.out.println(i++);
					lock.notifyAll();
				} else {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	};
	private static Runnable even = () -> {
		while (i < 10) {
			synchronized (lock) {
//				if (i % 2 == 0) {
//					System.out.println(i++);
//					lock.notifyAll();
//				} else {
//					try {
//						lock.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				while(i % 2 != 0) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(i++);
				lock.notifyAll();
			}
		}
	};

	public static void main(String[] args) {
		new Thread(odd).start();
		new Thread(even).start();
	}
}
