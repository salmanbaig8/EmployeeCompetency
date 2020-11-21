package com.test.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.test.employee.entity.EmployeeEntity;
import com.test.employee.exception.EmployeeServiceException;
import com.test.employee.model.ExceptionType;
import com.test.employee.repository.EmployeeRepository;
import com.test.employee.utils.EmployeeUtil;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService 
{
	private final EmployeeRepository employeeRepository;
	
    public List<EmployeeEntity> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy, String place)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<EmployeeEntity> pagedResult = employeeRepository.findByPlacePageable(place, paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }

	public List<EmployeeEntity> updateSalary(String place, Integer percentage) {
		 List<EmployeeEntity> employees = employeeRepository.findByPlace(place);
		
		if(CollectionUtils.isEmpty(employees)) {
		
			throw new EmployeeServiceException(ExceptionType.TECHNICAL_EXCEPTION, "No Employees Found for the place: " + place);
		}
		if(percentage <= 55){
			employees.stream()
			.forEach(emp -> EmployeeUtil.calculateSalary(emp, percentage));
		}
		else {
			throw new EmployeeServiceException(ExceptionType.BUSINESS_EXCEPTION, "% Hike is greater than 55");
		}
		return employeeRepository.saveAll(employees);
	}

}