package org.rubyspa.droidgol;

public class Rules {
    public static boolean apply(final int neighbors, final boolean selfAlive) {
        switch (neighbors) {
            case 3:
                return true;
            case 2:
                if (selfAlive) return true;
                else return false;
        }
        return false;
    }
}
