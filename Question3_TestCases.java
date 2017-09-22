package fortinet.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fortinet.KSubgroupsSum;

public class TestKsubgroup {

	private static List<Integer> list;

	@Test
	public void test() {

		list = new ArrayList<>(Arrays.asList(4, -6, 3, 7, 4, 9)); // sum = 21
		assertEquals(KSubgroupsSum.separate(list, 3), true); // 21/3 = 7 = true

		list = new ArrayList<>(Arrays.asList(4, -6, 3, 7, 4, 9)); // sum = 21
		assertEquals(KSubgroupsSum.separate(list, 2), false);

		list = new ArrayList<>(Arrays.asList(4, -6, 3, 7, 4, 9)); // sum = 21
		assertEquals(KSubgroupsSum.separate(list, 1), true);

		list = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 1, 1)); // sum = 10
		assertEquals(KSubgroupsSum.separate(list, 2), true); // 10/2 = 5(no
																// number > 5) =
																// true

		list = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 1, 1)); // sum = 10
		assertEquals(KSubgroupsSum.separate(list, 5), false); // 10/5 = 2 (but 3
																// is max and
																// there are no
																// negative
																// numbers) =
																// false
	}

}
