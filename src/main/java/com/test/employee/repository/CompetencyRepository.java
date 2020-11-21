package com.test.employee.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.employee.entity.CompetencyEntity;
 
@Repository
public interface CompetencyRepository extends JpaRepository<CompetencyEntity, Long> {
 
	@Query(value = "SELECT salaryRange FROM CompetencyEntity e WHERE e.competencyName = :name")
	String findSalaryRange(@Param("name")String name);
}