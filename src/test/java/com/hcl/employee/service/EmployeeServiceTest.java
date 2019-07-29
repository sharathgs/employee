package com.hcl.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.employee.dto.ResponseDto;
import com.hcl.employee.exception.EmployeeException;
import com.hcl.employee.model.Employee;
import com.hcl.employee.repository.EmployeeRepository;



@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	EmployeeService employeeService;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	public Employee getEmployee()
	{
		Employee employee = new Employee();
		employee.setAge(24);
		employee.setEmployeeaddress("Dasarahalli");
		employee.setEmployeedepartment("Training");
		employee.setEmployeeid(1);
		employee.setEmployeename("Sharath");
		employee.setMartialstatus("Single");
		employee.setPhoneno(1234567890L);
		return employee;
	}
	
	//test case for adding Employees
	@Test
	public void insertEmployeeTest()
	{
		Employee employeeDetails = getEmployee();
		Mockito.when(employeeRepository.save(employeeDetails)).thenReturn(employeeDetails);
		ResponseDto actualMessage = employeeService.addEmployee(employeeDetails);
		Assert.assertEquals("Employee added successfully", actualMessage.getMessage());
	}
	
	
	//test case for getEmployees
	@Test
	public void getEmployeeTest()
	{
		Employee employeeDetails = getEmployee();
		List<Employee> testData = new ArrayList<Employee>();
		testData.add(getEmployee());
		testData.add(getEmployee());
		Mockito.when(employeeRepository.findAll()).thenReturn(testData);
		List actualData = employeeService.getEmployees();
		Assert.assertEquals(testData, actualData);
	}
	
	//test case for update
	@Test
	public void updateEmployeeTest()
	{
		Employee employeeDetails = getEmployee();
		Mockito.when(employeeRepository.findById(employeeDetails.getEmployeeid())).thenReturn(Optional.of(employeeDetails));
		Mockito.when(employeeRepository.save(employeeDetails)).thenReturn(employeeDetails);
		ResponseDto actualMessage = employeeService.updateEmployee(employeeDetails.getEmployeeid(), employeeDetails.getEmployeename(), employeeDetails.getEmployeeaddress(), employeeDetails.getPhoneno());
		Assert.assertEquals("Employee updated successfully", actualMessage.getMessage());
	}
	
	
	//test case for update negative id
		@Test(expected=EmployeeException.class)
		public void updateEmployeeTestNegative()
		{
			Employee employeeDetails = getEmployee();
			Mockito.when(employeeRepository.findById(23)).thenThrow(new EmployeeException("Employee Not updated successfully"));
			employeeService.updateEmployee(23, employeeDetails.getEmployeename(), employeeDetails.getEmployeeaddress(), employeeDetails.getPhoneno());
		}
		
		
		//test case for adding employee negative
				@Test(expected=EmployeeException.class)
				public void addedEmployeeTestNegative()
				{
					Employee employeeDetails = new Employee();
					Mockito.when(employeeRepository.save(employeeDetails)).thenThrow(new EmployeeException("Employee Not added successfully"));
					employeeService.addEmployee(employeeDetails);
				}

}
