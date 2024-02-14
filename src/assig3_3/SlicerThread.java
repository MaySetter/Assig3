//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

/**
 * SlicerThread class is responsible for slicing the vegetables.
 */
public class SlicerThread extends Thread {
	private final SlicerMachine slicerMachine;


	/**
	 * Construction
	 * @param sm - SlicerMachine object
	 */
	public SlicerThread(SlicerMachine sm) {
		this.slicerMachine = sm;
	}

	/**
	 * Method run inherited from Thread class.
	 * This Method runs a while loop. When the desired amount of salads has been prepared,
	 * the thread gets interrupted and breaks out of the loop.
	 * In the loop, if the slicerMachine's tomato AND cucumber chambers aren't full (veggiesNotReady), thread waits.
	 * Else, sliceVegetables method from slicerMachine is activated.
	 * Method uses slicerMachine as a lock.
	 */
	public void run() {
		while (true) {
			synchronized (this.slicerMachine) {
				try {
					while (veggiesNotReady())
						this.slicerMachine.wait();
					this.slicerMachine.sliceVegetables();
				} catch (InterruptedException e) {
					break;
				}
			}
			if (this.slicerMachine.getNumOfPreparedSalads() == this.slicerMachine.getNumOfSaladsToPrepare())
				this.interrupt();
		}
	}

	/**
	 * Checks if the slicerMachine's tomato AND cucumber chambers are full or not.
	 * @return true if not full, false if otherwise.
	 */
	private boolean veggiesNotReady(){
		return (this.slicerMachine.getNumOfCucumbers() != this.slicerMachine.getCucumbersNeededForOneSalad()
				|| this.slicerMachine.getNumOfTomatoes() != this.slicerMachine.getTomatoesNeededForOneSalad());
	}
}
