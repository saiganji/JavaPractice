/**
 * 
 */
package com.cloudwick.java.oops;

/**
 * @author sai
 *
 */
public class ParentClass extends UserAbstract{
	public String city;
	
	public void printData(){
		System.out.println("City is: "+this.city);
	}
	public int printData(int id){
		return id;
	}
	@Override
	public int getId() {
		
		return 66;
	}

}
