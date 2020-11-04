package com.springtest2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtest2.beans.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	public List<Employee>findByName(String name);
	
}
