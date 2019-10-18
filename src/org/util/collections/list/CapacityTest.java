package org.util.collections.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CapacityTest {
	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception {
		List list = new ArrayList<>(5);
		IntStream.range(0, 20).forEach((i) -> {
			list.add(i);
			try {
				System.out.println("Size: " + list.size());
				System.out.println("Capacity: " + getCapacity(list));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	static int getCapacity(List list) throws Exception {
		Field field = ArrayList.class.getDeclaredField("elementData");
		field.setAccessible(true);
		return ((Object[]) field.get(list)).length;
	}
}
