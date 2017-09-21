public class LinkedList {

	private Node head;
	private int size = 0;

	public LinkedList(int data) {
		setHead(new Node(data));
		size = (getSize() + 1);
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	class Node {
		Node next;
		int value;

		Node(int value) {
			this.value = value;
		}
	}

	public void add(int data) {
		Node end = new Node(data);
		Node current = getHead();

		while (current.next != null) {
			current = current.next;
		}
		current.next = end;
		size = (getSize() + 1);
	}

	public Node reverse(Node head) {

		Node h2 = null;
		Node current = head;

		while (current != null) {
			head = current.next;
			current.next = h2;
			h2 = current;
			current = head;
		}
		this.setHead(h2);
		return this.getHead();
	}

	public String printNodes(Node head) {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while (current != null) {
			sb.append(current.value + "->");
			current = current.next;
		}
		sb.append("null");
		return sb.toString();
	}

	public static void main(String[] args) {

		LinkedList ll = new LinkedList(0);
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);

		String print_ll = ll.printNodes(ll.getHead());
		System.out.println(print_ll);

		ll.reverse(ll.getHead());
		print_ll = ll.printNodes(ll.getHead());
		System.out.println(print_ll);

		LinkedList ll_2 = new LinkedList(99);
		String print_ll2 = ll.printNodes(ll_2.getHead());
		System.out.println(print_ll2);

		ll.reverse(ll_2.getHead());
		print_ll2 = ll.printNodes(ll_2.getHead());
		System.out.println(print_ll2);
	}
}
