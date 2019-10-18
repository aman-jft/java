package org.util.collections.map;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CapacityTest {
	public static void main(String[] args) throws Exception {
		test();
		System.out.println(21%8);
		System.out.println(21 & 7);
	}

	public static void test() throws Exception {
		HashMap hashMap = new HashMap(8);
		IntStream.range(0, 60).forEach((i) -> {
			hashMap.put(i, i);
			try {
				System.out.println("Size: " + hashMap.size());
				System.out.println("Capacity: " + getCapacity(hashMap));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	static int getCapacity(Map hashMap) throws Exception {
		Field field = HashMap.class.getDeclaredField("table");
		field.setAccessible(true);
		return ((Object[]) field.get(hashMap)).length;
	}
}
