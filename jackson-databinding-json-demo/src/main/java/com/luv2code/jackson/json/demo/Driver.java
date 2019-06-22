package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read JSON file and map/convert to Java POJO
			//data/sample-litle.json
			Student student = 
					mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print first and lastname
			System.out.println("FirstName = "+student.getFirstName());
			System.out.println("LastName = "+student.getLastName());
			System.out.println(student.toString());
			
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}

	}

}
