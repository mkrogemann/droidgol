package org.rubyspa.droidgol;

import android.util.Pair;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class GamePrinterTest extends TestCase {

    public void testPrintGameState() {
        Map<Pair<Integer, Integer>, Boolean> state = new HashMap<Pair<Integer, Integer>, Boolean>();
        state.put(Pair.create(1, 1), Boolean.TRUE);
        state.put(Pair.create(3, 1), Boolean.TRUE);
        state.put(Pair.create(2, 2), Boolean.TRUE);
        state.put(Pair.create(4, 2), Boolean.TRUE);
        state.put(Pair.create(2, 3), Boolean.TRUE);
        state.put(Pair.create(4, 3), Boolean.TRUE);
        Game game = new Game(4, 3, state);
        assertEquals("o o \n o o\n o o", GamePrinter.print(game));
    }
}
