/**
 * 
 */
package com.cloudwick.java.singleton;

/**
 * @author sai
 *
 */
public class UserSingleton {
	private static UserSingleton obj;
	public String name;
	private UserSingleton(){
		
	}
	public static UserSingleton getInstance(){
		if(obj==null){
			obj = new UserSingleton();
		}
		return obj;
	}

}
