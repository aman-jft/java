package org.util.collections.list;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class OverrideTest {
	public static void main(String[] args) {
		Set set = new HashSet();
		
		IntStream.range(1, 5).forEach(i -> {
			System.out.println(set.add(new Temp(i)));
		});
		
		set.stream().forEach(System.out::println);
	}
	
	static class Temp {
		int i;
		
		public String toString() {
			return ""+i;
		}
		public Temp(int i) {
			this.i = i;
		}

		@Override
		public int hashCode() {
			/*final int prime = 31;
			int result = 1;
			result = prime * result + i;
			return result;*/
			return 1;
		}

		@Override
		public boolean equals(Object obj) {
			/*if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Temp other = (Temp) obj;
			if (i != other.i)
				return false;*/
			return true;
		}
		
	}
}
