package com.rohan.searchapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.searchapi.entity.Employee;
import com.rohan.searchapi.service.EmpService;

@RestController
@RequestMapping("/employee")
public class Controller {
	
	@Autowired
	EmpService service;
	
	@PostMapping()
	public ResponseEntity<Employee> save(@RequestBody Employee employee){
		return ResponseEntity.ok(service.save(employee));
		
	}
	
	 @GetMapping()
	    public List<Employee> searchEmployees(
	            @RequestParam(required = false) Double salary,
	            @RequestParam(required = false) String designation,
	            @RequestParam(required = false) Long id,
	            @RequestParam(required = false) String name) {
	        return service.searchEmployees(salary, designation, id, name);
	    }
	 
	 @GetMapping("/{field}")
	    public List<Employee> search(@PathVariable String field) {
	        return service.searchEmployeesByField(field);
	    }
	 
	 @GetMapping("/page/{offset}/{pageSize}")
	 public Page<Employee> search(
	         @PathVariable int offset,
	         @PathVariable int pageSize,
	         @RequestParam(required = false) String field) {
	     if (field == null) {
	         return service.allEmployeeWithPagination(offset, pageSize);
	     } else {
	         return service.allEmployeeWithPagination(offset, pageSize, field);
	     }
	 }


}
