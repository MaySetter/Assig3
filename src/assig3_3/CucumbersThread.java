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
		synchronized(this.slicerMachine){
		while(this.slicerMachine.getNumOfPreparedSalads()<this.slicerMachine.getNumOfSaladsToPrepare()) {
			while(this.slicerMachine.getNumOfCucumbers()==this.slicerMachine.cucumbersNeededForOneSalad) {
			try {
				System.out.println("Cucumbers cell is full.");
				this.slicerMachine.wait();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}	
		}
		this.slicerMachine.addOneCucumber();
	}
	}
}
}
