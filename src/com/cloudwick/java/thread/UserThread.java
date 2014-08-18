/**
 * 
 */
package com.cloudwick.java.thread;

/**
 * @author sai
 * 
 */
public class UserThread extends Thread {
	private int count;

	public UserThread(int count) {
		this.count = count;
	}

	public void run() {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum = sum + i;
		}
		System.out.println(Thread.currentThread());
		System.out.println(Thread.currentThread().getName());
		System.out.println("Sum :"+sum);
	}

}
