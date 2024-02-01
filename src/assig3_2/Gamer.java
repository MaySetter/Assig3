package assig3_2;

public class Gamer extends Thread {

    private int goodFlipsCounter; // Counts the number of successful flips that the player made
    private GamePlay gamePlay;

    /**
     * Constructor initializes gamePlay variable.
     *
     * @param gp GamePlay object.
     */
    public Gamer(GamePlay gp) {
        gamePlay = gp;
        this.goodFlipsCounter=0;
    }

    /**
     * Method runs a while loop. In every iteration, as long as no INTERRUPT and the number of coin flips in the whole game is less or equal to 10:
     * Tries flipping a coin, and if succeeds, advances goodFlipsCounter by 1,
     * and go to sleep for one second.
     */
    @SuppressWarnings("static-access")
	public void play() {
        while (!Thread.interrupted() && gamePlay.getNumOfRounds() <= 10) {
            // Try flipping a coin
            // If the flip succeeds, increment the goodFlipsCounter
            this.goodFlipsCounter=this.goodFlipsCounter+gamePlay.flipCoin();;//flipcoin() return 1 if succeed and 0 if not succeed.

            try {
                // Sleep for one second
               Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                // Handle interrupted exception if needed
               System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Getter
     *
     * @return number of successful coin flips.
     */
    public int getScore() {
        return goodFlipsCounter;
    }
/**
 * Run method to start play .
 * must implements to use Gamer as Thread.
 */
    public void run() {
        this.play();
    }
}
