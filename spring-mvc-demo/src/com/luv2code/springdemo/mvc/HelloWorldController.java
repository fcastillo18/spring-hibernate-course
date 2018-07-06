package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//controller method show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//controller method to read form data and add data to model
	@RequestMapping("/processFormTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//reading from HTML form
		String theName = request.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String result = "Yo! " + theName;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	//controller method to read form data and add data to model
		@RequestMapping("/processFormThree")
		public String processFormThree(@RequestParam("studentName") String theName, Model model) {
			
			theName = theName.toUpperCase();
			
			String result = "Hey my friend! " + theName;
			
			model.addAttribute("message", result);
			
			return "helloworld";
		}
	
}
