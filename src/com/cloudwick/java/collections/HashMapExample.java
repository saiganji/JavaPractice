/**
 * 
 */
package com.cloudwick.java.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author sai
 * 
 */
public class HashMapExample {

	/**
	 * @param args
	 */
	private Map<Integer, String> dataMap;

	private void populateMap() {
		dataMap = new HashMap<>();
		dataMap.put(23, "fremont");
		dataMap.put(27, "Maryland");
		dataMap.put(27, "Newark");

	}

	private void readMapWithEntry() {
		Set<Entry<Integer, String>> dataSet = dataMap.entrySet();
		Iterator<Entry<Integer, String>> dataItr = dataSet.iterator();
		while(dataItr.hasNext()){
			Entry<Integer, String> data = dataItr.next();
			System.out.println(data.getKey());
			System.out.println(data.getValue());
		}
		
	}

	private void readMapWithKeys() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMapExample obj = new HashMapExample();
		obj.populateMap();
		obj.readMapWithEntry();

	}

}
