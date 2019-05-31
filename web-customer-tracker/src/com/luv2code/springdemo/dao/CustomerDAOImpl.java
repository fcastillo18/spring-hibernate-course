package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current session
		Session session = sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> theQuery = 
				session.createQuery("from Customer order by lastName", 
									 Customer.class);
		
		//execute query and get customers
		List<Customer> customers = theQuery.getResultList();
		
		//return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		//get the current session
		Session session = sessionFactory.getCurrentSession();
		
		//save/update the customer
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		//get the current session
		Session session = sessionFactory.getCurrentSession();
			
		//retrieve/read from database using the PK
		Customer customer = session.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		//getting the customer object
		Customer customer = session.get(Customer.class, theId);
		
		//deleting the customer
		session.delete(customer);
		
	}
	
	

}