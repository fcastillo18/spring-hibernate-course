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
		
		//save the customer
		session.save(theCustomer);
		
	}

}