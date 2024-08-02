package org.util.collections.map;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaTest {

	public static void main(String[] args) {
		System.out.println("Hello!");
		grouping1();
		 grouping2();
		//grouping3();
		 grouping4();
	}

	public static void grouping1() {
		List<User> users = User.mock(20);
		Map<String, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getDept));
		map.forEach((k, v) -> System.out
				.println(String.format("%s : %s", k, v.stream().map(User::getName).collect(Collectors.toList()))));
	}

	public static void grouping2() {
		List<User> users = User.mock(20);
		Map<String, List<String>> map = users.stream()
				.collect(Collectors.groupingBy(User::getDept, Collectors.mapping(User::getName, Collectors.toList())));
		map.forEach((k, v) -> System.out.println(String.format("%s:%s", k, v)));

	}

	public static void grouping3() {
		List<User> users = User.mock(20);
		Map<String, Long> collect = users.stream().collect(
				Collectors.groupingBy(User::getDept, Collectors.mapping(User::getName, Collectors.counting())));
		collect.forEach((k, v) -> System.out.println(String.format("%s:%s", k, v)));

	}

	public static void grouping4() {
		List<User> users = User.mock(20);
		Map<String, Long> collect = users.stream().collect(
				Collectors.groupingBy(User::getDept, Collectors.mapping(User::getName, Collectors.counting())));
//		collect.entrySet().stream().sorted(Map.Entry.comparingByKey().reversed()).forEach((e) -> System.out.println(String.format("%s:%s", e.getKey(), e.getValue())));
		collect.entrySet().stream().sorted(Map.Entry.comparingByKey())
		.forEach((e) -> System.out.println(String.format("%s:%s", e.getKey(), e.getValue())));
		//collect.forEach((k, v) -> System.out.println(String.format("%s:%s", k, v)));
	}

	public static void grouping5() {
		List<User> users = User.mock(20);
		Map<String, String> map = users.stream().collect(Collectors.toMap(User::getName, User::getDept));
		map.forEach((k, v) -> System.out.println(String.format("%s:%s", k, v)));

	}
}