/**
 * 
 */
package com.cloudwick.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author sai
 *
 */
public class SerializableExample {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		FileOutputStream fos = new FileOutputStream("Serialize.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		UserSerialize obj = new UserSerialize();
		obj.setSsn(24);
		obj.setName("Fremont");
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		
		FileInputStream fis = new FileInputStream("Serialize.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj2 = ois.readObject();
		if(obj2 instanceof UserSerialize){
			UserSerialize obj3 = (UserSerialize)obj2;
			System.out.println(obj3.getSsn());
			System.out.println(obj3.getName());
		}
		
		

	}

}
