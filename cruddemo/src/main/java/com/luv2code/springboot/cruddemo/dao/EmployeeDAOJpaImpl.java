package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	//define field for entitymanager
	private EntityManager entityManager;
	
	//setup constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		//create a query
		Query query =
				entityManager.createQuery("from Employee", Employee.class);
		
		//execute query and get result
		List<Employee> employees = query.getResultList();
		
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		//get Employee
		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		// save or update
		Employee dbEmployee = entityManager.merge(employee);
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
		// get current hibernate session

		Employee employee = entityManager.find(Employee.class, id);
		
		entityManager.remove(employee);
		
	}

}
