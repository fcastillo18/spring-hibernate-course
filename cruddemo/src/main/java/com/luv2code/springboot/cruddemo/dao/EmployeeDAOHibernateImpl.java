package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//define field for entitymanager
	private EntityManager entityManager;
	
	//setup constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		// get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> query =
				session.createQuery("from Employee", Employee.class);
		
		//execute query and get result
		List<Employee> employees = query.getResultList();
		
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		// get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//get Employee
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		// get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteById(int id) {
		// get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, id);
		
		session.delete(employee);
		
	}

}
