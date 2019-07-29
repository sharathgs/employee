package com.hcl.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeedetails")
public class Employee {
	
	@Id
	@GeneratedValue
	private int employeeid;
	private String employeename;
	private String employeeaddress;
	private String employeedepartment;
	private Long phoneno;
	private int age;
	private String martialstatus;
	
	
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmployeeaddress() {
		return employeeaddress;
	}
	public void setEmployeeaddress(String employeeaddress) {
		this.employeeaddress = employeeaddress;
	}
	public String getEmployeedepartment() {
		return employeedepartment;
	}
	public void setEmployeedepartment(String employeedepartment) {
		this.employeedepartment = employeedepartment;
	}
	public Long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMartialstatus() {
		return martialstatus;
	}
	public void setMartialstatus(String martialstatus) {
		this.martialstatus = martialstatus;
	}
	public Employee(int employeeid, String employeename, String employeeaddress, String employeedepartment,
			Long phoneno, int age, String martialstatus) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.employeeaddress = employeeaddress;
		this.employeedepartment = employeedepartment;
		this.phoneno = phoneno;
		this.age = age;
		this.martialstatus = martialstatus;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
