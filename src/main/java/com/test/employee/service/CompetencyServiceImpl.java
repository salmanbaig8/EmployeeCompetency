package com.test.employee.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.test.employee.exception.CompetencyServiceException;
import com.test.employee.model.ExceptionType;
import com.test.employee.repository.CompetencyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompetencyServiceImpl implements CompetencyService{
	
	private final CompetencyRepository competencyRepository;

	public String rangeOfSalaries(String competencyName){
		String rangeOfSalaries = null;
		if(StringUtils.isBlank(competencyName)){
			throw new CompetencyServiceException(ExceptionType.TECHNICAL_EXCEPTION, "Please provide competency name");
		}
		
		rangeOfSalaries = competencyRepository.findSalaryRange(competencyName);
		
		if(StringUtils.isBlank(rangeOfSalaries)){
			throw new CompetencyServiceException(ExceptionType.BUSINESS_EXCEPTION, "Competency Doesn't exist/ Invalid Competency");
		}
		return rangeOfSalaries;
	}
}
