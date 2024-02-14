//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

/**
 * CucumbersThread class is responsible for feeding cucumbers to the slicing machine.
 */
public class CucumbersThread extends Thread {
	private final SlicerMachine slicerMachine;
	public CucumbersThread(SlicerMachine sm) {

		this.slicerMachine = sm;
	}

	public void run(){
		while (!isInterrupted()) {
			synchronized (this.slicerMachine) {
				try {
					while (this.slicerMachine.getNumOfCucumbers() == slicerMachine.getCucumbersNeededForOneSalad()) {
						this.slicerMachine.wait();
					}
					this.slicerMachine.addOneCucumber();
				} catch (InterruptedException e) {}
			}
		}
	}
}