package org.rubyspa.droidgol;

public class Rules {
    public static boolean apply(int neighbors, boolean selfAlive) {
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
