//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

/**
 * CucumbersThread class is responsible for feeding cucumbers to the slicing machine.
 */
public class CucumbersThread extends Thread {
	private SlicerMachine slicerMachine;
	public CucumbersThread(SlicerMachine sm) {
		this.slicerMachine=sm;
	}

	public void run() {

		int numCucumbersNeeded = slicerMachine.getCucumbersNeededForOneSalad();

		while(true) {
			synchronized (slicerMachine) {
				while (this.slicerMachine.getNumOfCucumbers() == numCucumbersNeeded) {
					try {
						System.out.println("Cucumbers cell is full.");
						this.wait();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				try{
					this.slicerMachine.addOneCucumber();
				} catch (Exception e){
					e.printStackTrace();
				}
				if (slicerMachine.getNumOfSaladsToPrepare() == slicerMachine.getNumOfPreparedSalads()) break;
//				if(slicerMachine.getNumOfCucumbers() == numCucumbersNeeded)
//					notifyAll();
			}
		}
	}
}