package com.cloudwick.java.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomExample {

	private static Document doc;
	private static List<Employee> objList = new ArrayList<>();
	//private static List<Employee> empList = new ArrayList<>();
	

	// Methods with rules, DOM parsing
	private static void parseMyFile(String fName)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory foc = DocumentBuilderFactory.newInstance();
		DocumentBuilder dom = foc.newDocumentBuilder();
		doc = dom.parse(fName);
	}

	//
	private static void processDocument() {
		// getting root element
		Element rootEl = doc.getDocumentElement();
		// getting no. of employee tags
		NodeList empList = rootEl.getElementsByTagName("Employee");
		for (int i = 0; i < empList.getLength(); i++) {
			Element e = (Element) empList.item(i);
			Employee empObj = new Employee();
			int id = Integer.parseInt(e.getAttribute("id"));

			NodeList nameList = e.getElementsByTagName("Name");
			Element nameEl = (Element) nameList.item(0);
			String name = nameEl.getFirstChild().getNodeValue();

			NodeList ageList = e.getElementsByTagName("Age");
			Element ageEl = (Element) ageList.item(0);
			int age = Integer.parseInt(ageEl.getFirstChild().getNodeValue());

			NodeList cityList = e.getElementsByTagName("City");
			Element cityEl = (Element) cityList.item(0);
			String city = cityEl.getFirstChild().getNodeValue();

			empObj.setEmpName(name);
			empObj.setAge(age);
			empObj.setEmpCity(city);
			empObj.setId(id);

			objList.add(empObj);

		}

	}
	private static void printEmployee(){
		Iterator<Employee> itr = objList.iterator();
		while(itr.hasNext()){
			Employee data = itr.next();
			System.out.println("Employee details:");
			System.out.println("ID is "+data.getId());
			System.out.println("Name is "+data.getEmpName());
			System.out.println("Age is "+data.getAge());
			System.out.println("City is "+data.getEmpCity());
			
		}
		
		
		
	}
	
	
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		parseMyFile("Employee.xml");
		processDocument();
		printEmployee();
		

		
	}

}
