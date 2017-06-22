import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomisedQueue<Item> implements Iterable<Item>{
	// Variables
	private Node first, last;
	private int size;
	int max = 0;
	int[] randArr;
	// Member classes
	private class Node{
		Item item;
		Node next;
	}
	// Constructor
	public RandomisedQueue()
	{
		Node first, last;
	}
	// Methods
	public Iterator<Item> iterator() { return new ListIterator(); }
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;

		public boolean hasNext() { return current != null; }
		public void remove () { throw new java.lang.UnsupportedOperationException();}
		public Item next()
		{
			if(!(hasNext())) throw new java.util.NoSuchElementException();

			Item item = current.item;
			current = current.next;
			return item;
		}

	} 
	public boolean isEmpty()
	{ 
		return (first == null); 
	}
	public int size() 
	{ 
		return size; 
	}
	/** 
	 * Adds a new node to the end of the queue
	* @param item is the data for the Node to store
	* @throw NullPointerException if client tries to add a null item
	*/
	public void enqueue(Item item)
	{
		if(item == null) throw new java.lang.NullPointerException();

		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;

		if(first == null)
			first = last;
		else
			oldLast.next = last;
		size += 1;
	}
	/** 
	 * Removes and returns the item from the from of the queue 
	 * @ throw java.util.NoSuchElementException() if attempting to remove an item
	 *   from an empty deque
	*/
	public Item dequeue()
	{
		if(isEmpty()) throw new java.util.NoSuchElementException();
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last = null;

		size -=1;
		return item;
	}
	public Item sample()
	{
		// Create new array [0...n-1] if not already created
		if(randArr == null || max < 0)
		{
			randArr = new int[size];
			max = size - 1;
			for(int n = 0; n<size; n++)
				randArr[n] = n;
		}
		// Choose a random element and switch it with the element at max
		int el = StdRandom.uniform(max + 1);
		//System.out.format("Rand el: %d\n", el);

		int rNum = randArr[el];
		randArr[el] = randArr[max];
		randArr[max] = rNum;
		max--;

		/* test start -------------------------------------
		System.out.println("After RadomArr:");
		for(int n : randArr)
			System.out.format("%d, ", n);
		System.out.println();
		 test end ---------------------------------------
		 */

		Node tmpFirst = first;
		for(int i = rNum; i>0; i--)
			tmpFirst = tmpFirst.next;

		return tmpFirst.item;

	}
	public static void main(String[] args){

		try{
			// set up trials number of  elements in a linked list queue with
			// their array indexes as their item
			// test sample method()
			RandomisedQueue<Integer> d = new RandomisedQueue<Integer>();
			int trials = 5;
			for(int i=0; i<trials; i++)
				d.enqueue(i);

			for(int j=0; j<trials*2; j++)
				System.out.format("Returned %d\n\n", d.sample());





			/*
			d.enqueue(1);
			d.enqueue(2);
			d.enqueue(3);
			System.out.println("Enqueue tests:\n");
			System.out.print((d.size == 3) ? "True\n" : "False\n");
			d.dequeue();
			d.dequeue();
			d.dequeue();
			System.out.print((d.size == 0) ? "True\n" : "False\n");
			System.out.print("Isempty: ");
			System.out.print((d.isEmpty() == true) ? "True\n" : "False\n");

			// Iterator tests
			System.out.println("Iterator tests:\n");
			d.enqueue(0);
			d.enqueue(1);
			d.enqueue(2);
			d.enqueue(3);
			d.enqueue(4);
			Iterator<Integer> i = d.iterator();
			System.out.println(i.next());
			System.out.println(i.next());
			System.out.println(i.hasNext());
			System.out.println(i.next());
			System.out.println(i.hasNext());
			//System.out.println(i.next());
			System.out.println("Sample tests:");
			System.out.format("Returned %d\n\n", d.sample());
			System.out.format("Returned %d\n\n", d.sample());
			System.out.format("Returned %d\n\n", d.sample());
			System.out.format("Returned %d\n\n", d.sample());
			System.out.format("Returned %d\n\n", d.sample());

			// Type tests
			RandomisedQueue<String> a = new RandomisedQueue<String>();
			StdRandom.setSeed(8);
			a.enqueue("hello");
			//System.out.println(a.dequeue());
			//a.dequeue();
			a.size();
			*/
		}

		catch(java.util.NoSuchElementException e){
			System.out.print("No such element!");
		}


		
	};
}
