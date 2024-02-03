//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

/**
 * SlicerThread class is responsible for slicing the vegetables.
 */
public class SlicerThread extends Thread {
	private SlicerMachine slicerMachine;
	public SlicerThread(SlicerMachine sm) {
		this.slicerMachine=sm;
	}
	public void run() {
		synchronized(this.slicerMachine) {
			while(this.slicerMachine.getNumOfPreparedSalads()<this.slicerMachine.getNumOfSaladsToPrepare()) {
		while(this.slicerMachine.getNumOfCucumbers()!=this.slicerMachine.cucumbersNeededForOneSalad||this.slicerMachine.getNumOfTomatoes()!=this.slicerMachine.tomatoesNeededForOneSalad) {
			try {
				System.out.println("Cant make salad yet  cells are not full.");
				this.slicerMachine.wait();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		this.slicerMachine.sliceVegetables();
			
		}
		}	
	}
}
