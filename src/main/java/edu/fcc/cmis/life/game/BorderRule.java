package edu.fcc.cmis.life.game;

public class BorderRule {

    /**
     * Bound incoming input {@param myPosition} within bounds {@param N} such that
     * myPosition is within interval [0, max)
     * @param myPosition
     * @param N
     * @return
     */
    public static int bound(int myPosition, int N) {
        if (myPosition < 0 ) {
            myPosition = N - 1;

        } else if (myPosition >= N){
            myPosition = 0;

        } else {
            return myPosition;

        }
    return myPosition;
    }
}
