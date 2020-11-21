package com.test.employee.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EmployeeEntityTest {

	EmployeeEntity employee;

	@Before
	public void setUp() {
		employee = new EmployeeEntity();
	}

	@Test
	public void testGetId() {
		Long idValue = 4L;

		employee.setId(idValue);

		assertEquals(idValue, employee.getId());

	}

	@Test
	public void testGetEmployeeName() {
		String value = "John";
		employee.setEmployeeName(value);
		assertEquals(value, employee.getEmployeeName());
	}


}
