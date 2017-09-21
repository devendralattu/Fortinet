package fortinet.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import fortinet.LinkedList;

public class TestReversal {

	@Test
	public void test() {
		LinkedList ll = new LinkedList(0);
		ll.add(1);
		ll.add(2);
		ll.add(3);

		// reverse the list
		ll.reverse(ll.getHead());

		LinkedList ll_r = new LinkedList(3);
		ll_r.add(2);
		ll_r.add(1);
		ll_r.add(0);

		assertEquals(ll.getSize(), ll_r.getSize());
		assertEquals(ll.printNodes(ll.getHead()), ll_r.printNodes(ll_r.getHead()));
	}

	@Test
	public void testTwoElem() {
		LinkedList ll = new LinkedList(100);
		ll.add(101);

		// reverse the list
		ll.reverse(ll.getHead());

		LinkedList ll_r = new LinkedList(101);
		ll_r.add(100);

		assertEquals(ll.getSize(), ll_r.getSize());
		assertEquals(ll.printNodes(ll.getHead()), ll_r.printNodes(ll_r.getHead()));
	}

	@Test
	public void testSingleElem() {
		LinkedList ll = new LinkedList(9);

		// reverse the list
		ll.reverse(ll.getHead());

		LinkedList ll_r = new LinkedList(9);

		assertEquals(ll.getSize(), ll_r.getSize());
		assertEquals(ll.printNodes(ll.getHead()), ll_r.printNodes(ll_r.getHead()));
	}

}
