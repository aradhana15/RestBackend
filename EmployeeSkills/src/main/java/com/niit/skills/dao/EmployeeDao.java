package com.niit.skills.dao;

import java.util.List;

import com.niit.skills.model.Employee;

public interface EmployeeDao {
	
	public void create(Employee ob);
	public Employee getEmployeeById(int id);
	public List<Employee> allEmployees();
	public void deleteEmployee(int id);
	

}
