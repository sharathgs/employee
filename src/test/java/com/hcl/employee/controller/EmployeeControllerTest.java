package com.hcl.employee.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.employee.dto.ResponseDto;
import com.hcl.employee.model.Employee;
import com.hcl.employee.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class EmployeeControllerTest {
	
	
	private MockMvc mockMvc;
	
	@Mock
	EmployeeService employeeService;
	
	@InjectMocks
	EmployeeController employeeController;
	
	
	Employee employee;

	@Before
	public void setup() {
        employee = new Employee(1,"Sharath","Dasarahalli","Training",1234567890L, 24, "Single");
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}
	
	//controller test for insertion
	@Test
	public void addEmployeeTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.post("/employee/insertion").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString("Employee added successfully")));
	}
	
	
	//controller test for getting or fetching data
	@Test
	public void getEmployeeTest() throws Exception
	{
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		employeeList.add(employee);
		mockMvc.perform(MockMvcRequestBuilders.get("/employee/getEmployee").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(employeeList)));
	}

	
	//controller test for updating employee details
	@Test
	public void updateEmployeeTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.post("/employee/updateEmployee?id=1&employeeName=Sharath&employeeaddress=Dasarahalli&phoneno=1234567890").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString("Employee updated successfully")));
	}
	
	//controller test for insertion negative
		@Test
		public void addEmployeeTestNegative() throws Exception
		{
			mockMvc.perform(MockMvcRequestBuilders.post("/employee/insertion").contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.ALL).content(asJsonString("Employee added successfully")));
		}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
