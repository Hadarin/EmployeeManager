package com.hadrin.employeedemo;

import com.hadrin.employeedemo.controller.Controller;
import com.hadrin.employeedemo.dao.EmployeeRepository;
import com.hadrin.employeedemo.entity.Employee;
import com.hadrin.employeedemo.entity.Language;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private Controller controller;

	@Mock
	EmployeeRepository employeeRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void contextLoadsTest() throws Exception {
	}


	@Test
	public void controllerLoadsTest() throws Exception {

		assertThat(controller).isNotNull();
	}


	@Test
	public void loginPageTest() throws Exception {
		this.mvc.perform(get("/login")).andExpect(status().isOk());
	}


	@Test
	@WithMockUser(username = "borov@ua.fm", authorities = { "ADMIN" })
	public void employeeListTest() throws Exception {
		this.mvc.perform(get("/employees/list")).andExpect(status().isOk());
	}


	@Test
	@WithMockUser(username = "borov@ua.fm", authorities = { "ADMIN" })
	public void employeeFormTest() throws Exception {
		this.mvc.perform(get("/employees/showFormForAdd")).andExpect(status().isOk());
	}

	@Test
	public void getAllEmployeesTest()
	{
		List<Employee> list = new ArrayList<Employee>();
		Employee empOne = new Employee(1,"John", "John",1000L, new HashSet<Language>(Arrays.asList(new Language())));
		Employee empTwo = new Employee(2,"Alex", "kolenchiski", 2000L, new HashSet<Language>(Arrays.asList(new Language())));
		Employee empThree = new Employee(3,"Steve", "Waugh", 3000L, new HashSet<Language>(Arrays.asList(new Language())));

		list.add(empOne);
		list.add(empTwo);
		list.add(empThree);

		when(employeeRepository.findAllByOrderByLastNameAsc()).thenReturn(list);

		//test
		List<Employee> empList = employeeRepository.findAllByOrderByLastNameAsc();

		assertEquals(3, empList.size());
		verify(employeeRepository, times(1)).findAllByOrderByLastNameAsc();
	}



	@Test
	public void getEmployeeByIdTest()
	{

		when(employeeRepository.findById((long) 1)).thenReturn(Optional.of(new Employee(1, "Lokesh", "Gupta", 6000L,new HashSet<Language>(Arrays.asList(new Language())))));
	}



	@Test
	public void createEmployeeTest()
	{
		Employee emp = new Employee(1,"Lokesh","Gupta", 3000L, new HashSet<Language>(Arrays.asList(new Language())));

		when(employeeRepository.save(emp)).thenReturn(emp);
	}


}