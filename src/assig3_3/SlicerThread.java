//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

/**
 * SlicerThread class is responsible for slicing the vegetables.
 */
public class SlicerThread extends Thread {
	private final SlicerMachine slicerMachine;

	public SlicerThread(SlicerMachine sm) {
		this.slicerMachine = sm;
	}

	public void run() {
		synchronized (this.slicerMachine) {
			while (this.slicerMachine.getNumOfPreparedSalads() < this.slicerMachine.getNumOfSaladsToPrepare()) {
				while (veggiesNotReady()) {
					try {
						this.slicerMachine.wait();
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
				this.slicerMachine.sliceVegetables();
			}
		}
		currentThread().interrupt();
	}

	private boolean veggiesNotReady(){
		return (this.slicerMachine.getNumOfCucumbers() != this.slicerMachine.getCucumbersNeededForOneSalad()
				|| this.slicerMachine.getNumOfTomatoes() != this.slicerMachine.getTomatoesNeededForOneSalad());
	}
}