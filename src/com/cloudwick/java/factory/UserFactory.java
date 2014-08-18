/**
 * 
 */
package com.cloudwick.java.factory;

/**
 * @author sai
 * 
 */
public class UserFactory {
	public static AuthenticateI getObject(String type) {
		AuthenticateI obj = null;
		if (type.equals("Admin")) {
			obj = new AdminUser();
		} else if (type.equals("Gen")) {
			obj = new GeneralUser();
		}

		return obj;

	}

}
