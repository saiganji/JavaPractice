/**
 * 
 */
package com.cloudwick.java.io;

import java.io.Serializable;

/**
 * @author sai
 * 
 */
public class UserSerialize implements Serializable {
	private  int ssn;   //  transient will make data hidden
	private  String name; // transient

	/**
	 * @return the ssn
	 */
	public int getSsn() {
		return ssn;
	}

	/**
	 * @param ssn
	 *            the ssn to set
	 */
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
