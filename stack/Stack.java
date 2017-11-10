import java.util.EmptyStackException;

class Stack<E> {
	LinkedList<E> list;

	public Stack() {
		list = new LinkedList<>();
	}

	public void push(E item) {
		int i = list.size();
		list.add(item, i);
	}

	public E pop() {
		int i = list.size() - 1;
		return list.remove(i);
	}

	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		int i = list.size() - 1;
		return list.getData(i);
	}

	public boolean isEmpty() {
		return (list.size() == 0);
	}

	public int size() {
		return list.size();
	}

	public void display() {
		list.display();
	}
}