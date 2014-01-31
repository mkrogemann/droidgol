package org.rubyspa.droidgol;

import junit.framework.TestCase;

import java.util.Locale;
import java.util.Random;

public class RulesTest extends TestCase {

    public void testReturnsTrueForThreeLiveNeighborsIfSelfAlive() {
        assertTrue(Rules.apply(3, true));
    }

    public void testReturnsTrueForThreeLiveNeighborsIfSelfDead() {
        assertTrue(Rules.apply(3, false));
    }

    public void testReturnsTrueForTwoLiveNeighborsIfSelfAlive() {
        assertTrue(Rules.apply(2, true));
    }

    public void testReturnsFalseForTwoLiveNeighborsIfSelfDead() {
        assertFalse(Rules.apply(2, false));
    }

    public void testReturnsFalseForMoreThanThreeLiveNeighbors() {
        boolean alive = new Random().nextBoolean();
        int neighbors = new Random().nextInt((Integer.MAX_VALUE - 3) + 1) + 3;

        assertFalse(String.format(Locale.US, "Should return false for %d neighbors and self: %b", neighbors, alive),
                Rules.apply(neighbors, alive));
    }

    public void testReturnsFalseForLessThanTwoLiveNeighbors() {
        boolean alive = new Random().nextBoolean();
        int neighbors = new Random().nextInt(2);

        assertFalse(String.format(Locale.US, "Should return false for %d neighbors and self: %b", neighbors, alive),
                Rules.apply(neighbors, alive));
    }

}
