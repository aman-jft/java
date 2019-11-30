package org.util.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorWithExecute {
	static class Task extends Thread {
		int i;

		public Task(int i) {
			this.i = i;
		}

		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(String.format("Thread: %s, Task: %d", Thread.currentThread().getName(), i));
		}
	}

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);

		IntStream.range(1, 11).forEach(i -> pool.execute(new Task(i)));
		pool.shutdown();
	}
}
