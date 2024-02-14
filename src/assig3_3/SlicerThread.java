//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

/**
 * SlicerThread class is responsible for slicing the vegetables.
 */
public class SlicerThread extends Thread {
	private final SlicerMachine slicerMachine; // Slicer machine only represend the cells no need to be changed-final.

	public SlicerThread(SlicerMachine sm) {
		this.slicerMachine = sm;
	}

	public void run() {
		synchronized (this.slicerMachine) {
			while (this.slicerMachine.getNumOfPreparedSalads() < this.slicerMachine.getNumOfSaladsToPrepare()) {
				while (veggiesNotReady()) {  // if not 3 cucumbers and 2 tomato need to wait.
					try {
						this.slicerMachine.wait();
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
				this.slicerMachine.sliceVegetables(); // if cells are full cut 1 salad.
			}
		}
		currentThread().interrupt(); // after finsih all the salads ask thread to stop (cancelletion).
	}

	private boolean veggiesNotReady(){ // check if there is 3 cucumbers and 2 tomatos in the machine.
		return (this.slicerMachine.getNumOfCucumbers() != this.slicerMachine.getCucumbersNeededForOneSalad()
				|| this.slicerMachine.getNumOfTomatoes() != this.slicerMachine.getTomatoesNeededForOneSalad());
	}
}
