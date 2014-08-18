/**
 * 
 */
package com.cloudwick.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author sai
 * 
 */
public class FileReaderExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReaderExample fre = new FileReaderExample();
		try {
			fre.process("input.tx");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void process(String fName) throws IOException {
		FileReader fr = new FileReader(fName);
		BufferedReader br = new BufferedReader(fr, 50);
		FileWriter fw = new FileWriter("output.txt");
		BufferedWriter bw = new BufferedWriter(fw, 50);
		String data = null;
		while ((data = br.readLine()) != null) {

			/*
			 * if(data.contains("94565")){
			 * 
			 * bw.write(data); bw.write("\n"); }
			 */
			/*
			 * String[] arr = data.split(","); if(arr[2].contains("94565")){
			 * bw.write(arr[1]); bw.write("\n"); }
			 */
			int count = 0;
			StringTokenizer st = new StringTokenizer(data, ",");
			while (st.hasMoreTokens()) {
				String newData = st.nextToken();
				if (count == 0) {
					bw.write(newData);
					bw.write("\n");
				}
				count++;
			}

		}
		bw.flush();
		fr.close();
		fw.close();

	}

}