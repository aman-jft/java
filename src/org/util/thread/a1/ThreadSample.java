package org.util.thread.a1;

public class ThreadSample {
	private int resource = 100;
	public synchronized void m1() {
		System.out.println("M1");
		try {
			System.out.println("Waiting in M1");
			Thread.sleep(5000);
			System.out.println("Resumed in M1");
		} catch (Exception ex) {

		}
	}

	public synchronized void m2() {
		System.out.println("M2");
		try {
			System.out.println("Waiting in M2");
			Thread.sleep(1000);
			System.out.println("Resumed in M2");
		} catch (Exception ex) {

		}
	}

	public void m3() {
		System.out.println("M3");
		synchronized (this) {
			
			resource++;
			System.out.println("Resource in M3: " + resource);
			try {
				System.out.println("Waiting in M3");
				Thread.sleep(10000);
				System.out.println("Resumed in M3");
			} catch (Exception ex) {

			}
		}
	}

	public void m4() {
		System.out.println("M4");
		
		synchronized (this) {
			resource++;
			System.out.println("Resource in M4: " + resource);
			try {
				System.out.println("Waiting in M4");
				Thread.sleep(5000);
				System.out.println("Resumed in M4");
			} catch (Exception ex) {

			}
		}
	}

	public static synchronized void s1() {
		System.out.println("S1");
		try {
			System.out.println("Waiting in S1");
			Thread.sleep(5000);
			System.out.println("Resumed in S1");
		} catch (Exception ex) {

		}
	}

	public static synchronized void s2() {
		System.out.println("S2");
		try {
			System.out.println("Waiting in S2");
			Thread.sleep(1000);
			System.out.println("Resumed in S2");
		} catch (Exception ex) {

		}
	}
}
