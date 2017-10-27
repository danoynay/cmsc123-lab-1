import junit.framework.TestCase; // import the library to make it work

public class IteratorTester extends TestCase {
	public void testAdd() {
		LinkedList<String> link = new LinkedList<String>();
		assertEquals(true, link.add("Pizza", 0));
		assertEquals(true, link.add("Burger", 1));
		assertEquals(true, link.add("Sprite", 2));
	}

	public void testRemove() {
		LinkedList<String> link = new LinkedList<String>();

		link.add("Pizza", 0);
		link.add("Burger", 1);
		link.add("Sprite", 2);
		assertEquals(true, link.remove(2));
	}

	public void testHasNext() {
		LinkedList<String> link = new LinkedList<String>();

		link.add("Pizza", 0);
		link.add("Burger", 1);
		link.add("Sprite", 2);

		@SuppressWarnings("rawtypes")
		Iterator i = link.iterator();

		assertEquals(true, i.hasNext());
	}

	public void testNext() {
		LinkedList<String> link = new LinkedList<String>();

		@SuppressWarnings("rawtypes")
		Iterator i = link.iterator();

		while (i.hasNext())
			System.out.println(i.next() + " ");
	}
}