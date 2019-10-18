package org.util.algo.p1;

//Java implementation of the approach 
import java.util.*;

public class GFG {

	// Function to find all unique combination of
	// given elements such that their sum is K
	static void unique_combination(int l, int sum, int K, Vector<Integer> local, Vector<Integer> A) {
		// If a unique combination is found
		System.out.println(String.format("L:%d, Sum:%d, K:%d, Local:"+local, l, sum, K));
		if (sum == K) {
			System.out.print("{");
			for (int i = 0; i < local.size(); i++) {
				if (i != 0)
					System.out.print(" ");
				System.out.print(local.get(i));
				if (i != local.size() - 1)
					System.out.print(", ");
			}
			System.out.println("}");
			return;
		}

		// For all other combinations
		for (int i = l; i < A.size(); i++) {
			System.out.println("I : "+i);
			// Check if the sum exceeds K
			if (sum + A.get(i) > K)
				continue;

			// Check if it is repeated or not
			if (i == 1 && A.get(i) == A.get(i - 1) && i > l)
				continue;

			// Take the element into the combination
			local.add(A.get(i));

			// Recursive call
			unique_combination(i + 1, sum + A.get(i), K, local, A);

			// Remove element from the combination
			local.remove(local.size() - 1);
		}
	}

	// Function to find all combination
	// of the given elements
	static void Combination(Vector<Integer> A, int K) {
		// Sort the given elements
		Collections.sort(A);

		// To store combination
		Vector<Integer> local = new Vector<Integer>();

		unique_combination(0, 0, K, local, A);
	}

	// Driver code
	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 6, 4, 5 };
		Vector<Integer> A = new Vector<>(Arrays.asList(arr));

		int K = 11222;

		// Function call
		Combination(A, K);
	}
}
