package com.cloudwick.java.json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonExample {

	/**
	 * @param args
	 * @throws IOException
	 */

	private static void writeJsonData() throws IOException {
		JSONObject obj = new JSONObject();
		obj.put("age", "24");
		obj.put("name", "Ganji");

		JSONArray arr = new JSONArray();
		arr.add("msg1");
		arr.add("msg2");

		obj.put("messages", arr);

		FileWriter out = new FileWriter("test.json");
		out.write(obj.toJSONString());
		out.flush();
		out.close();

	}

	private static void readJsonData() throws IOException, ParseException {
		FileReader in = new FileReader("test.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(in);
		JSONObject dataObj = (JSONObject) obj;
		String name = (String) dataObj.get("name");

		System.out.println(name);
		String age = (String) dataObj.get("age");
		System.out.println(age);

		JSONArray arr = (JSONArray) dataObj.get("messages");

		Iterator itr = arr.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		in.close();

	}

	private static void jsonStreaming() throws IOException {
		JSONArray list = new JSONArray();
		list.add("1");
		list.add(null);
		list.add(new Integer(24));
		list.add(new Boolean(true));

		StringWriter out = new StringWriter();
		list.writeJSONString(out);
		System.out.println(out.toString());

	}

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		writeJsonData();
		readJsonData();
		jsonStreaming();

	}
}
