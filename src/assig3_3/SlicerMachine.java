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

	/**
	 * Constructor. Initializes tomatoes and cucumbers and number of salads to be 0,
	 * numOfSaladsToPrepare assigned the value of num
	 * @param num - number of salads needed to be prepared.
	 */
	public SlicerMachine(int num) {
		numOfCucumbers = 0;             // At first, machine is empty.
		numOfTomatoes = 0;
		numOfPreparedSalads = 0;
		this.numOfSaladToPrepare = num;

	}

	/**
	 * Method checks if there is an available place in the machine for a cucumber.
	 * If so, prints a message and increases the number of cucumbers in the machine by 1.
	 * If machine is full, notify all.
	 */
	public synchronized void addOneCucumber() {
		if (numOfCucumbers < cucumbersNeededForOneSalad) {  //only if there is place in the cell.
			System.out.println("adding one cucumber to the machine");
			numOfCucumbers++;
			if(numOfCucumbers == cucumbersNeededForOneSalad && numOfTomatoes == tomatoesNeededForOneSalad)
				notifyAll();
		}
	}

	/**
	 * Method checks if there is an available place in the machine for a cucumber.
	 * If so, prints a message and increases the number of cucumbers in the machine by 1.
	 * If machine is full, notify all.
	 */
	public synchronized void addOneTomato() {
		if (numOfTomatoes < tomatoesNeededForOneSalad) {  //only if there is place in the cell.
			System.out.println("adding one tomato to the machine");
			numOfTomatoes++;
			if(numOfTomatoes == tomatoesNeededForOneSalad && numOfCucumbers == cucumbersNeededForOneSalad)
				notifyAll();
		}
	}

	/**
	 * Method checks if machine is full. if so, calls the makeNewSalad() method.
	 */
	public synchronized void sliceVegetables(){
		if ((numOfCucumbers >= cucumbersNeededForOneSalad) && (numOfTomatoes >= tomatoesNeededForOneSalad)) {
			makeNewSalad();
		}
	}

	/**
	 * Method prints a message, increases the numbers of salads that has been prepared,
	 * removes the number of tomatoes and cucumbers that has been used for the salad from the machine,
	 * and notify all.
	 */
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
