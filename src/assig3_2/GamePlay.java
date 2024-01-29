package assig3_2;

/**
 * The GamePlay class represents the game itself, the coin and the number of coin flips.
 */
public class GamePlay {

    private boolean _available_c; // is coin available
    private int  _counter_r; // The amount of coin flips made in the game

    /**
     * Enables or disables the coin according to the val value
     * If the coin becomes available, the other threads who are waiting for the coin
     * are informed about it.
     * Updates the _available_coin field according to the value it received.
     * @param val int
     */
    public void makeCoinAvail(boolean val){}

    /**
     * If the coin isn't available, thread will wait until it becomes available,
     * will print its name, and that it is waiting.
     * If the coin is available, the thread will print that it is flipping a coin,
     * will make the coin unavailable during the toss, will advance the number of tosses by 1,
     * and will randomly generate 0 or 1. Will then make the coin available again, and notify other threads.
     * @return result of the throw (0 = false/failure, 1 = true/success)
     */
    public int flipCoin(){
        return 0;
    }

    /**
     * Getter.
     * @return number of coin flips in the game.
     */
    public int getNumOfRounds(){
        return 0;
    }

}
