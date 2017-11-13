import java.util.NoSuchElementException;

public class CircularArray {
	int[] array;
	int head;
	int tail;
	int arraySize;
	int max;
	
	public static final int RES = 2;

	public CircularArray(int max) {
		this.array = new int[max];
		this.head = 0;
		this.tail = 0;
		this.arraySize = 0;
		this.max = max;
	}

	public void enqueue(int item) {
		if (arraySize == array.length) {
			int arr = head - tail;
			if (((arr) == -1) || (arr) == (arraySize - 1)) {
				int resize = (int) (array.length * RES);
				int[] newArray = new int[resize];

				for (int i = head; i <= tail; i++) {
					newArray[i - head] = array[i % array.length];
				}

				array = newArray;
				head = item;
				tail = arraySize - 1;
				array[arraySize] = array[resize];
			}
		}
		if (arraySize == 0) {
			head = head + 1;
		}

		array[tail] = item;
		tail = (tail + 1) % this.max;
		arraySize++;
	}

	public int dequeue() {
		if (!(isEmpty())) {
			int item = array[head - 1];
			array[head - 1] = head;
			head = (head + 1) % arraySize;
			return item;
		}
		throw new NoSuchElementException();
	}
	
	public int size() {
		return arraySize;
	}
	
	public boolean isEmpty() {
		return arraySize == 0;
	}
	
	public Object peek() {
		if (!(isEmpty())) {
			return array[head - 1];
		}
		//else
		return null;
	}

}