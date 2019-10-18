package org.util.thread.barrier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tournament {
	static final int NUM_THREAD = 125;
	static int j = 1;
	static CyclicBarrier BARRIER;
	static Map<String, String> partialResult = Collections.synchronizedMap(new HashMap<String, String>());

	public static void main(String[] args) {
		List<String> participant = IntStream.rangeClosed(1, NUM_THREAD).mapToObj(i -> "Horse - " + i)
				.collect(Collectors.toList());

		Runnable reMatch = () -> {
			if (partialResult.size() > 1) {
				List<String> newParticipant = new ArrayList<String>(partialResult.values());
				partialResult.clear();
				BARRIER = new CyclicBarrier(1, () ->{
					System.out.println(Thread.activeCount());
					System.out.println("Ultimate Champion : " + partialResult.get("Final - " + j));
				});
				Match m = new Match("Final - " + j, newParticipant);
				m.start();
			}
		};

		BARRIER = new CyclicBarrier(5, reMatch);
		schedule(participant);
	}

	public static void schedule(List<String> participant) {
		int n = participant.size();
		int teamSize = n / 5;

		int i = 0;

		while (i < n) {
			List<String> batch = participant.subList(i, i + teamSize);
			i = i + teamSize;
			Match m = new Match("Batch - " + j, batch);
			j++;
			System.out.println("Starting the race: " + m.matchId);
			System.out.println("Participant are : ");
			m.participant.forEach(System.out::println);
			m.start();
		}
	}

	static class Match extends Thread {
		String matchId;
		List<String> participant;

		public Match(String matchId, List<String> participant) {
			this.matchId = matchId;
			this.participant = participant;
		}

		@Override
		public void run() {
			partialResult.put(matchId, participant.get(0));
			try {
				BARRIER.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
