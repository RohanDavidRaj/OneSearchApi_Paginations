package com.rohan.searchapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohan.searchapi.entity.Employee;

public interface employeeDao extends JpaRepository<Employee, Long> {
	
	public List<Employee> findByNameOrDesignationOrSalary(String name,String design,double sala);
}
