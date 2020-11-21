package com.test.employee.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(exclude = {"employees"})
@Entity
@Table(name="COMPETENCY")
public class CompetencyEntity implements Serializable{

	private static final long serialVersionUID = -5266840212880546730L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COMPETENCY_ID",nullable=false, unique=true)
	private Long id;
	
	@Column(name="COMPETENCY_NAME",nullable=false)
	private String competencyName;
	
	@ManyToMany(mappedBy = "competencies", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonIgnoreProperties("competencies")
	private Set<EmployeeEntity> employees = new HashSet<>();
	
	@Column(name="SALARY_RANGE",nullable=false)
	private String salaryRange;
}
