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
		
		Query<Customer> query = session.createQuery("select c from Customer c order by firstName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class,id);
		return customer;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id=:customerId");
				query.setParameter("customerId", id);
		
		query.executeUpdate();
	}
}
