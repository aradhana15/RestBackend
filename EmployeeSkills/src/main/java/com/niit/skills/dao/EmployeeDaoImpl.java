package com.niit.skills.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.skills.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void create(Employee ob) {
		Session sess = sessionFactory.openSession();
		sess.beginTransaction();
		sess.save(ob);
		sess.flush();
		sess.getTransaction().commit();
	}

	@Override
	public Employee getEmployeeById(int id) {
		try
		{
		Session sess= sessionFactory.getCurrentSession();
		Employee ob = sess.get(Employee.class, id);
		return  ob; 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Employee> allEmployees() {
		try {
			Session sess = sessionFactory.getCurrentSession();
			List<Employee> empData = sess.createQuery("from Employee").list();
			return empData;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteEmployee(int id) {
		Session sess= sessionFactory.getCurrentSession();
		Employee ob = sess.load(Employee.class, id);
		sess.delete(ob);
		
	}
}
