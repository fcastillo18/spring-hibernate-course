package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

//	private List<Employee> theEmployees;
	
//	@PostConstruct
//	private void loadDate() {
//		
//		Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@mail.com");
//		Employee emp2 = new Employee(1, "Emma", "Valdez", "emma@mail.com");
//		Employee emp3 = new Employee(1, "Manuel", "Smith", "manuel@mail.com");
//		
//		theEmployees = new ArrayList<>();
//		
//		theEmployees.add(emp1);
//		theEmployees.add(emp2);
//		theEmployees.add(emp3);
//	}
	
	private EmployeeService employeeService;
	
	//@Optional its optional, cuz we just have one EmpServ
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		List<Employee> theEmployees = employeeService.findAll();
		
		model.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
}
