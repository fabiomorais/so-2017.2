package threads;

public class Main {

	public Integer n = 100;
	public Integer value = 0;
	
	public class T1 extends Thread {
		
		public void run() {
	    	for (int i = 0; i < n; i++) {
	    		 value = value + 1;
			}
	       
	    }
	}
	
	public class T2 extends Thread {
		
		public void run() {
	    	for (int i = 0; i < n; i++) {
	    		 value = value - 1;
			}
	       
	    }
	}
	   
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Teste");

		Main m = new Main();
		
		System.out.println(m.value);
		
		Thread t1 = m.new T1();
		Thread t2 = m.new T2();
		
		t2.start();
		t1.start();
			
		t1.join();
		t2.join();

		System.out.println(m.value);
		
	}
}
