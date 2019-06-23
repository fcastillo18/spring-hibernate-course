package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> listStudent;
	
	//define @PostContruct to load the student data...only once
	@PostConstruct
	public void loadData() {
		listStudent = new ArrayList<Student>();
		
		listStudent.add(new Student("Franklin", "Castillo"));
		listStudent.add(new Student("Andy", "Ramos"));
		listStudent.add(new Student("Mary", "Patel"));
	}
	
	
	//define endpoint for /students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return listStudent;
	}
	
	//define endpoint for /students/{studentId} return student by index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){ //this param name has to be the same as the one define in get mapping
		
		if (studentId >= listStudent.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - "+studentId);
		}
		
		return listStudent.get(studentId);
	}
	
}
