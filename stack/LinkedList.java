import java.util.NoSuchElementException;

public class LinkedList<E> implements Collection<E> {

	// Node
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

	// E, int -> boolean
	// Accepts E item and an int index.
	// Adds the item to the indicated int index.
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

	// int -> boolean
	// Accepts int index as a parameter.
	// Removes the item indicated by int index.
	public boolean remove(int index) {
		if (this.size == 0)
			return false;

		Node current = this.head;
		Node previous = null;
		for (int i = 0; i < index; i++) {
			previous = current;
			current = current.next;
			if (current == null) {
				break;
			}
		}
		previous.next = current.next;
		current.next = null;
		this.size--;
		return true;
	}

	// -> int
	// Returns the size of the list.
	public int size() {
		return this.size;
	}

	// -> Iterator<E>
	// Returns an instance of the LinkedListIterator.
	public Iterator<E> iterator() {
		return new LinkedListIterator();

	}

	class LinkedListIterator implements Iterator<E> {
		Node current = head;

		@Override
		public E next() {
			if (!(hasNext()))
				throw new NoSuchElementException();

			E item = current.data;
			current = current.next;
			return item;
		}

		@Override
		public boolean hasNext() {
			return (current != null);
		}
	}

}
