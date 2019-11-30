package org.util.thread;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class CustomThreadPool {
	
	public static void main(String[] args) {
		
	}
}

class Task implements Runnable {
	String s;
	public Task(String s) {
		this.s = s;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : " +this.s);
	}
}

class ThreadPool {
	private int count;
	public ThreadPool(int count) {
		this.count=count;
	}
	
	public void execute(BlockingQueue<Runnable> q) {
		Runnable runner = ()-> {
			while(true) {
				Runnable r;
				try {
					r = q.take();
					r.run();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		for(int i=1;i<=count;i++) {
			new Thread(runner).start();
		}
	}
}
