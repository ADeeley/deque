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
        int queueSize = 10;
        String[] queue = new String[queueSize];
        int k = Integer.parseInt(args[0]);
        int i = 0;

        while (!StdIn.isEmpty()) 
        {
            queue[i] = StdIn.readString();
            i++;
            if (i >= queueSize)
            {
                queueSize *= 2;
                String[] newQueue = new String[queueSize];
                for (int j = 0; j < queueSize / 2; j++)
                    newQueue[j] = queue[j];
                queue = newQueue;
            }
        }
        /* test code:
        queue[0] = "a";
        queue[1] = "b";
        queue[2] = "c";
        queue[3] = "d";
        queue[4] = "e";
        queue[5] = "f";
        queue[6] = "g";
        queue[7] = "h";
        queue[8] = "i";
        queue[9] = "j";
        */
        StdRandom.shuffle(queue);
        for (int n = 0; n < k; n++)
            StdOut.println(queue[n]);

        /*
        // create random array
        int[] randArr = new int[queue.size];
        max = queue.size - 1;

        for (int n = 0; n < size; n++)
            randArr[n] = n;

        // Choose a random element and switch it with the element at max
        int el = StdRandom.uniform(max + 1);
        int rNum = randArr[el];
        randArr[el] = randArr[max];
        randArr[max] = rNum;
        max--;


        return tmpFirst.item;
        */

    }
    };

