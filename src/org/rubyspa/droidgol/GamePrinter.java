package org.rubyspa.droidgol;

import android.util.Pair;

public class GamePrinter {
    public static String print(final Game game) {
        StringBuilder gamePrintout = new StringBuilder();
        Pair<Integer,Integer> dimensions = game.dimensions();
        for (int y = 1; y <= dimensions.second; y++) {
            for (int x = 1; x <= dimensions.first; x++) {
                if (game.stateAt(Pair.create(x, y)) == Boolean.TRUE)
                    gamePrintout.append('o');
                else
                    gamePrintout.append(' ');
            }
            if (y < dimensions.second) gamePrintout.append('\n');
        }
        return gamePrintout.toString();
    }
}
