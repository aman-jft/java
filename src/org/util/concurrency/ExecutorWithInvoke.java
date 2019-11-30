package org.util.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ExecutorWithInvoke {
	static class Task implements Callable<String> {
		int i;

		public Task(int i) {
			this.i = i;
		}

		public String call() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return String.format("Thread: %s, Task: %d", Thread.currentThread().getName(), i);
		}
	}

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		List<Future<String>> list = new LinkedList<>();
		IntStream.range(1, 11).forEach(i -> {
			Future<String> f = pool.submit(new Task(i));
			list.add(f);
		});
		pool.shutdown();
		System.out.println("Done!!!");
		list.stream().forEach(f -> {
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
	}
}
