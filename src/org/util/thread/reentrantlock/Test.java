package org.util.thread.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class Test {
	ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) {
		Runnable r1 = () -> {
			Test t = new Test();
			t.m1();
			t.m2();
		};
		Runnable r2 = () -> new Test().m2();
		
		new Thread(r1).start();
		//new Thread(r2).start();
	}
	
	public void m1() {
		lock.lock();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("M1");
	}
	
	public void m2() {
		lock.unlock();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("M2");
	}
	
	
}
