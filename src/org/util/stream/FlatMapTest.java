package org.util.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlatMapTest {
	public static void main(String[] args) {
		test();
	}
	
	public  static void test() {
		Map<String, List<String>> deptWiseUserList = new HashMap<>();
		deptWiseUserList.put("Dept1", Arrays.asList("A1", "B1", "C1"));
		deptWiseUserList.put("Dept2", Arrays.asList("A2", "B2", "C2"));
		deptWiseUserList.put("Dept3", Arrays.asList("A3", "B3", "C3"));
		// flatMap work on collection of collection to linear the stream.
		deptWiseUserList.entrySet().stream().peek(System.out::println).flatMap(e -> e.getValue().stream()).sorted(Comparator.naturalOrder()).forEach(System.out::println);
	}
}
