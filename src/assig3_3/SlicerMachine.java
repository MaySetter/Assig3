//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

import java.util.Scanner;

/**
 * SlicerMachine class represents the functions of the machine.
 */
public class SlicerMachine {
	Scanner scan=new Scanner(System.in);
	private int numOfCucumbers ;
	private int numOfTomatoes;                     // define variables 
	private int numOfPreparedSalads ;
	private final int numOfSaladToPrepare;
	private final int cucumbersNeededForOneSalad = 3;
	private final int tomatoesNeededForOneSalad = 2;
	public SlicerMachine(int num) {
		numOfCucumbers = 0;             // At begining machine is empty.
		numOfTomatoes = 0;
		numOfPreparedSalads = 0;
		this.numOfSaladToPrepare=num;

	}
	// add one cucumber into the slicer chamber
	public synchronized void addOneCucumber() {
		if (numOfCucumbers < cucumbersNeededForOneSalad) {  //only if there is place in the cell.
			System.out.println("adding one cucumber to the machine");
			numOfCucumbers++;
			if(numOfCucumbers==this.cucumbersNeededForOneSalad)
				notifyAll();
		}
	}

	// add one tomato into the slicer chamber
	public synchronized void addOneTomato() {
		if (numOfTomatoes < tomatoesNeededForOneSalad) {  //only if there is place in the cell.
			System.out.println("adding one tomato to the machine");
			numOfTomatoes++;
			if(numOfTomatoes==this.tomatoesNeededForOneSalad)
				notifyAll();
		}
	}

	// if there are enough vegetables in the slicer
	// chamber, make another salad
	public synchronized void sliceVegetables(){
		if ((numOfCucumbers >= cucumbersNeededForOneSalad) && (numOfTomatoes >= tomatoesNeededForOneSalad)) {
			makeNewSalad();
		}
	}
/**
// After check if cells are full start to make salad and notify when finished.
**/
	private synchronized  void makeNewSalad(){
		System.out.println("== preparing one more salad ==");
		numOfPreparedSalads++;
		// update stock
		numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
		numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
		notifyAll();
	}

	/**
	 * Getter
	 * @return int - number of salad that have already been prepared.
	 */
	int getNumOfPreparedSalads() {
		return numOfPreparedSalads;
	}

	/**
	 * Getter.
	 * @return int - Number of cucumbers currently in slicer machine
	 */
	public int getNumOfCucumbers() {
		return this.numOfCucumbers;
	}

	/**
	 * Getter.
	 * @return int - Number of tomatoes currently in slicer machine
	 */
	public int getNumOfTomatoes() {
		return this.numOfTomatoes;
	}

	/**
	 * Getter.
	 * @return int - number of salads that needs to be prepared
	 */
	public int getNumOfSaladsToPrepare() { return this.numOfSaladToPrepare; }

	/**
	 * Getter
	 * @return int - number of cucumbers needed to prepare one salad
	 */
	public int getCucumbersNeededForOneSalad() {return cucumbersNeededForOneSalad; }

	/**
	 * Getter
	 * @return int - number of tomatoes needed to prepare one salad
	 */
	public int getTomatoesNeededForOneSalad() { return tomatoesNeededForOneSalad; }

}
