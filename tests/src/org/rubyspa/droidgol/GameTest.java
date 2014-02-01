package org.rubyspa.droidgol;

import android.util.Pair;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class GameTest extends TestCase {


    public void testSetupGame() {
        Game game = new Game(15, 12);
        Pair<Integer, Integer> dimensions = Pair.create(15, 12);

        assertEquals("Game dimensions should be width:15, height: 12", dimensions, game.dimensions());
    }

    public void testSetupGameWithDefinedState() {
        Map state = new HashMap<Pair<Integer, Integer>, Boolean>();
        state.put(Pair.create(3, 3), Boolean.TRUE);
        Game game = new Game(15, 12, state);

        assertTrue(game.stateAt(Pair.create(3, 3)));
        assertFalse(game.stateAt(Pair.create(4, 5)));
    }

    public void testSetupGameWithRandomState() {
        Game game = new Game(15, 12);

        assertNotNull(game.stateAt(Pair.create(15, 12)));
    }

    public void testNeighbors() {
        Map<Pair<Integer, Integer>, Boolean> state = new HashMap<Pair<Integer, Integer>, Boolean>();
        state.put(Pair.create(1, 1), Boolean.TRUE);
        state.put(Pair.create(3, 1), Boolean.TRUE);
        state.put(Pair.create(2, 2), Boolean.TRUE);
        state.put(Pair.create(4, 2), Boolean.TRUE);
        state.put(Pair.create(2, 3), Boolean.TRUE);
        state.put(Pair.create(4, 3), Boolean.TRUE);
        Game game = new Game(4, 3, state);

        assertEquals(new Integer(5), game.neighbors(Pair.create(3, 2)));
        assertEquals(new Integer(3), game.neighbors(Pair.create(2, 2)));
        assertEquals(new Integer(3), game.neighbors(Pair.create(4, 2)));
        assertEquals(new Integer(4), game.neighbors(Pair.create(2, 1)));
    }

    public void testEvolve() {
        Map<Pair<Integer, Integer>, Boolean> state = new HashMap<Pair<Integer, Integer>, Boolean>();
        state.put(Pair.create(1, 1), Boolean.TRUE);
        state.put(Pair.create(3, 1), Boolean.TRUE);
        state.put(Pair.create(2, 2), Boolean.TRUE);
        state.put(Pair.create(4, 2), Boolean.TRUE);
        state.put(Pair.create(2, 3), Boolean.TRUE);
        state.put(Pair.create(4, 3), Boolean.TRUE);
        Game game = new Game(4, 3, state);

        Map<Pair<Integer, Integer>, Boolean> nextState = new HashMap<Pair<Integer, Integer>, Boolean>();
        nextState.put(Pair.create(1, 1), Boolean.FALSE);
        nextState.put(Pair.create(2, 1), Boolean.FALSE);
        nextState.put(Pair.create(3, 1), Boolean.FALSE);
        nextState.put(Pair.create(4, 1), Boolean.FALSE);
        nextState.put(Pair.create(1, 2), Boolean.FALSE);
        nextState.put(Pair.create(2, 2), Boolean.TRUE);
        nextState.put(Pair.create(3, 2), Boolean.FALSE);
        nextState.put(Pair.create(4, 2), Boolean.TRUE);
        nextState.put(Pair.create(1, 3), Boolean.FALSE);
        nextState.put(Pair.create(2, 3), Boolean.TRUE);
        nextState.put(Pair.create(3, 3), Boolean.FALSE);
        nextState.put(Pair.create(4, 3), Boolean.TRUE);

        assertEquals(nextState, game.evolve());
    }

}
