import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Deque<Item> implements Iterable<Item>{
	// Variables
	private Node first, last;
	private int dequeSize;
	// Member classes
	private class Node{
		Item item;
		Node next;
		Node prev;
	}
	// Constructor
	public Deque()
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
		return (first == null || last == null ); 
	}
	public int size() 
	{ 
		return dequeSize; 
	}
	/** 
	 * Adds a new node to the beginning of the deque
	* @param item is the data for the Node to store
	* @throw NullPointerException if client tries to add a null item
	*/
	public void addFirst(Item item)
	{
		if(item == null) throw new java.lang.NullPointerException();

		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.prev = null;

		if(last == null)
		{
			last = first;
			first.next = null;
		}
		else
		{
			oldFirst.prev = first;
			first.next = oldFirst;
		}
		dequeSize += 1;
	}
	/** 
	 * Adds a new node to the end of the deque
	* @param item is the data for the Node to store
	* @throw NullPointerException if client tries to add a null item
	*/
	public void addLast(Item item)
	{
		if(item == null) throw new java.lang.NullPointerException();

		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;

		if(first == null)
		{
			first = last;
			last.prev = null;
		}
		else
		{
			oldLast.next = last;
			last.prev = oldLast;
		}
		dequeSize += 1;
	}
	/** 
	 * Removes and returns the item from the from of the deque
	 * @ throw java.util.NoSuchElementException() if attempting to remove an item
	 *   from an empty deque
	*/
	public Item removeFirst()
	{
		if(isEmpty()) throw new java.util.NoSuchElementException();
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last = null;

		dequeSize -=1;
		return item;

		/*
		Node oldFirst = first;
		first = first.next;
		first.prev = null;


		dequeSize -= 1;

		return oldFirst.item;
		*/
	}
	/** 
	 * Removes and returns the item from the from of the deque
	 * @ throw java.util.NoSuchElementException() if attempting to remove an item
	 *   from an empty deque
	*/
	public Item removeLast()
	{
		if(isEmpty()) throw new java.util.NoSuchElementException();
		Item item = last.item;
		last = last.prev;
		if(isEmpty()) first = null;

		dequeSize -=1;

		return item;

		/*
		Node oldLast = last;
		last = last.prev;
		last.next = null;
		
		dequeSize -= 1;

		return oldLast.item;
		*/
	}


	public static void main(String[] args){

		Deque<Integer> d = new Deque<Integer>();
		System.out.println("Tests______________\n");
		try{
			int n = StdRandom.uniform(3);
			d.addFirst(1);
			d.addFirst(2);
			d.addFirst(3);
			System.out.println("Addfirst tests:\n");
			System.out.print((d.dequeSize == 3) ? "True\n" : "False\n");
			d.removeFirst();
			d.removeFirst();
			d.removeFirst();
			System.out.print((d.dequeSize == 0) ? "True\n" : "False\n");
			System.out.print("Isempty: ");
			System.out.print((d.isEmpty() == true) ? "True\n" : "False\n");

			System.out.println("Addlast tests:\n");
			d.addLast(1);
			d.addLast(2);
			d.addLast(3);
			System.out.print((d.dequeSize == 3) ? "True\n" : "False\n");
			d.removeLast();
			d.removeLast();
			d.removeLast();
			System.out.print((d.dequeSize == 0) ? "True\n" : "False\n");
			System.out.print("Isempty: ");
			System.out.print((d.isEmpty() == true) ? "True\n" : "False\n");

			d.addFirst(1);
			d.addFirst(2);
			d.addFirst(3);
			System.out.println("Addfirst invert tests:\n");
			System.out.print((d.dequeSize == 3) ? "True\n" : "False\n");
			d.removeLast();
			d.removeLast();
			d.removeLast();
			System.out.print((d.dequeSize == 0) ? "True\n" : "False\n");
			System.out.print("Isempty: ");
			System.out.print((d.isEmpty() == true) ? "True\n" : "False\n");

			System.out.println("Addlast invert tests:\n");
			d.addLast(1);
			d.addLast(2);
			d.addLast(3);
			System.out.print((d.dequeSize == 3) ? "True\n" : "False\n");
			d.removeFirst();
			d.removeFirst();
			d.removeFirst();
			System.out.print((d.dequeSize == 0) ? "True\n" : "False\n");
			System.out.print("Isempty: ");
			System.out.print((d.isEmpty() == true) ? "True\n" : "False\n");

			// Iterator tests
			System.out.println("Iterator tests:\n");
			d.addLast(1);
			d.addLast(2);
			d.addLast(3);
			Iterator<Integer> i = d.iterator();
			System.out.println(i.next());
			System.out.println(i.next());
			System.out.println(i.hasNext());
			System.out.println(i.next());
			System.out.println(i.hasNext());
			//System.out.println(i.next());

			// Type tests
			Deque<String> a = new Deque<String>();
			a.addFirst("hello");
			System.out.println(a.removeFirst());
			a.removeFirst();
			a.size();

		}

		catch(java.util.NoSuchElementException e){
			System.out.print("No such element!");
		}


		
	};
}
