package com.cloudwick.java.project1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComcastExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ExecutorService ex = Executors.newFixedThreadPool(2);
		
			ComcastThread thread1 = new ComcastThread("CA_COMCAST.txt");
			ex.execute(thread1);
			
			
			ComcastThread thread2 = new ComcastThread("TX_COMCAST.txt");
			ex.execute(thread2);

		
		ex.shutdown();
		do {
			
		} while (!ex.isTerminated());
		System.out.println("Finished Processing");
	}

}
