// Nir Hazan 316009489 , May Seter 312123037
package assig3_2;
/**
 * The Judge class represents a judge in the game, who lets the Gamers know when they can
 * flip the coin, by making the coin available/unavailable
 * @author Nir Hazan 316009489 , May Seter 312123037
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
    	 while (!Thread.interrupted() && gamePlay.getNumOfRounds() <= 10) {
    		 try {
               // Make the coin unavailable for a second than judge sleep
                if(!this.gamePlay.getCoinStatus()) {
                	
                	this.gamePlay.makeCoinAvail(true);
                	System.out.println("Coin available for half second");
					Thread.currentThread().sleep(500);;
                
                	}
              // Make the coin available for half a second then judge sleep
                else {
                		this.gamePlay.makeCoinAvail(false);
                		System.out.println("Coin unavailable for one second");
                		Thread.currentThread().sleep(1000);
                		
                	}
            	}catch (InterruptedException e) {
            // Handle interrupted exception if needed
        	System.out.println(e.getMessage());
        }
    	 }
    }
	/**
	 * run method  that start judge 
	 * must implement to use Judge as a thread.
	 */
	public void run() {
       this.judge();
    }
}
