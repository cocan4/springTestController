package com.springtest2.CompanyTesting;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springtest2.beans.Employee;
import com.springtest2.beans.Job;
import com.springtest2.repo.EmployeeRepo;
import com.springtest2.repo.JobRepo;
import com.springtest2.service.CompanyService;
import com.springtest2.util.printTable;

@Component
@Order(1)
public class CompanyServiceClr implements CommandLineRunner {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private JobRepo JobRepo;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public void run(String... args) throws Exception {

		System.out.println(
				"   ____ ___  __  __ ____   _    _   ___   __  ____  _____ ______     _____ ____ _____    ____ _     ____  \r\n"
						+ "  / ___/ _ \\|  \\/  |  _ \\ / \\  | \\ | \\ \\ / / / ___|| ____|  _ \\ \\   / /_ _/ ___| ____|  / ___| |   |  _ \\ \r\n"
						+ " | |  | | | | |\\/| | |_) / _ \\ |  \\| |\\ V /  \\___ \\|  _| | |_) \\ \\ / / | | |   |  _|   | |   | |   | |_) |\r\n"
						+ " | |__| |_| | |  | |  __/ ___ \\| |\\  | | |    ___) | |___|  _ < \\ V /  | | |___| |___  | |___| |___|  _ < \r\n"
						+ "  \\____\\___/|_|  |_|_| /_/   \\_\\_| \\_| |_|   |____/|_____|_| \\_\\ \\_/  |___\\____|_____|  \\____|_____|_| \\_\\\r\n"
						+ "                                                                                                          ");

		System.out.println("~~~~~~~~~~~~~~~~~~~~add employee~~~~~~~~~~~~~~~~~~~~~~");
		Job j1 = new Job("private security", Date.valueOf("2010-11-28"));
		Job j2 = new Job("private security", Date.valueOf("2010-11-28"));

		JobRepo.save(j1);
		JobRepo.save(j2);

		Employee e1 = new Employee("jack bauer", 10000);
		Employee e2 = new Employee("jack richer", 9000);

		companyService.addEmployee(e1);
		companyService.addEmployee(e2);

		e1.addJob(j1);
		e2.addJob(j2);

		employeeRepo.saveAndFlush(e1);
		employeeRepo.saveAndFlush(e2);

		printTable.print(companyService.getAllEmployees());

		System.out.println("~~~~~~~~~~~~~~~~~~~~get one employee~~~~~~~~~~~~~~~~~~~~~~");
		printTable.print(companyService.getOneEmployee((long) 1));
		System.out.println("~~~~~~~~~~~~~~~~~~~~get employee by name~~~~~~~~~~~~~~~~~~~~~~");
		printTable.print(companyService.getEmployeeByName("jack richer"));
		System.out.println("~~~~~~~~~~~~~~~~~~~~get all employees~~~~~~~~~~~~~~~~~~~~~~");
		printTable.print(companyService.getAllEmployees());
		System.out.println("~~~~~~~~~~~~~~~~~~~~get jobs by end-date~~~~~~~~~~~~~~~~~~~~~~");
		printTable.print(companyService.getJobsByEndDate(Date.valueOf("2010-11-28")));
		System.out.println("~~~~~~~~~~~~~~~~~~~~get jobes between dates~~~~~~~~~~~~~~~~~~~~~~");
		printTable.print(companyService.getJobsBetweenDates((Date.valueOf("2010-11-20")), (Date.valueOf("2010-11-30"))));

	}

}
