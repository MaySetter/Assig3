//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_3;

import java.util.Scanner;
/**
	 * Program for an automatic salad making machine.
	 * number of salads that needs to be prepared - input from user.
	 */
public class Main {

	public static void main(String[] args)  throws InterruptedException{
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");
		// OUR CODE HERE: use threads to prepare N salads (as the user requested)
		SlicerMachine slicerMachine = new SlicerMachine(numOfSaladsToPrepare);
		CucumbersThread cucumbersThread = new CucumbersThread (slicerMachine);
		TomatoesThread tomatoesThread = new TomatoesThread(slicerMachine);       // initialize Threads.
		SlicerThread slicerThread = new SlicerThread(slicerMachine);
		// start
		cucumbersThread.start();
		tomatoesThread.start();
		slicerThread.start();
		// interrupt
		while(true) {
			if(slicerThread.isInterrupted()) {  // (Cancellation)
				cucumbersThread.interrupt();
				tomatoesThread.interrupt();
				break;
			}
		}
		// join
		slicerThread.join();
		cucumbersThread.join();
		tomatoesThread.join();
		// end
		System.out.println("Done");
		scan.close();
	}
}
