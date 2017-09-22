package fortinet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KSubgroupsSum {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(4,9,-6,7,3,4));
		Collections.shuffle(list);
		int k = 3;

		boolean result = separate(list, k);
		if (result) {
			System.out.println("List: " + list + " CAN be equally divided into " + k + " groups");
		} else {
			System.out.println("List: " + list + " CANNOT be equally divided into " + k + " groups");
		}
	}

	/*
	 * Time Complexity: exponential
	 * Space Complexity: O(N)
	 * Approach: Recursive Backtracking
	 * 1. Each group from k groups should equal to totalSum / k 
	 * 2. Recurse for each of the k groups until the value totalSum / k is met
	 */
	public static boolean separate(List<Integer> list, int k) {

		if (list == null || list.size() == 0) {
			return false;
		}

		int size = list.size();
		boolean[] flag = new boolean[size];

		// Calculate total sum
		int sum = 0;
		for (int l : list)
			sum += l;

		// Check whether total sum can be partitioned into sum/k equal groupSum
		int groupSum = sum / k;
		if (groupSum * k != sum)
			return false;

		// Fill all the (k) groups one at a time
		while (--k > 0) {
			if (!fill(list, groupSum, size, flag)) {
				break;
			}
		}
		// Check whether all of the (k) groups are filled
		return (k == 0) ? true : false;
	}

	private static boolean fill(List<Integer> list, int groupSum, int size, boolean[] flag) {

		// Base Cases
		if (groupSum == 0 && size >= 0)
			return true;
		if (size == 0)
			return false;

		// Exclude current item
		if (fill(list, groupSum, size - 1, flag)) {
			return true;
		}
		
		// Include current item
		else if (!flag[size - 1]) {
			flag[size - 1] = true;
			if (fill(list, groupSum - list.get(size - 1), size - 1, flag)) {
				return true;
			}
			flag[size - 1] = false;
		}
		return false;
	}

}
