package org.util.collections.map;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class User {
	public String name;
	public String dept;

	public static List<User> mock(Integer count) {
		return IntStream.rangeClosed(1, count).mapToObj(User::getInstance).collect(Collectors.toList());
	}

	public static User getInstance(Integer i) {
		User u = new User();
		u.name = "User-" + i;
		u.dept = "Dept-" + ((i % 3)+1);
		return u;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", dept=" + dept + "]";
	}

	public static void main(String[] args) {
		User.mock(10).stream().forEach(System.out::println);
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
