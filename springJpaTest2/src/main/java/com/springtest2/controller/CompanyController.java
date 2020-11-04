package com.springtest2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtest2.beans.Employee;
import com.springtest2.service.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping("add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		try {
			companyService.addEmployee(employee);
			return new ResponseEntity<>("employee id is: " + employee.getId(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("cant add employee", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("get-single/{id}")
	public ResponseEntity<?> getOneEmployee(@PathVariable(name = "id") Long employeeID) {
		return new ResponseEntity<Employee>(companyService.getOneEmployee(employeeID), HttpStatus.OK);

	}
	
	@GetMapping("get-all")
	public ResponseEntity<?> getAllEmployees() {
		return new ResponseEntity<>(companyService.getAllEmployees(), HttpStatus.OK);
	}
	
	
	@GetMapping("get-single1/{name}")
	public ResponseEntity<?>getEmployeeByName(@PathVariable(name = "name")String name) {
		return new ResponseEntity<>(companyService.getEmployeeByName(name), HttpStatus.OK);
	}
	

}
