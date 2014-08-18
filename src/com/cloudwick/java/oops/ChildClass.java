/**
 * 
 */
package com.cloudwick.java.oops;

/**
 * @author sai
 *
 */
public class ChildClass extends ParentClass implements UserI, AdminI{
	public void printData(){
		System.out.println("Coming from child");
		
		
	}

	@Override
	public int getStateCode(int id) {
		return id;
		
	
	}

	@Override
	public void printAdmin() {
		System.out.println("Admin Print");
		
	}

}
