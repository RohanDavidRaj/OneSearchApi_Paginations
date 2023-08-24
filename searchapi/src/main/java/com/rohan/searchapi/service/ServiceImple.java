package com.rohan.searchapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rohan.searchapi.dao.employeeDao;
import com.rohan.searchapi.entity.Employee;

@Service
public class ServiceImple implements EmpService {

	@Autowired
	employeeDao dao;

	@Override
	public Employee save(Employee employee) {
		return dao.save(employee);
	}

	
	public List<Employee> searchEmployees(Double salary, String designation, Long id, String name) {
        Double filteredSalary = salary != null ? salary : Double.MIN_VALUE;
	return dao.findByNameOrDesignationOrSalary(name, designation, filteredSalary);
	}

	@Override
	public List<Employee> searchEmployeesByField(String field) {
		return dao.findAll(Sort.by(Direction.ASC,field));
	}
	
	//Using Pagination
	@Override
	public Page<Employee> allEmployeeWithPagination(int offset,int pageSize) {
		return  dao.findAll(PageRequest.of(offset, pageSize));
	}
	
	//Sorted Pagination
	@Override
	public Page<Employee> allEmployeeWithPagination(int offset,int pageSize,String field) {
		return  dao.findAll(PageRequest.of(offset, pageSize).withSort(Direction.ASC, field));
	}
	
	

}
