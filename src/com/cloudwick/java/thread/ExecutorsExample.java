/**
 * 
 */
package com.cloudwick.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sai
 * 
 */
public class ExecutorsExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService ex = Executors.newFixedThreadPool(100); // object with
																// resources
		for (int i = 0; i < 500; i++) {

			UserThread obj = new UserThread(1000000 + i);
			ex.execute(obj);

		}
		ex.shutdown();
		do{
			
		}
		while(!ex.isTerminated());
		System.out.println("Finished Processing");
	}

}
