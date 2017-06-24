import java.util.Iterator;



public class Deque<Item> implements Iterable<Item> {
    // Variables
	private Node first = null;
	private Node last = null;
    private int dequeSize;
    // Member classes
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }
    // Constructor
    public Deque()
    {
    }
    // Methods
    public Iterator<Item> iterator() { return new ListIterator(); }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext() { return current != null; }
        public void remove()
		{ 
			throw new java.lang.UnsupportedOperationException(); 
		}
        public Item next()
        {
            if (!(hasNext())) throw new java.util.NoSuchElementException();

            Item item = current.item;
            current = current.next;
            return item;
        }

    } 
    public boolean isEmpty()
    { 
        return (first == null || last == null); 
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
        if (item == null) throw new java.lang.IllegalArgumentException();

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.prev = null;

        if (last == null)
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
        if (item == null) throw new java.lang.IllegalArgumentException();

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (first == null)
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
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = first.item;
        // test if first is the only node remaining
        if (first.next == null) {
            first = null;
            last = null;
            return item;
        }

        first = first.next;
        first.prev = null;

        if (isEmpty()) {
            last = null;
            first = null;
        }


        dequeSize -= 1;

        return item;
    }
    /** 
     * Removes and returns the item from the from of the deque
     * @ throw java.util.NoSuchElementException() if attempting to remove an item
     *   from an empty deque
    */
    public Item removeLast()
    {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = last.item;
        // test if last is the only node remaining
        if (last.prev == null) {
            last = null;
            first = null;
            return item;
        }

        last = last.prev;
        last.next = null;

        if (isEmpty()) {
            first = null;
            last = null;
        }
        dequeSize -=1;

        return item;
    }


    public static void main(String[] args)
    {
		/*

        Deque<Integer> d = new Deque<Integer>();
        System.out.println("Tests______________\n");
        try {
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
        catch (java.util.NoSuchElementException e){
            System.out.print("No such element!");
        }
        
		*/
        Deque<Integer> d = new Deque<Integer>();
        assert d.isEmpty() == true : "IsEmpty test failed";
        //d.addFirst(8);
        d.addLast(1);
        d.addLast(2);
        d.addFirst(3);
        assert (d.removeLast() == 2) : "Test failed";
        assert (d.removeLast() == 1) : "Test failed";
        assert (d.removeFirst() == 3) : "Test failed";
        assert (d.isEmpty() == true) : "IsEmpty test failed";
        d.addFirst(8);
        assert (d.removeLast() == 8) : "Test failed";
        //assert (d.removeLast() == 8) : "Test failed";
    };
}
