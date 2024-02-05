// Nir Hazan 316009489 , May Seter 312123037
package assig3_2;
/**
 * The Judge class represents a judge in the game, who lets the Gamers know when they can
 * flip the coin, by making the coin available/unavailable
 * @author Nir Hazan 316009489 , May Seter 312123037
 */
public class Judge extends Thread {
	private final GamePlay gamePlay;
    public Judge(GamePlay game) {
		this.gamePlay = game;
	}

	/**
     * A loop, in which as long as the thread was not interrupted, the Judge makes the coin
     * unavailable for a second and then makes the coin available for half a second.
     */
	@SuppressWarnings("static-access")
	public synchronized void judge() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				//System.out.println("Coin available for half second");
				this.gamePlay.makeCoinAvail(true);
				Thread.currentThread().sleep(500);
				//System.out.println("Coin unavailable for one second");
				this.gamePlay.makeCoinAvail(false);
				Thread.currentThread().sleep(1000);
			}catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
    }

	/**
	 * run method. must implement to use Judge as a thread.
	 */
	public void run() {
		this.judge();
	}
}
