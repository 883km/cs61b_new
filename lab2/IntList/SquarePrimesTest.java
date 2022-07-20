package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSimple2() {
        IntList lst = IntList.of(2, 3, 4, 5, 6, 7);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 9 -> 4 -> 25 -> 6 -> 49", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testNoPrime() {
        IntList lst = IntList.of(21, 22, 24, 25, 30);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("21 -> 22 -> 24 -> 25 -> 30", lst.toString());
        assertFalse(changed);
    }

    @Test
    public void testTwoPrimesInTheMiddle() {
        IntList lst = IntList.of(39, 41, 42, 43, 44);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("39 -> 1681 -> 42 -> 1849 -> 44", lst.toString());
        assertTrue(changed);
    }
}
