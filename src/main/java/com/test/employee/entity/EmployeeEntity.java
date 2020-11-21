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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(exclude = {"competencies"})
@Entity
@Table(name="EMPLOYEE")
public class EmployeeEntity implements Serializable{
			
	private static final long serialVersionUID = 7507394203613029707L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID",nullable=false, unique=true)
	private Long id;
	
	@Column(name="EMPLOYEE_NAME",nullable=false, length=50)
	private String employeeName;
	
	@Column(name="TITLE",nullable=false, length=50)
	private String title;
	
	@Column(name="BUSINESS_UNIT",nullable=false, length=50)
	private String businessUnit;
	
	@Column(name="PLACE",nullable=false, length=50)
	private String place;
	
	@Column(name="SUPERVISOR_ID",nullable=false)
	private Long supervisorId;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(
	  name = "employee_competency", 
	  joinColumns = @JoinColumn(name = "employee_id", nullable = false, updatable = false), 
	  inverseJoinColumns = @JoinColumn(name = "competency_id", nullable = false, updatable = false))
    @JsonIgnoreProperties("employees")
	private Set<CompetencyEntity> competencies = new HashSet<>();
    
	@Column(name="SALARY",nullable=false)
	private Double salary;
	
}
