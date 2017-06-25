import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    // Variables
    private int capacity = 10;
    private int size = 0;
    private Item[] deque = (Item[]) new Object[capacity];
    public int first = 0;
    public int last = 0;
    private Item[] randArr;
    private int choice = 0; // element for randomArr
    // Constructor
    public RandomizedQueue()
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

            return sample();
        }

    } 
    public boolean isEmpty()
    { 
        return (size == 0); 
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
    /** 
     * Removes and returns the item from the from of the queue 
     * @ throw java.util.NoSuchElementException() if attempting to remove an item
     *   from an empty deque
    */

    public void enqueue(Item item)
    {
        // check if the array has room up front
        if (item == null) throw new java.lang.IllegalArgumentException();

        if (last >= capacity)
            expandDeque();

        if (size == 0)
            deque[last] = item;
        else
        {
            deque[last + 1] = item;
            last++;
        }

        size++;

    }
    public Item dequeue()
    {
       	if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = deque[first]; 

        if (size > 1)
            first++;

        size--;
        return item;
    }
    public Item sample() 
    {
       	if (isEmpty()) throw new java.util.NoSuchElementException();
		
        if (randArr == null)
	{
            randArr = (Item[]) new Object[size];
            int i = 0;
            for (int a = first; a <= last; a++)
            {
                randArr[i] = deque[a];
                i++;
            }
	    StdRandom.shuffle(randArr);
        }

        return randArr[choice];

    }
    public static void main(String[] args) {
        try{
            // set up trials number of  elements in a linked list queue with
            // their array indexes as their item
            // test sample method()
            RandomizedQueue<Integer> d = new RandomizedQueue<Integer>();
            int trials = 5;
            for(int i=0; i<trials; i++)
                d.enqueue(i);

            for(int j=0; j<trials*2; j++)
                System.out.format("Returned %d\n\n", d.sample());
			/*

            // Iterator tests
            Iterator<Integer> it = d.iterator();
            for(int j=0; j<trials*2; j++)
                System.out.format("Iterator 1 returned %d\n", it.next());
            
            // Test that each iterator instance is unique    
            RandomizedQueue<Integer> g = new RandomizedQueue<Integer>();

            for(int i=0; i<trials; i++)
                g.enqueue(i);

            Iterator<Integer> et = g.iterator();

            for(int j=0; j<trials*2; j++)
                System.out.format("Iterator 2 returned %d\n", et.next());

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
            RandomizedQueue<String> a = new RandomizedQueue<String>();
            StdRandom.setSeed(8);
            a.enqueue("hello");
            //System.out.println(a.dequeue());
            //a.dequeue();
            a.size();
			*/
            RandomizedQueue<String> a = new RandomizedQueue<String>();
                        a.enqueue("A");
                        a.enqueue("B");
                        a.enqueue("C");
                        a.enqueue("D");
                        a.enqueue("E");
                        a.enqueue("F");
                        a.enqueue("G");
                        a.enqueue("H");
                        a.enqueue("I");
                        System.out.print(a.sample());
                        System.out.print(a.sample());
                        System.out.print(a.sample());
                        System.out.print(a.sample());
                        System.out.print(a.sample());
                        System.out.print(a.sample());
                        System.out.print(a.sample());
                        System.out.print(a.sample());
                        System.out.print(a.sample());
        }

        catch(java.util.NoSuchElementException e){
            System.out.print("No such element!");
        }

    };
}
