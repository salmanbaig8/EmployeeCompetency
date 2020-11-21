package com.test.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.employee.service.CompetencyService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@Api(description = "This is Competency Controller")
@RestController
@RequestMapping("competency")
@RequiredArgsConstructor
public class CompetencyController {

    private final CompetencyService competencyService;
 
    @GetMapping(path = "/salaries", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> rangeOfSalaries(@RequestParam String competencyName) {
    	
    	String rangeOfSalaries = competencyService.rangeOfSalaries(competencyName);
    	
    	if(StringUtils.isEmpty(rangeOfSalaries)){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Competency Name");
    	}
    	return ResponseEntity.status(HttpStatus.OK).body(rangeOfSalaries);
    } 
}
