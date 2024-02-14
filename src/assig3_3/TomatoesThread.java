//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

/**
 * TomatoesThread class is responsible for feeding tomatoes to the slicing machine.
 */
public class TomatoesThread extends Thread {
	private final SlicerMachine slicerMachine; // Slicer machine only represend the cells no need to be changed-final.
	public TomatoesThread(SlicerMachine sm) {

		this.slicerMachine = sm;
	}

	public void run() {
		while (!isInterrupted()){
			synchronized (this.slicerMachine) {
				try {     // if tomato cell is full go to wait.
					while (this.slicerMachine.getNumOfTomatoes() == slicerMachine.getTomatoesNeededForOneSalad()) {
						this.slicerMachine.wait();
					}
					this.slicerMachine.addOneTomato(); // if there is a place add one tomato to the cell.
				} catch (InterruptedException e) {}
			}
		}
	}
}
