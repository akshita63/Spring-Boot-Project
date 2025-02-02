package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.daos.EmployeeDao;
import com.example.demo.pojos.EmployeePojo;







@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDao dao;
	
	@GetMapping(value="/com/api/emp")
	public String hello() {
		return "working";
	}
	
	
	@GetMapping(value="/com/api/emp/get/{emailId}",produces={"application/json","application/xml"})
	public EmployeePojo getEmployeePojo(@PathVariable String emailId) {
	
		Optional<EmployeePojo> optional=dao.findById(emailId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
		{
			return null;
		}
		
	}	
	
	@DeleteMapping(value="/com/api/emp/delete/{emailId}")
	public String deleteUser(@PathVariable String emailId)
	{
		Optional<EmployeePojo> optional = dao.findById(emailId);
		
		if(optional.isPresent())
		{
			dao.deleteById(emailId);		
			return "{status:200,message:'Deleted successfully'}";
		}
		else
		{
			return "{status:200,message:'Email doesn't exist'}";
		}
	}
	
	@PostMapping(value="/com/api/emp/add")
	public String addUser(@RequestBody EmployeePojo emp)
	{
		System.out.println(emp);
		emp =  dao.save(emp);		
		return "{status:200,message:'Added successfully'}";
	}
	
	@GetMapping(value="/com/api/emp/getEmailIds")
	public List<String> getAllEmailIds()
	{
		return  dao.getAllEmailIds();
	
	}
	
	@GetMapping(value="/com/api/emp/getSalary")
	public List<Integer> getSalary()
	{
		return  dao.getSalary();
	}
	
	
}
	
		
	
	
	
	
	
	
	
	
	
	


