package com.rohan.searchapi.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.rohan.searchapi.entity.Employee;

public interface EmpService {

	Employee save(Employee Employee);

	List<Employee> searchEmployees(Double salary, String designation, Long id, String name);

	List<Employee> searchEmployeesByField(String field);

	Page<Employee> allEmployeeWithPagination(int offset, int pageSize);

	Page<Employee> allEmployeeWithPagination(int offset, int pageSize, String field);
}
