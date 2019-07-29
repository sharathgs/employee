package com.hcl.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.dto.ResponseDto;
import com.hcl.employee.exception.EmployeeException;
import com.hcl.employee.model.Employee;
import com.hcl.employee.repository.EmployeeRepository;



@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	//to get list for all employees
	public List<Employee> getEmployees()
	{
		List<Employee> employeeData = new ArrayList<Employee>();
		employeeData = employeeRepository.findAll();
		return employeeData;
	}
	
	//to add the employee object into database
	public ResponseDto addEmployee(Employee employee) throws EmployeeException
	{
		if(employeeRepository.save(employee) != null)
			return new ResponseDto("Employee added successfully");
		else
			throw new EmployeeException("Employee Not added successfully");
	}
	
	//to update the employee object into database
	public ResponseDto updateEmployee(int id, String employeeName, 
			String employeeAddress, Long Phoneno) throws EmployeeException
	{
		
		Optional<Employee> employeeId = employeeRepository.findById(id);
		
		if(employeeId.isPresent())
		{
			employeeId.get().setEmployeeaddress(employeeAddress);
			employeeId.get().setEmployeename(employeeName);
			employeeId.get().setPhoneno(Phoneno);
			employeeRepository.save(employeeId.get());
			return new ResponseDto("Employee updated successfully");			
		}else
		{
			throw new EmployeeException("Employee Not updated successfully");
		}
	}

}
