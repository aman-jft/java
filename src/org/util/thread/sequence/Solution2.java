package org.util.thread.sequence;

/*
 * Print in sequence Two threads printing odd & even number respectively 
 * T1	: 1 3 5 7 9
 * T2	: 2 4 6 8
 * O/P	: 1 2 3 4 5 6 7 8 9
 * */
public class Solution2 {
	static int i = 1;
	final static int MAX = 100;
	static Object lock = new Object();

	private static class Sequence extends Thread {
		private int reminder;

		public Sequence(String threadName, int reminder) {
			super(threadName);
			this.reminder = reminder;
		}

		public void run() {
			while (i < MAX) {
				synchronized (lock) {
					while (i % 3 != reminder) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					System.out.println(Thread.currentThread().getName() + " : " + i++);
					lock.notifyAll();
				}
			}
		}

	}

	public static void main(String[] args) {
		new Sequence("T1", 0).start();
		new Sequence("T2", 1).start();
		new Sequence("T3", 2).start();
	}
}
