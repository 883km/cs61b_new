package deque;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class DequeRandomizedTest{

    @Test
    public void randomizedTest() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        int N = 10000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                lld.addFirst(randVal);
                ad.addFirst(randVal);
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                lld.addLast(randVal);
                ad.addLast(randVal);
            } else if (operationNumber == 2 && lld.size() > 0) {
                //removeFirst
                assertEquals(lld.removeFirst(), ad.removeFirst());
            } else if (operationNumber == 3 && lld.size() > 0) {
                //removeLast
                assertEquals(lld.removeLast(), ad.removeLast());
            } else if (operationNumber == 4) {
                // size
                assertEquals(lld.size(), ad.size());
            } else if (operationNumber == 5 && lld.size() > 0) {
                // get
                int randVal = StdRandom.uniform(0, lld.size());
                assertEquals(lld.get(randVal), ad.get(randVal));
            }
        }
    }


    public static void main(String[] args) { // This is for debugging only.
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            System.out.println(i);
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                lld.addFirst(randVal);
                ad.addFirst(randVal);
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                lld.addLast(randVal);
                ad.addLast(randVal);
            } else if (operationNumber == 2 && lld.size() > 0) {
                //removeFirst
                lld.removeFirst();
                ad.removeFirst();
            } else if (operationNumber == 3 && lld.size() > 0) {
                //removeLast
                lld.removeLast();
                ad.removeLast();
            } else if (operationNumber == 4) {
                // size
                lld.size();
                ad.size();
            } else if (operationNumber == 5 && lld.size() > 0) {
                // get
                int randVal = StdRandom.uniform(0, lld.size());
                int a = lld.get(randVal);
                int b = ad.get(randVal);
                b = ad.get(randVal); //set a breakpoint here to debug get(i).
                System.out.println("lld" + a);
                System.out.println("ad" + b);
            }
        }
    }
}

