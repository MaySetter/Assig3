//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

/**
 * TomatoesThread class is responsible for feeding tomatoes to the slicing machine.
 */
public class TomatoesThread extends Thread {
	private final SlicerMachine slicerMachine;

	/**
	 * Construction
	 * @param sm - SlicerMachine object
	 */
	public TomatoesThread(SlicerMachine sm) {
		this.slicerMachine = sm;
	}

	/**
	 * Method run inherited from Thread class.
	 * This Method runs a while loop that ends when an interruptedException is thrown.
	 * In the while loop, if the slicerMachine's tomato-chamber is full, thread waits.
	 * Else, addOneTomato method from slicerMachine is called.
	 * Method uses slicerMachine as a lock.
	 */
	public void run() {
		while (true){
			synchronized (this.slicerMachine) {
				try {
					while (this.slicerMachine.getNumOfTomatoes() == slicerMachine.getTomatoesNeededForOneSalad()) {
						this.slicerMachine.wait();
					}
					this.slicerMachine.addOneTomato();
					//sleep(500);
				} catch (InterruptedException e) {
					//System.out.println("Tomatoes Interrupted");
					break;
				}
			}
		}
	}
}
