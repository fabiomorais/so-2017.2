package threads;

public class MainSync {

	public Integer n = 100;
	public Integer value = 0;
	
	public synchronized void inc() {
		this.value = value + 1;
	}
	
	public synchronized void dec() {
		this.value = value - 1;
	}
	
	public class T1 extends Thread {
		
		public void run() {
	    	for (int i = 0; i < n; i++) {
	    		 inc();
  	    		 //System.out.println(value);
			}  
	    }
	}
	
	public class T2 extends Thread {
		
		public void run() {
	    	for (int i = 0; i < n; i++) {
	    		 dec();
 	    		 //System.out.println(value);
			}
	       
	    }
		
	}
	   
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Java synchronized");

		MainSync m = new MainSync();
		
		System.out.println("Valor inicial: " + m.value);
		
		Thread t1 = m.new T1();
		Thread t2 = m.new T2();
		
		t2.start();
		t1.start();
			
		t1.join();
		t2.join();

		System.out.println("Valor final " + m.value);
		
	}
}
