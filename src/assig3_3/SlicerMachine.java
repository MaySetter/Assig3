//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

/**
 * SlicerMachine class represents the functions of the machine.
 */
public class SlicerMachine {
	private int numOfCucumbers = 0;
	private int numOfTomatoes = 0;
	private int numOfPreparedSalads = 0;
	private final int cucumbersNeededForOneSalad = 3;
	private final int tomatoesNeededForOneSalad = 2;
	private final int numOfSaladToPrepare;

	public SlicerMachine(int num) {
		this.numOfSaladToPrepare = num;
	}

	// add one cucumber into the slicer chamber
	public synchronized void addOneCucumber() throws InterruptedException {
		while (numOfCucumbers >= cucumbersNeededForOneSalad) {
			wait();
		}
		System.out.println("adding one cucumber to the machine");
		numOfCucumbers++;
		notifyAll();
	}

	// add one tomato into the slicer chamber
	public synchronized void addOneTomato() throws InterruptedException {
		while (numOfTomatoes >= tomatoesNeededForOneSalad) {
			wait();
		}
		System.out.println("adding one tomato to the machine");
		numOfTomatoes++;
		notifyAll();
	}
	
	// if there are enough vegetables in the slicer
	// chamber, make another salad
	public synchronized void sliceVegetables() {
		if ((numOfCucumbers == cucumbersNeededForOneSalad) && (numOfTomatoes == tomatoesNeededForOneSalad)) {
			makeNewSalad();
		}
	}

	private synchronized void makeNewSalad() {
		System.out.println("== preparing one more salad ==");
		numOfPreparedSalads++; 
		// update stock
		numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
		numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
		notifyAll();
	}	
	
	public int getNumOfPreparedSalads() {
		return numOfPreparedSalads;
	}

	public int getNumOfCucumbers() {return this.numOfCucumbers;}

	public int getNumOfTomatoes() { return this.numOfTomatoes; }

	public int getNumOfSaladsToPrepare() { return this.numOfSaladToPrepare;}

	public int getCucumbersNeededForOneSalad() { return this.cucumbersNeededForOneSalad;}

	public int getTomatoesNeededForOneSalad() { return this.tomatoesNeededForOneSalad;}

}

