import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {

    /*
    * Prints out k permutations of the given sequence
    * @args[0] = int k 0 <= k <= n, where n is the number 
    * of strings on standard input. 
    * 
    * firstly, reads input until blank space is given- each string is added to 
    * an array, strings
    *
    * next, the program prints k of the strings, without repetition
    */    
    // add data structure here
    public static void main(String[] args) 
    {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<String>();

        while (!(StdIn.isEmpty())) 
        {
            String a = StdIn.readString();
            rq.enqueue(a);
        }

        for (int n = 0; n < k; n++)
            StdOut.println(rq.sample());
    }
};

