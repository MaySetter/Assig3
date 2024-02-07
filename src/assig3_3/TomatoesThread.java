//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

/**
 * TomatoesThread class is responsible for feeding tomatoes to the slicing machine.
 */
public class TomatoesThread extends Thread {
	private SlicerMachine slicerMachine;

	public TomatoesThread(SlicerMachine sm) {
		this.slicerMachine=sm;
	}

	public void run() {

		int numTomatoesNeeded = slicerMachine.getTomatoesNeededForOneSalad();

		while(true) {
			synchronized (slicerMachine) {
				while (this.slicerMachine.getNumOfTomatoes() == numTomatoesNeeded) {
					try {
						System.out.println("Tomatoes cell is full.");
						this.wait();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				try{
					this.slicerMachine.addOneTomato();
				}catch (Exception e) {
					e.printStackTrace();
				}
				if (slicerMachine.getNumOfSaladsToPrepare() == slicerMachine.getNumOfPreparedSalads()) break;
//				if(slicerMachine.getNumOfTomatoes() == numTomatoesNeeded)
//				notifyAll();
			}
		}
	}
}