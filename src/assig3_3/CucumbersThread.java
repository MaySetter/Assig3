//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

/**
 * CucumbersThread class is responsible for feeding cucumbers to the slicing machine.
 */
public class CucumbersThread extends Thread {
	private final SlicerMachine slicerMachine;

	/**
	 * Construction
	 * @param sm - SlicerMachine object
	 */
	public CucumbersThread(SlicerMachine sm) {

		this.slicerMachine = sm;
	}

	/**
	 * Method run inherited from Thread class.
	 * This Method runs a while loop that ends when an interruptedException is thrown.
	 * In the while loop, if the slicerMachine's cucumber-chamber is full, thread waits.
	 * Else, addOneCucumber method from slicerMachine is called.
	 * Method uses slicerMachine as a lock.
	 */
	public void run(){
		while (true) {
			synchronized (this.slicerMachine) {
				try {
					while (this.slicerMachine.getNumOfCucumbers() == slicerMachine.getCucumbersNeededForOneSalad()) {
						this.slicerMachine.wait();
					}
					this.slicerMachine.addOneCucumber();
					sleep(500);
				} catch (InterruptedException e) {
					//System.out.println("cucumbers Interrupted");
					break;
				}
			}
		}
	}
}
