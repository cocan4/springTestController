package com.springtest2.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtest2.beans.Employee;
import com.springtest2.beans.Job;
import com.springtest2.repo.EmployeeRepo;
import com.springtest2.repo.JobRepo;

@Service
public class CompanyService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private JobRepo jobRepo;

	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);

	}
	
	public void updateEmployee(Employee employee) {
		employeeRepo.saveAndFlush(employee);

	}
	
	public void delete(Employee employee) {
		employeeRepo.delete(employee);

	}
	
	public void deleteByID(long employeeID) {
		employeeRepo.deleteById(employeeID);

	}

	public Employee getOneEmployee(Long employeeID) {
		return employeeRepo.getOne(employeeID);
	}

	public List<Employee> getEmployeeByName(String name) {
		return employeeRepo.findByName(name);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public List<Job> getAllJobs() {
		return jobRepo.findAll();
	}

	public List<Job> getJobsByEndDate(Date endDate) {
		return jobRepo.findByEndDate(endDate);
	}

	public List<Job> getJobsBetweenDates(Date startDate, Date endDate) {
		return jobRepo.findByEndDateBetween(startDate, endDate);

	}

}
