import java.util.Iterator;



public class Deque<Item> implements Iterable<Item> {
    // Variables
    private int capacity = 10;
    private int size = 0;
    private Item[] deque = (Item[]) new Object[capacity];
    private int first = capacity / 2;
    private int last = capacity / 2;
    // Member classes
    // Constructor
    public Deque()
    {
    }
    // Methods
    public Iterator<Item> iterator() { return new ListIterator(); }
    private class ListIterator implements Iterator<Item>
    {
        // private Node current = first;

        public boolean hasNext() { return true; }
        public void remove()
		{ 
			throw new java.lang.UnsupportedOperationException(); 
		}
        public Item next()
        {
            if (!(hasNext())) throw new java.util.NoSuchElementException();

        //    Item item = current.item;
        //    current = current.next;
           return null;
        }

    } 
    public boolean isEmpty()
    { 
        return size == 0;
    }
    public int size() 
    { 
        return size;
    }
    /** 
     * Adds a new node to the beginning of the deque
    * @param item is the data for the Node to store
    * @throw NullPointerException if client tries to add a null item
    */
    private void expandDeque()
    {
            // double capacity
        System.out.format("Triggered expandDeque(), capacity now %d\n", capacity);
        Item[] newDeque = (Item[]) new Object[capacity * 2];
        for (int a = 0; a < capacity; a++)
            newDeque[a + (capacity / 2)] = deque[a];
        
        // update the locations of first and last in the deque
        first = first + (capacity / 2);
        last = last + (capacity / 2);
        capacity *= 2;
        deque = newDeque;

    }

    private void contractDeque()
    {
            // halve capacity
        System.out.println("Triggered ContractDeque()");
        Item[] newDeque = (Item[]) new Object[capacity / 2];
        for (int a = 0; a < capacity; a++)
            newDeque[a + (capacity / 4)] = deque[a];

        first = first + (capacity / 2);
        last = last + (capacity / 2);

        capacity /= 2;
        deque = newDeque;

    }
    public void addFirst(Item item)
    {
        // check if the array has room up front
        if (!(first > 0))
        {
            expandDeque();
        }
        deque[first - 1] = item;
        first--;
        size++;

    }
    /** 
     * Adds a new node to the end of the deque
    * @param item is the data for the Node to store
    * @throw NullPointerException if client tries to add a null item
    */
    public void addLast(Item item)
    {
        // check if the array has room up front
        if (!(last < (capacity - 1)))
        {
            expandDeque();
        }
        deque[last + 1] = item;
        last++;
        size++;
    }
    /** 
     * Removes and returns the item from the from of the deque
     * @ throw java.util.NoSuchElementException() if attempting to remove an item
     *   from an empty deque
    */
    public Item removeFirst()
    {
        return null;
    }
    /** 
     * Removes and returns the item from the from of the deque
     * @ throw java.util.NoSuchElementException() if attempting to remove an item
     *   from an empty deque
    */
    public Item removeLast()
    {
        return null;
    }


    public static void main(String[] args)
    {
        Deque<Integer> d = new Deque<Integer>();
        System.out.println("Tests______________\n");
        try {
            // test addFirst
            for (int el = 1; el< 100; el++)
            {
                d.addFirst(el);
                assert d.size() == el;           
            }
            d = new Deque<Integer>();
            // test addLast
            for (int el = 1; el< 100; el++)
            {
                d.addLast(el);
                assert d.size() == el;           
            }
            d = new Deque<Integer>();
            // test alternating addLast / addFirst
            boolean alt = true;
            for (int el = 1; el< 100; el++)
            {
                if (alt)
                {
                    d.addLast(el);
                    alt = false;
                }
                else
                {
                    d.addFirst(el);
                    alt = true;
                }
                assert d.size() == el;           
            }
            /*
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
        */

        }
        catch (java.util.NoSuchElementException e){
            System.out.print("No such element!");
        }
        
        /*
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
       */ 
    };
}
