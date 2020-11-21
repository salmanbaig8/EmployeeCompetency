package com.test.employee.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.test.employee.entity.EmployeeEntity;
import com.test.employee.repository.EmployeeRepository;

public class EmployeeServiceImplTest {
	
	EmployeeServiceImpl employeeService;
	
	@Mock
	EmployeeRepository employeeRepo;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        employeeService = new EmployeeServiceImpl(employeeRepo);
    }
	
	@Test
	public void testGetAllEmployees() {
		
		int pageNumber = 0;
        int pageSize = 1;
        String place = "Bangalore";
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        EmployeeEntity employee = new EmployeeEntity();
        Page<EmployeeEntity> employeePage = new PageImpl<>(Collections.singletonList(employee));
        when(employeeRepo.findByPlacePageable(place,pageable)).thenReturn(employeePage);
        Page<EmployeeEntity> employeeRepoPage = employeeRepo.findByPlacePageable(place,pageable);
        assertEquals(employeeRepoPage.getNumberOfElements(), 1);
	
	}

}
