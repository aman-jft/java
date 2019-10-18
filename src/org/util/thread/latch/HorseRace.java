package org.util.thread.latch;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class HorseRace {
	static final int NUM_THREAD = 25;
	static final CountDownLatch start = new CountDownLatch(1);
	static final CountDownLatch end = new CountDownLatch(NUM_THREAD - 1);

	static Map<String, Integer> result;

	public static void main(String[] args) {
		result = Collections.synchronizedMap(new HashMap<String, Integer>());
		startRace();
	}

	private static Runnable race = new Runnable() {
		public void run() {

			Random r = new Random();
			int t = r.nextInt(100) + 1;
			try {
				System.out.println(Thread.currentThread().getName() + " ready for race (" + t + ") seconds.");
				start.await();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {

				Thread.sleep(t * 10);
				System.out.println(Thread.currentThread().getName() + " finished race in " + t + " seconds.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result.put(Thread.currentThread().getName(), t);
			end.countDown();
			
		}
	};

	public static void startRace() {
		System.out.println("Start the race...");
		for (int i = 1; i < NUM_THREAD; i++) {
			Thread worker = new Thread(race);
			worker.setName("Horse - " + i);
			worker.start();
		}
		try {

			Thread.sleep(10 * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Get Set Go...");
		start.countDown();

		try {
			end.await();
			System.out.println("Race Ends...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("#############");
		Map.Entry<String, Integer> entry = result.entrySet().stream().sorted(Map.Entry.comparingByValue()).findFirst().get();
		System.out.println("Winner is... " + entry.getKey() + " completed race in " + entry.getValue() + " seconds.");
	}
}
