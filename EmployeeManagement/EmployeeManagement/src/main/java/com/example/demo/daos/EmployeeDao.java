package com.example.demo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.pojos.EmployeePojo;


public interface EmployeeDao extends JpaRepository<EmployeePojo, String>{
	
	
	
	@Query(value="select e.emailId from EmployeePojo e")
	public List<String> getAllEmailIds();
	
	@Query(value="select e.salary from EmployeePojo e")
	public List<Integer> getSalary();
	
	

}
