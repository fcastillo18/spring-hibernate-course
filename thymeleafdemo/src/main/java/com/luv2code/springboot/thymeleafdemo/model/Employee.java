package com.luv2code.springboot.thymeleafdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String email;

	
	
}
