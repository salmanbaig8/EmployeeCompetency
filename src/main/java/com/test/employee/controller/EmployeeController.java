package com.test.employee.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.employee.entity.EmployeeEntity;
import com.test.employee.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(description = "This is Employee Controller")
@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
 
    @ApiOperation(value = "This will get a list of employee details based on the location.", 
    		notes = "Default pageNo = 0, need to pass different pageNo for getting details of next set of employees"
    				+ "Default pageSize = 5, you can pass different value to get more no of employees details in single page"
    				+ "Employees are sorted by their ID default"
    				+ "Need to pass proper location to get the details"
    				)
    @GetMapping(path = "/employees", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(
    		@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam String place) 
    {
        List<EmployeeEntity> list = employeeService.getAllEmployees(pageNo, pageSize, sortBy, place);
 
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
    
    @ApiOperation(value = "This will get a list of customers.", notes = "These are some notes about the API.")
    @PutMapping(path="/place/{place}/salary/{percentage}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeEntity>> updateSalary(
			@PathVariable String place, @PathVariable Integer percentage) {

    	List<EmployeeEntity> employees = employeeService.updateSalary(place, percentage);
		
   		return ResponseEntity.status(HttpStatus.ACCEPTED).body(employees);

	}

}
