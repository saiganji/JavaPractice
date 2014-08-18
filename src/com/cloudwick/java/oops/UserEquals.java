/**
 * 
 */
package com.cloudwick.java.oops;

/**
 * @author sai
 * 
 */
public class UserEquals {
	private int ssn;
	private String name;
	private String city;

	public UserEquals(int s, String n, String c) {
		this.ssn = s;
		this.name = n;
		this.city = c;
	}

	@Override
	public boolean equals(Object o) {

		if (o == null) {
			return false;
		}
		if (!(o instanceof UserEquals)) {
			return false;
		}

		UserEquals uObj = (UserEquals) o;

		return (this.ssn == uObj.getSsn() && this.name.equals(uObj.getName()) && this.city
				.equals(uObj.getCity()));
	}
	
	public int hashcode(){
		int hash = 7;
		hash += 9*this.ssn;
		hash += 9*(this.name == null ?0: this.name.hashCode());
		hash += 9*(this.city == null ?0: this.city.hashCode());
		
		return hash;
	}

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

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

}
