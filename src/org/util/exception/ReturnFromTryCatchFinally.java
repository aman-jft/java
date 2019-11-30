package org.util.exception;

public class ReturnFromTryCatchFinally {
	public static void main(String[] args) {
		System.out.println(test());
	}

	public static int test() {
		try {
			//throw new IllegalAccessException();
			return 1;
		} catch (Exception ex) {
			System.out.println("Catch");
			return 2;
		} finally {
			System.out.println("Finally");
			//return 3;
		}
	}
}
