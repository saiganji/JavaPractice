/**
 * 
 */
package com.cloudwick.java.prototype;

/**
 * @author sai
 *
 */
public class UserPrototype implements Cloneable {
	
	public String name;
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
			return null;
		}
	}

}
