package HW3;

public class assig3_1 {
	static Object lock=new Object();
	private static boolean t1Done = false;
    private static boolean t2Done = false;
    private static boolean t3Done = true;
static Thread t1=new Thread() {
	public void run() {
		synchronized(lock) {
		while (true) {
			while(!t3Done||t1Done) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
			System.out.println("1AAAAAAAAA");
			t1Done=true;
			lock.notifyAll();
		}
		}
		}
	};
static Thread t2=new Thread() {
		public void run() {
			while(true) {
				synchronized(lock) {
				while(!t1Done) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
		}
				System.out.println("2BBBBB");
				t2Done=true;
				lock.notifyAll();	
		}
			
		}
		}
		};
static Thread t3=new Thread() {
			public void run() {
				synchronized(lock) {
				while(true) {
					
						while(!t2Done) {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								System.out.println(e.getMessage());
							}
						}
					System.out.println("3CCCCCCC");
					 t1Done = false;
	                 t2Done = false;
	                 t3Done=true;
	                 lock.notifyAll();
				}
				}
			}
			};
public static void main(String [] args) {
	t1.start();
	t2.start();
	t3.start();
	
}

}
