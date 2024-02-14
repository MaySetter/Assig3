//@author Nir Hazan 316009489 , May Seter 312123037
package assig3_1;

public class assig3_1 {
	static Object lock=new Object();  // shared lock for all three theards.
	private static boolean t1Done = false;
    private static boolean t2Done = false;        //boolean flags to inform threads about pre-condition status.
    private static boolean t3Done = true;
static Thread t1=new Thread() {
	public void run() {          // Need to run 1 time from begining to end.                    
		synchronized(lock) {
		while (true) {
			while(!t3Done||t1Done) {   // Thread 1 need to wait if he alrady done and Thread 3 not done yet. 
			try {
				lock.wait();   //if pre-condition not exist wait untill some one wake him.
			} catch (InterruptedException e) {  
				System.out.println(e.getMessage());
			}
		}
			System.out.println("1AAAAAAAAA"); // Code part A(Thread 1 "job")
			t1Done=true;           //After done make his flag true and notify other thread that waiting for the lock.
			lock.notifyAll();
		}
		}
		}
	};
static Thread t2=new Thread() {
		public void run() {
			while(true) {  // Need to run X amount of runs from begining to end.
				synchronized(lock) {
				while(!t1Done) {     // Thread 2 need to wait if  Thread 1 not done yet.
					try {
						lock.wait(); //if pre-condition not exist wait untill some one wake him.
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
		}
				System.out.println("2BBBBB");// Code part B(Thread 2 "job")
				t2Done=true;  //After done make his flag true and notify other thread that waiting for the lock.
				lock.notifyAll();	
		}
			
		}
		}
		};
static Thread t3=new Thread() {
			public void run() {
				synchronized(lock) {
				while(true) {       // Need to run 1 time from begining to end.
					
						while(!t2Done) {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								System.out.println(e.getMessage());
							}
						}
					System.out.println("3CCCCCCC");// Code part C(Thread 3 "job")
					 t1Done = false;  // Make Thread 1 pre condition to exists
	                		 t2Done = false;   // when Thread 3 runs its the end of the loop of all thread and Thread1 Thread2 get their pre condition
	                		 t3Done=true;     //After done make his flag true and notify other thread that waiting for the lock.
	                 		lock.notifyAll();
				}
				}
			}
			};
public static void main(String [] args) {
	t1.start();   // Start running all 3 Threads.
	t2.start();
	t3.start();
	
}

}
