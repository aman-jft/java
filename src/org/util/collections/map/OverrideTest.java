package org.util.collections.map;

import java.util.HashMap;

public class OverrideTest {
	public static void main(String[] args) {
		HashMap<Test, String> map = new HashMap<>();
		System.out.println(map.put(Test.getInstance("A1"), "A1"));
		System.out.println(map.put(Test.getInstance("B1"), "B1"));
		System.out.println("############");
		System.out.println(map.put(null, "A2"));
		System.out.println(map.put(null, "B2"));
		System.out.println("############");
		map.forEach((k,v) -> System.out.println(k + ":" + v));
	}
	
	static class Test{
		String s;
		public static Test getInstance(String s) {
			Test t = new Test();
			t.s = s;
			return t;
		}
		@Override
		public int hashCode() {
			return 1;
		}
		@Override
		public boolean equals(Object obj) {
			return true;
		}
		@Override
		public String toString() {
			return "Test [s=" + s + "]";
		}
	}
}
