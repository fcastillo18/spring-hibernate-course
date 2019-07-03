package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	//@Transactional JPA provides it out of the box
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	//@Transactional
	public Employee findById(int id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		
		if (result.isPresent()) {
			employee = result.get();
		} else {
			//we didnt find the employee
			throw new RuntimeException("Couldnt find the employee id - "+id);
		}
		
		return employee;
	}

	@Override
	//@Transactional
	public void save(Employee employee) {
		
		employeeRepository.save(employee);

	}

	@Override
	//@Transactional
	public void deleteById(int id) {
		
		employeeRepository.deleteById(id);

	}

}
