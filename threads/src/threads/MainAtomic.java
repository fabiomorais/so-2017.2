package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class MainAtomic {

	public Integer n = 100;
	public AtomicInteger value = new AtomicInteger(0);
	
	public class T1 extends Thread {
		
		public void run() {
	    	for (int i = 0; i < n; i++) {
	    		value.decrementAndGet();
	    		//System.out.println(value);
			}
	       
	    }
		
	}
	
	public class T2 extends Thread {
		
		public void run() {
	    	for (int i = 0; i < n; i++) {
	    		value.incrementAndGet();
	    		//System.out.println(value);
	    	}
	    }
		
	}
	   
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Atomic Objects");

		MainAtomic m = new MainAtomic();
		
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
