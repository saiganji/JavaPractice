/**
 * 
 */
package com.cloudwick.java.thread;

//import java.awt.List;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sai
 * 
 */
public class ThreadExample {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		List<Thread> threadlist = new ArrayList<Thread>();
		
		for (int i = 0; i < 500; i++) {
			
			UserThread obj = new UserThread(10000 + i);
			obj.setName("Cloudwick"+i);
			if(i>40 && i <=50){
				obj.setPriority(Thread.MAX_PRIORITY);
			}
			obj.start();
			threadlist.add(obj);
		}
		int running = 0;
		do{
			running = 0;
			for(Thread t:threadlist){
				if(t.isAlive()){
					running++;
				}
			}
		}
		while(running != 0);
		Thread.currentThread().sleep(5000);
		System.out.println("Finished processing");
	}
}
