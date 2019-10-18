package org.util.thread.threadlocal;

public class ThreadLocalTest {

	static ThreadLocal<Integer> instance = new ThreadLocal<Integer>() {

		protected Integer initialValue() {
			return 1;
		}
	};

	private static class Sequence extends Thread {
		private int step;

		public Sequence(String threadName, int step) {
			super(threadName);
			this.step = step;
		}

		@Override
		public void run() {
			Integer i = instance.get();
			i=i*step;
			instance.set(i);
			System.out.println(Thread.currentThread().getName() + " : " + instance.get());
		}
	};

	public static void main(String[] args) {
		new Sequence("T1", 10).start();
		new Sequence("T2", 20).start();
		new Sequence("T3", 30).start();
	}
}
