package com.test.employee.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.employee.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
 
	@Query(value = "SELECT e FROM EmployeeEntity e WHERE e.place = :place")
	Page<EmployeeEntity> findByPlacePageable(@Param("place")String place, Pageable pageable);
	
	@Query(value = "SELECT e FROM EmployeeEntity e WHERE e.place = :place")
	List<EmployeeEntity> findByPlace(@Param("place")String place);
}