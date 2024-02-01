package assig3_2;

/**
 * The Gamer class represents a player thread who flips the coin repeatedly
 */
public class Gamer extends Thread{

    private int goodFlipsCounter; // Counts the number successful flips that the player made
    private GamePlay gamePlay;

    /**
     * Constructor initializes gamePLay variable.
     * @param gp GamePlay object.
     */
    public Gamer(GamePlay gp){
        gamePlay = gp;
    }

    /**
     * Method runs a while loop. In every iteration, as long as no INTERRUPT
     * and the number of coin flips in the whole game is less or equal to 10:
     * Tries flipping a coin, and if succeeds, advances goodFlipsCounter by -1,
     * and go to sleep for one second.
     */
    public void play(){
         while (gamePlay.getNumOfRounds() <= 10) {
            // Try flipping a coin
            int flipResult = gamePlay.flipCoin();

            // If the flip succeeds, increment the goodFlipsCounter
            this.goodFlipsCounter=this.goodFlipsCounter+flipResult;

            try {
                // Sleep for one second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle interrupted exception if needed
                e.printStackTrace();
            }
        }
    }

    /**
     * Getter
     * @return number of successful coin flips.
     */
    public int getScore(){
        return goodFlipsCounter;
    }

    public void run(){
        this.play();
    }
}
