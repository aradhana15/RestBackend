package com.niit.skills.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skills.dao.EmployeeDao;
import com.niit.skills.model.Employee;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	
	@Autowired
	EmployeeDao empdao;
	
	@GetMapping("/allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> data = empdao.allEmployees();
		if(data !=null)
		{
			return new ResponseEntity<List<Employee>>(data,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
	}
	@RequestMapping(value="/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id)
	{
		Employee ob = empdao.getEmployeeById(id);
		return new ResponseEntity<Employee>(ob,HttpStatus.OK);
	}
	
	@RequestMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)
	{
		empdao.create(emp);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
}
