package com.example.demo.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class EmployeePojo {
	
	@Id
	private String emailId;
	
	@Column(nullable=false,unique=false)
	private String empName;
	private int salary;
	private int empId;
	
	public EmployeePojo() {
	}

	public EmployeePojo(String emailId, int empId, String empName, int salary) {
		super();
		this.emailId = emailId;
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "EmployeePojo [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", emailId=" + emailId
				+ "]";
	}
	
	
	
	}
	
	
	


