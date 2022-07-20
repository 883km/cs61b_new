package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> good = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        good.addLast(4);
        good.addLast(5);
        good.addLast(6);
        buggy.addLast(4);
        buggy.addLast(5);
        buggy.addLast(6);

        assertEquals(good.size(), buggy.size());
        assertEquals(good.removeLast(), buggy.removeLast());
        assertEquals(good.removeLast(), buggy.removeLast());
        assertEquals(good.removeLast(), buggy.removeLast());

    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> good = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                good.addLast(randVal);
                buggy.addLast(randVal);
                // System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                assertEquals(good.size(), buggy.size());
            } else if (operationNumber == 2 && good.size() > 0) {
                // getLast
                assertEquals(good.getLast(), buggy.getLast());
            } else if (operationNumber == 3 && good.size() > 0) {
                //removeLast
                assertEquals(good.removeLast(), buggy.removeLast());
            }
        }
    }
}
