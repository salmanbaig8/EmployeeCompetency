package com.test.employee.utils;

import com.test.employee.entity.EmployeeEntity;

public class EmployeeUtil {

	private EmployeeUtil() {
	}
	
	public static void calculateSalary(EmployeeEntity emp, Integer percentage) {
		Double currentSalary = emp.getSalary();
		Double hike = currentSalary *((double)percentage / 100) ;
		Double newSalary = currentSalary + hike ;
		emp.setSalary(newSalary);
	}
}
