/**
 * 
 */
package com.cloudwick.java.user;

import com.cloudwick.java.factory.AuthenticateI;
import com.cloudwick.java.factory.UserFactory;
import com.cloudwick.java.oops.ChildClass;
import com.cloudwick.java.oops.ParentClass;
import com.cloudwick.java.oops.UserEquals;
import com.cloudwick.java.oops.UserI;
import com.cloudwick.java.person.PersonManager;
import com.cloudwick.java.prototype.UserPrototype;
import com.cloudwick.java.singleton.UserEnum;
import com.cloudwick.java.singleton.UserSingleton;

/**
 * @author sai
 * 
 */
public class UserManager {

	private String name;
	int age;

	public UserManager(String city) {
		name = city;
	}

	public UserManager() {

	}

	public int getData(int id) {
		this.age = id;
		return age;
	}

	/**
	 * @param args
	 *            static resource is shared or class level resource
	 */
	public static void main(String[] args) {
		// Testing UserManager
		UserManager uObj = new UserManager();
		uObj.name = "Fremont";
		uObj.age = 24;
		int data = uObj.getData(36);

		System.out.println("Age: " + uObj.age);
		System.out.println("Name: " + uObj.name);
		System.out.println("Data: " + data);

		UserManager uObj2 = new UserManager("F");

		System.out.println(uObj2.name);

		PersonManager pObj = new PersonManager();
		int sumData = pObj.cal(24, 36);
		System.out.println("Sum is: " + sumData);

		PersonManager.state = "CA";
		System.out.println("State 1:" + PersonManager.state);
		pObj.state = "TX";
		System.out.println("State 2:" + PersonManager.state);

		System.out.println(uObj);

		if (uObj == uObj2) {
			System.out.println("Equal Objects");
		} else {
			System.out.println("not Equal Objects");
		}

		// Inheritance testing
		ChildClass cObj = new ChildClass();
		cObj.city = "Fremont";
		cObj.printData();

		ParentClass parentObj = new ParentClass();
		ParentClass parentObj2 = new ChildClass();
		ChildClass childObj = new ChildClass();

		System.out.println("ID is: " + parentObj2.printData(24));
		System.out.println("ID is: " + childObj.printData(24));

		// testing interface with implemented method
		System.out.println("Override method returns id: "
				+ childObj.getStateCode(10));
		System.out.println(UserI.STATE);
		childObj.printAdmin(); // multiple interface implementation

		childObj.abstractPrint();
		System.out.println("Printing: " + childObj.getId());

		// testing Equals and Hash code

		UserEquals userObj5 = new UserEquals(24, "F", "C");
		UserEquals userObj6 = new UserEquals(24, "F", "C");

		if (userObj5.equals(userObj6)) {
			System.out.println("Object values equal");
		} else {
			System.out.println("Object values are not equal");
		}

		// Testing factory pattern

		AuthenticateI fObj1 = UserFactory.getObject("Admin");
		fObj1.authenticate();

		AuthenticateI fObj2 = UserFactory.getObject("Gen");
		fObj2.authenticate();

		// Testing Prototype

		UserPrototype protObj1 = new UserPrototype();
		protObj1.name = "Fremont";

		// type casting object
		UserPrototype protObj2 = (UserPrototype) protObj1.clone();
		System.out.println("City form clone is: " + protObj2.name);
		
		//testing singleton
		
		UserSingleton singObj1 = UserSingleton.getInstance();
		singObj1.name ="USA";
		System.out.println("City form singleton class is : " + singObj1.name);
		
		UserSingleton singObj2 = UserSingleton.getInstance();
		System.out.println("City form singleton class is : " + singObj2.name);
		
		//testing enums
		
		System.out.println(UserEnum.CA.getId());
		System.out.println(UserEnum.TX.getId());
		System.out.println(UserEnum.UT.getId());
		System.out.println(UserEnum.valueOf("CA"));
		
		for(UserEnum e:UserEnum.values()){
			System.out.println(e.getId());
			
		}

	}

}
