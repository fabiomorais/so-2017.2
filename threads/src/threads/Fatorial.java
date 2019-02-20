package threads;

import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Fatorial {

	static BigInteger factorial = new BigInteger("1");
	static List<BigInteger> valores = Collections.synchronizedList(new ArrayList<BigInteger>());
	
	public static class Worker extends Thread{
		
		private int i;
		private int j;
		
		public Worker(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public void run() {
			BigInteger factorial = new BigInteger("1");;
			for (int x = i; x <= j; x++) {
				factorial = factorial.multiply(new BigInteger(String.valueOf(x)));
			}
			valores.add(factorial);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		int value = 100000;
		long startTime = System.currentTimeMillis();
		
		for (int i = 1; i <= value; i++) {
			factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
		}

		System.out.println("Fatorial simples em " + (System.currentTimeMillis() - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		List<Thread> listaT = new ArrayList<Thread>();
		
		int range = 1000;
		for (int i = 1; i <= value; i= i+range) {
			Thread t = new Worker(i, i + range - 1);
			t.start();
			listaT.add(t);
		}
		
		for (Thread thread : listaT) {
			thread.join();
		}
		
		BigInteger factorialT = new BigInteger("1");
		for (BigInteger val : valores) {
			factorialT = factorialT.multiply(val);
		}
		System.out.println("Fatorial threads em " + (System.currentTimeMillis() - startTime) + " ms");
	
		System.out.println(factorialT.equals(factorial));
	}

}
