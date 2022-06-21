package com.luv2code.springdemo.dao;

import java.util.List;

//import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
//	@Transactional
	public List<Customer> getCustomers(){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("select c from Customer c", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}
}
