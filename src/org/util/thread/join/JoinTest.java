package org.util.thread.join;

import java.util.Random;

public class JoinTest {

	static Runnable printer = () -> {
		new Random().ints().limit(10).forEach((i) -> {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : " + i);
		});
	};

	public static void main(String[] args) throws InterruptedException{
		Thread t1 = new Thread(printer, "T1");
		t1.start();
		t1.join();
		Thread t2 = new Thread(printer, "T2");
		t2.start();
	}

}
