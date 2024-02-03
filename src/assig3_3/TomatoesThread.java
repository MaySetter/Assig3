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
		synchronized(this.slicerMachine){
		while(this.slicerMachine.getNumOfPreparedSalads()<this.slicerMachine.getNumOfSaladsToPrepare()) {
			while(this.slicerMachine.getNumOfTomatoes()==this.slicerMachine.tomatoesNeededForOneSalad) {
			try {
				System.out.println("Tomatoes cell is full.");
				this.slicerMachine.wait();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}	
		}
		this.slicerMachine.addOneTomato();
	}
	}
}
}
