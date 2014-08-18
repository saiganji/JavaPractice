package com.cloudwick.java.json;

import java.util.List;

public class UserJSON {

	private int age;
	private String name;
	private List<String> messages;

	public UserJSON(int a, String n, List<String> m) {

		this.age = a;
		this.name = n;
		this.messages = m;
	}
	
	public String toString(){
		return "User [age ="+ age +" ,name= "+name+" ,messages= "+messages+" ]";
		
	}

}
