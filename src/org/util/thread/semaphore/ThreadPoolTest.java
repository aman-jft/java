package org.util.thread.semaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.Function;
import java.util.stream.IntStream;

public class ThreadPoolTest {
	public static void main(String[] args) {
		int slots = 10;
		ExecutorService executorService = Executors.newFixedThreadPool(slots);
		ConnectionFactory factory = new ConnectionFactory(5);
		IntStream.range(0, slots).forEach(i -> executorService.execute(()-> System.out.println(factory.execute(i))));
		executorService.shutdown();
	}
}

class ConnectionFactory {
	private Semaphore sem;
	private Queue<Function> connections;

	public ConnectionFactory(int size) {
		sem = new Semaphore(size);
		connections = new ConcurrentLinkedQueue<>();
		IntStream.rangeClosed(1, size).forEach(i -> {
			connections.add((s) -> {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return String.format("Resource: %d, Input processed: %s", i, "" + s);
			});
		});
	}

	public String execute(Integer input) {
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Function<Integer, String> connection = connections.poll();
		try {
			return connection.apply(input);
		} finally {
			close(connection);
		}
	}

	public void close(Function<Integer, String> connection) {
		connections.add(connection);
		sem.release();
	}
}
