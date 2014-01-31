package org.rubyspa.droidgol;

import android.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private final Pair<Integer, Integer> dimensions;
    private Map<Pair<Integer, Integer>, Boolean> state;

    public Game(final Integer width, final Integer height) {
        this.dimensions = Pair.create(width, height);
    }

    public Game(final Integer width, final Integer height, final Map state) {
        this(width, height);
        this.state = initializeState(state);
    }

    private Map<Pair<Integer, Integer>, Boolean> initializeState(final Map<Pair<Integer, Integer>, Boolean> state) {
        Map<Pair<Integer, Integer>, Boolean> newState = new HashMap<Pair<Integer, Integer>, Boolean>();
        final Integer width = dimensions.first;
        final Integer height = dimensions.second;
        for (int row = 1; row <= height; row++) {
            for (int column = 1; column <= width; column++) {
                Pair<Integer, Integer> coordinates = Pair.create(column, row);
                if (state.get(coordinates) == Boolean.TRUE) {
                    newState.put(coordinates, Boolean.TRUE);
                } else {
                    newState.put(coordinates, Boolean.FALSE);
                }
            }
        }
        return newState;
    }

    public Pair<Integer, Integer> dimensions() {
        return dimensions;
    }

    public boolean stateAt(Pair<Integer, Integer> coordinates) {
        return state.get(wrapAroundBorders(coordinates));
    }

    private Pair<Integer, Integer> wrapAroundBorders(Pair<Integer, Integer> unwrapped) {
        int x_wrapped = unwrapped.first < 1 ? dimensions.first : unwrapped.first;
        x_wrapped = x_wrapped > dimensions.first ? 1 : x_wrapped;
        int y_wrapped = unwrapped.second < 1 ? dimensions.second : unwrapped.second;
        y_wrapped = y_wrapped > dimensions.second ? 1 : y_wrapped;
        return Pair.create(x_wrapped, y_wrapped);
    }

    public Integer neighbors(Pair<Integer, Integer> coordinates) {
        int neighbors = 0;
        for (int x = coordinates.first - 1; x <= coordinates.first + 1; x++) {
            for (int y = coordinates.second - 1; y <= coordinates.second + 1; y++) {
                if (stateAt(Pair.create(x, y)) == Boolean.TRUE) {
                    neighbors++;
                }
            }
        }
        if (stateAt(coordinates)) neighbors--;
        return neighbors;
    }
}