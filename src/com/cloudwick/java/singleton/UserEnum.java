/**
 * 
 */
package com.cloudwick.java.singleton;

/**
 * @author sai
 *
 */
public enum UserEnum{ 
	CA("1"),
	TX("5"),
	UT("7");

	
	private String id;
	
	private UserEnum(String id){
		this.id = id;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	


}
