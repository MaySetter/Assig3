//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

/**
 * TomatoesThread class is responsible for feeding tomatoes to the slicing machine.
 */
public class TomatoesThread extends Thread {
	private final SlicerMachine slicerMachine;
	public TomatoesThread(SlicerMachine sm) {

		this.slicerMachine = sm;
	}

	public void run() {
		while (!isInterrupted()){
			synchronized (this.slicerMachine) {
				try {
					while (this.slicerMachine.getNumOfTomatoes() == slicerMachine.getTomatoesNeededForOneSalad()) {
						this.slicerMachine.wait();
					}
					this.slicerMachine.addOneTomato();
				} catch (InterruptedException e) {}
			}
		}
	}
}