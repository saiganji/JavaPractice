package com.cloudwick.java.project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ComcastThread extends Thread {

	private String fileName;

	public ComcastThread(String fileName) {
		this.fileName = fileName;

	}

	public void run() {
		FileReader fr = null;
		BufferedReader Br = null;
		Map<String, Integer> countMap = null;
		try {
			fr = new FileReader(fileName);
			Br = new BufferedReader(fr);
			String data = null;
			countMap = new HashMap<>();

			while ((data = Br.readLine()) != null) {
				String[] mydata = data.split(",");
				String zip = mydata[3];
				String channel = mydata[4];
				System.out.println("Zip " + zip);
				System.out.println("Channel " + channel);
				System.out.println(this.currentThread().getName());
				
				String combined = zip + "," + channel;
				if (!countMap.containsKey(combined)) {
					countMap.put(combined, 1);
				} else {
					int counter = countMap.get(combined);
					countMap.put(combined, ++counter);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} 
		
		finally {
			try {
				Br.close();
				fr.close();
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			 fw = new FileWriter(Thread.currentThread().getName()+"Analytics.txt");
			 bw = new BufferedWriter(fw);
				Set<Entry<String, Integer>> entrySetData = countMap.entrySet();
				Iterator<Entry<String, Integer>> entryItr = entrySetData.iterator();
				while(entryItr.hasNext()){
					Entry<String, Integer> e = entryItr.next();
					String dataS = e.getKey();
					int valS = e.getValue();
					bw.write(dataS+":"+valS+"\n");
				
					
					System.out.println(dataS+":"+valS);
					
				}
				bw.flush();
				
			
			
			
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				bw.close();
				fw.close();
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
	}

}
