package assig3_2;

/**
 * The Judge class represents a judge in the game, who lets the Gamers know when they can
 * flip the coin, by making the coin available/unavailable
 */
public class Judge extends Thread {
	private GamePlay gamePlay;
    public Judge(GamePlay game) {
		this.gamePlay=game;
	}

	/**
     * A loop, in which as long as the thread was not interrupted, the Judge makes the coin
     * unavailable for a second and then makes the coin available for half a second.
     */
    @SuppressWarnings("static-access")
	public void judge() {
    	
        try {
            while (!Thread.interrupted() && gamePlay.getNumOfRounds() <= 10) {
            	synchronized(this.gamePlay) {
               // Make the coin unavailable for a second
                if(!this.gamePlay.getCoinStatus()) {
                	
                	this.gamePlay.makeCoinAvail(true);
                	System.out.println("Coin available for half second");
                	Judge.currentThread().sleep(500);
                	}
              // Make the coin available for half a second
                else {
                		this.gamePlay.makeCoinAvail(false);
                		System.out.println("Coin unavailable for one second");
                		Judge.currentThread().sleep(1000);
                	}
            	}
            }
        } catch (InterruptedException e) {
            // Handle interrupted exception if needed
        	System.out.println(e.getMessage());
        }
    }

	public void run() {
       this.judge();
    }
}
