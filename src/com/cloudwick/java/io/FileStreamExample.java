/**
 * 
 */
package com.cloudwick.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sai
 * 
 */
public class FileStreamExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileStreamExample streamObj = new FileStreamExample();
		try {
			//streamObj.createMyFile("bye.txt");
			streamObj.writeContent("hello.txt");
			streamObj.readContent("hello.txt");
		} //catch (FileExistsException e) {

			//e.printStackTrace();
	//	} 
	catch (IOException e) {

			e.printStackTrace();
		}

	}

	private void createMyFile(String firstName) throws FileExistsException,
			IOException {
		File Obj = new File(firstName);
		if (!(Obj.exists())) {
			Obj.createNewFile();
		} else {
			throw new FileExistsException("Sorry file already exists");
		}

	}

	private void writeContent(String fName) throws IOException {
		FileOutputStream foo = null;
		try{
		foo = new FileOutputStream(fName);
		String data = "I live in california, eureka kasamika!!!";
		foo.write(data.getBytes());
		foo.flush();
		}
		finally{
			if(foo!=null){
				foo.close();
			}
		}

	}

	private void readContent(String fName) throws IOException {
		FileInputStream fis = new FileInputStream(fName);
		int data = 0;
		try{
		while((data = fis.read())!= -1){
			System.out.print((char)data);
		}
	}
		finally{
			if(fis!=null){
				fis.close();
			}
		}
	}

}
