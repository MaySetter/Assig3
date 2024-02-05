// Nir Hazan 316009489 , May Seter 312123037
package assig3_2;
import java.util.Random;
/**
 * The GamePlay class represents the game itself, the coin and the number of coin flips.
 * @author Nir Hazan 316009489 , May Seter 312123037
 */
public class GamePlay {
	private final Judge judge;
    private boolean coin_available_; // is coin available
    private int rounds_counter_; // The amount of coin flips made in the game

    /**
     * Constructor for GamePlay set coin to true and number of rounds to 0; Creates a judge
     */
    public GamePlay() {
    	this.coin_available_ = false;
        this.rounds_counter_ = 1;
        judge = new Judge(this);
    }

    /**
     * Enables or disables the coin according to the val value
     * If the coin becomes available, the other threads who are waiting for the coin
     * are informed about it.
     * Updates the coin_available_ field according to the value it received.
     * @param val true or false.
     */
    public synchronized void makeCoinAvail(boolean val) {
        this.coin_available_ = val;
        if (coin_available_)
            notifyAll();
    }

    /**
     * If the coin isn't available, thread will wait until it becomes available,
     * will print its name, and that it is waiting.
     * If the coin is available, the thread will print that it is flipping a coin,
     * will make the coin unavailable during the toss, will advance the number of tosses by 1,
     * and will randomly generate 0 or 1. Will then make the coin available again, and notify other threads.
     * @return result of the throw (0 = false/failure, 1 = true/success)
     */
    public synchronized int flipCoin() {
    	while (!coin_available_) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for coin.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is flipping coin.");
        coin_available_ = false;
        rounds_counter_++;
        int result = new Random().nextInt(2);
        coin_available_ = true;
        return result;
    }

    /**
     * Getter.
     * @return number of coin flips in the game.
     */
    public int getNumOfRounds() {
        return rounds_counter_;
    }


	 /**
     * Getter.
     * @return judge to start. .
     */
	public Judge getJudge() {
		return this.judge;
	}
}
