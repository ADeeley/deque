import java.util.Iterator;


public class Deque<Item> implements Iterable<Item> {
    // Variables
    private int capacity = 10;
    private int size = 0;
    private Item[] deque = (Item[]) new Object[capacity];
    // to change to private
    public int first = capacity / 2;
    public int last = capacity / 2;
    // Constructor
    public Deque()
    {
    }
    // Methods
    public Iterator<Item> iterator() { return new ListIterator(); }
    private class ListIterator implements Iterator<Item>
    {
        public boolean hasNext() { return !(isEmpty()); }
        public void remove()
        { 
            throw new java.lang.UnsupportedOperationException(); 
        }
        public Item next()
        {
            if (!(hasNext())) throw new java.util.NoSuchElementException();
            
            return removeFirst();
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
        if (item == null) throw new java.lang.IllegalArgumentException();

        if (!(first > 0))
            expandDeque();

        if (size == 0)
            deque[first] = item;
        else
        {
            deque[first - 1] = item;
            first--;
        }

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
        if (item == null) throw new java.lang.IllegalArgumentException();
        if (!(last < (capacity - 1)))
        {
            expandDeque();
        }
        if (size == 0)
            deque[last] = item;
        else
        {
            deque[last + 1] = item;
            last++;
        }

        size++;
    }
    /** 
     * Removes and returns the item from the from of the deque
     * @ throw java.util.NoSuchElementException() if attempting to remove an item
     *   from an empty deque
    */
    public Item removeFirst()
    {
        if (size <= 0) throw new java.util.NoSuchElementException();
        Item item = deque[first];

        if (size > 1)
            first++;

        size--;
        // shrink array if size = (capacity / 4)
        return item;
    }
    /** 
     * Removes and returns the item from the from of the deque
     * @ throw java.util.NoSuchElementException() if attempting to remove an item
     *   from an empty deque
    */
    public Item removeLast()
    {
        if (size <= 0) throw new java.util.NoSuchElementException();
        Item item = deque[last];

        if (size > 1)
            last--;

        size--;
        // shrink array if size = (capacity / 4)
        return item;
    }


    public static void main(String[] args)
    {
        Deque<Integer> d = new Deque<Integer>();
        assert d.isEmpty() == true;
        System.out.println("Tests______________\n");
        try {
            // test addFirst----------------------
            for (int el = 1; el< 1000; el++)
            {
                d.addFirst(el);
                assert d.size() == el; 
   
            }
            assert d.isEmpty() == false;
            d = new Deque<Integer>();
            // test addLast-----------------------
            for (int el = 1; el< 1000; el++)
            {
                d.addLast(el);
                assert d.size() == el;           
            }
            assert d.isEmpty() == false;
            d = new Deque<Integer>();
            // test alternating addLast / addFirst
            boolean alt = true;
            for (int el = 1; el< 1000; el++)
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
            assert d.isEmpty() == false;

            // test removing and adding
            d = new Deque<Integer>();
            d.addFirst(0);
            assert d.removeFirst() == 0;
            assert d.size() == 0;

            System.out.format("First: %d, Last: %d\n", d.first, d.last);
            d.addFirst(0);
            d.addLast(1);
            System.out.format("First: %d, Last: %d\n", d.first, d.last);
            assert d.size() == 2;
            assert d.removeLast() == 1;
            System.out.format("First: %d, Last: %d\n", d.first, d.last);
            assert d.removeFirst() == 0;
            System.out.format("First: %d, Last: %d\n", d.first, d.last);

            d.addFirst(1);
            d.addLast(2);
            d.addFirst(0);
            d.addLast(3);
            assert d.size() == 4;
            assert d.removeFirst() == 0;
            assert d.removeFirst() == 1;
            assert d.removeFirst() == 2;
            assert d.removeFirst() == 3;

            d.addFirst(1);
            d.addLast(2);
            d.addFirst(0);
            d.addLast(3);
            assert d.size() == 4;
            assert d.removeFirst() == 0;
            assert d.removeLast() == 3;
            assert d.removeFirst() == 1;
            assert d.removeLast() == 2;

            // Iterator tests 1
            d = new Deque<Integer>();
            System.out.println("Iterator tests:\n");

            for (int el = 0; el< 5; el++)
                d.addFirst(el);

            Iterator<Integer> i = d.iterator();
            System.out.println(i.next());
            System.out.println(i.next());
            assert i.hasNext() == true;
            System.out.println(i.next());
            assert i.hasNext() == true;
            System.out.println(i.next());
            System.out.println(i.next());
            assert i.hasNext() == false;

            // Iterator tests 2
            d = new Deque<Integer>();
            System.out.println("Iterator tests:\n");
            
            d.addFirst(1);
            d.addLast(2);
            d.addFirst(0);
            d.addLast(3);

            i = d.iterator();
            System.out.println(i.next());
            System.out.println(i.next());
            assert i.hasNext() == true;
            System.out.println(i.next());
            assert i.hasNext() == true;
            System.out.println(i.next());
            assert i.hasNext() == false;
            
            // Iterator tests 3
            d = new Deque<Integer>();
            System.out.println("Iterator tests:\n");

            i = d.iterator();
            assert i.hasNext() == false;
        }
        catch (java.util.NoSuchElementException e){
            System.out.format("No such element! %s", e);
        }
        
    };
}
