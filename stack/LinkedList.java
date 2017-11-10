import java.util.NoSuchElementException;

public class LinkedList<E> implements Collection<E> {
	public class Node {
		E data;
		Node next;

		Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node head = null;
	int size = 0;

	LinkedList() {
	}

	public boolean add(E item, int index) {
		Node newNode = new Node(item, head);

		if (this.size == 0 || index == 0) {
			this.head = newNode;
			this.size++;
			return true;
		}

		Node current = this.head;
		Node previous = null;
		for (int i = 0; i < index; i++) {
			previous = current;
			current = current.next;
			if (current == null) {
				break;
			}
		}

		newNode.next = current;
		previous.next = newNode;
		size++;
		return true;
	}

	public E remove(int index) {
		if (this.size == 0) {
			throw new NoSuchElementException("Stack empty.");
		}

		Node current = this.head;
		Node previous = null;

		if (index == 0) {
			previous = current;
			current = current.next;
			previous.next = null;
		}

		for (int i = 0; i < index; i++) {
			previous = current;
			current = current.next;
			if (current == null) {
				break;
			}
		}
		E item = current.data;
		previous.next = current.next;
		current.next = null;
		this.size--;

		return item;
	}

	public int size() {
		return this.size;
	}

	public E getData(int index) {
		Node current = this.head;
		for (int i = 0; i < index; i++) {
			current = current.next;
			if (current == null) {
				break;
			}
		}
		E item = current.data;
		return item;
	}

	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	class LinkedListIterator implements Iterator<E> {
		Node current = head;

		public boolean hasNext() {
			return (current != null);
		}

		public E next() {
			if (!(hasNext()))
				throw new NoSuchElementException();

			E item = current.data;
			current = current.next;
			return item;
		}
	}

	public void display() {
		Node current = this.head;
		int count = 0;
		while (current != null) {
			System.out.println("Stack" + count + ": " + current.data);
			current = current.next;
			count++;
		}
	}
}
