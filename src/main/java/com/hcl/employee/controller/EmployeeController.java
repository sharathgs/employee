package com.hcl.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employee.dto.ResponseDto;
import com.hcl.employee.model.Employee;
import com.hcl.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	//controller for adding employee
	@PostMapping(value = "/insertion")
	public ResponseDto addemployee(Employee employee)
	{
		return employeeService.addEmployee(employee);		
	}
	
	//controller for getting or fetching employees
	@GetMapping(value = "/getEmployee")
	public List getEmployee()
	{
		return (List) employeeService.getEmployees();
	}
	
	//contoller for updating employee
	@PostMapping(value = "/updateEmployee")
	public ResponseDto updateEmployee(@RequestParam int id, @RequestParam String employeeName,
			@RequestParam String employeeaddress, @RequestParam Long phoneno)
	{
		return employeeService.updateEmployee(id, employeeName, employeeaddress, phoneno);
	}

}
