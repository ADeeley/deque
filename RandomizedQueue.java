import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    // Variables
    private Node first = null;
    private Node last = null;
    private int size;
    private int max = 0;
    // Member classes
    private class Node {
        private Item item;
        private Node next;
    }
    // Constructor
    public RandomizedQueue()
    {
    }
    // Methods
    /* Iterator takes a snapshot of the queue at the time of instantiation and 
     * returns a random sample with each call to next(). 
     * Does not remove or add any elements
     */
    public Iterator<Item> iterator() { return new ListIterator(); }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext() { return current != null; }
        public void remove() { throw new java.lang.UnsupportedOperationException(); }
        public Item next()
        {
            if (!(hasNext())) throw new java.util.NoSuchElementException();

            // Item item = current.item;
            return sample();
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
        if (item == null) throw new java.lang.IllegalArgumentException();

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (first == null)
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
       	if (isEmpty()) throw new java.util.NoSuchElementException();
		Item item = first.item;

        first = first.next;

        if (isEmpty()) last = null;

        size -= 1;
        return item;
    }
    public Item sample() 
    {
        /* ** Potentially unnecessary code
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

         test start -------------------------------------
        System.out.println("After RadomArr:");
        for(int n : randArr)
            System.out.format("%d, ", n);
        System.out.println();
         test end ---------------------------------------
         */
       	if (isEmpty()) throw new java.util.NoSuchElementException();

        int randNum = StdRandom.uniform(size);
        Node tmpFirst = first;
        for (int i = randNum; i > 0; i--)
            tmpFirst = tmpFirst.next;

        return tmpFirst.item;

    }
    public static void main(String[] args) {
        /*
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
        }

        catch(java.util.NoSuchElementException e){
            System.out.print("No such element!");
        }
            */

    };
}
