//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

import java.util.Scanner;

/**
 * SlicerMachine class represents the functions of the machine.
 */
public class SlicerMachine {
	Scanner scan=new Scanner(System.in);
	int numOfCucumbers ;
	int numOfTomatoes;
	int numOfPreparedSalads ;
	int numOfSaladToPrepare;
	final int cucumbersNeededForOneSalad = 3;
	final int tomatoesNeededForOneSalad = 2;
	public SlicerMachine(int num) {
	 numOfCucumbers = 0;
	 numOfTomatoes = 0;
	 numOfPreparedSalads = 0;
	 this.numOfSaladToPrepare=num;
		
	}
	// add one cucumber into the slicer chamber
	public synchronized void addOneCucumber() {
		if (numOfCucumbers < cucumbersNeededForOneSalad) {
			System.out.println("adding one cucumber to the machine");
			numOfCucumbers++;
			if(numOfCucumbers==this.cucumbersNeededForOneSalad)
				notifyAll();
		}
	}

	// add one tomato into the slicer chamber
	public synchronized void addOneTomato() {
		if (numOfTomatoes < tomatoesNeededForOneSalad) {
			System.out.println("adding one tomato to the machine");
			numOfTomatoes++;
			if(numOfTomatoes==this.tomatoesNeededForOneSalad)
				notifyAll();
		}
	}
	
	// if there are enough vegetables in the slicer
	// chamber, make another salad
	public synchronized void sliceVegetables() {
		if ((numOfCucumbers >= cucumbersNeededForOneSalad) && (numOfTomatoes >= tomatoesNeededForOneSalad)) {
			makeNewSalad();
		}
	}

	private synchronized  void makeNewSalad() {
		System.out.println("== preparing one more salad ==");
		numOfPreparedSalads++; 
		// update stock
		numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
		numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
		notifyAll();
	}	
	
	int getNumOfPreparedSalads() {
		return numOfPreparedSalads;
	}
/**
 * Getter.
 * @return int - Number of cucumbers in machine
 */
	public int getNumOfCucumbers() {
		return this.numOfCucumbers;
	}
	/**
	 * Getter.
	 * @return int - Number of tomatoes in machine
	 */
		public int getNumOfTomatoes() {
			return this.numOfTomatoes;
		}
		/**
		 * Getter.
		 * @return int - number of salads need to be prepare 
		 */
	public int getNumOfSaladsToPrepare() {
		
		return this.numOfSaladToPrepare;
	}

}
}
