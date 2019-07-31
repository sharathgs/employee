package com.hcl.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity addemployee(Employee employee)
	{
		ResponseDto responseDto = employeeService.addEmployee(employee);
		return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.CREATED);		
	}
	
	//controller for getting or fetching employees
	@GetMapping(value = "/getEmployee")
	public ResponseEntity<List> getEmployee()
	{
		List employeeData =  (List) employeeService.getEmployees();
		return  new ResponseEntity<List>(employeeData,HttpStatus.OK);
	}
	
	//contoller for updating employee
	@PostMapping(value = "/updateEmployee")
	public ResponseEntity<ResponseDto> updateEmployee(@RequestParam int id, @RequestParam String employeeName,
			@RequestParam String employeeaddress, @RequestParam Long phoneno)
	{
		ResponseDto responseDto = employeeService.updateEmployee(id, employeeName, employeeaddress, phoneno);
		return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.CONTINUE);
	}

}
