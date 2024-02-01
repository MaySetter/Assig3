package assig3_2;

/**
 * The Judge class represents a judge in the game, who lets the Gamers know when they can
 * flip the coin, by making the coin available/unavailable
 */
public class Judge extends Thread {
	private GamePlay gp;
    public Judge(GamePlay game) {
		this.gp=game;
	}

	/**
     * A loop, in which as long as the thread was not interrupted, the Judge makes the coin
     * unavailable for a second and then makes the coin available for half a second.
     */
    public void judge() {
        try {
            while (!Thread.interrupted()) {
                // Make the coin unavailable for a second
                this.gp.makeCoinAvail(false);
                Judge.sleep(1000);

                // Make the coin available for half a second
                this.gp.makeCoinAvail(true);
                Judge.sleep(500);
            }
        } catch (InterruptedException e) {
            // Handle interrupted exception if needed
            e.printStackTrace();
        }
    }

    public void run() {
        this.judge();
    }
}
