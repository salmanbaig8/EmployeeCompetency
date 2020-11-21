package com.test.employee.service;

import java.util.List;

import com.test.employee.entity.EmployeeEntity;

public interface EmployeeService {

	List<EmployeeEntity> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy, String place);
	List<EmployeeEntity> updateSalary(String place, Integer percentage);
}
