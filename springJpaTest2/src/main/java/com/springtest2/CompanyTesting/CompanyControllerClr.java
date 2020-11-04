package com.springtest2.CompanyTesting;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.springtest2.beans.Employee;
import com.springtest2.service.CompanyService;

@Component()
@Order(2)
public class CompanyControllerClr implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CompanyService companyService;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("   ____            _             _ _             _____         _   _             \r\n"
				+ "  / ___|___  _ __ | |_ _ __ ___ | | | ___ _ __  |_   _|__  ___| |_(_)_ __   __ _ \r\n"
				+ " | |   / _ \\| '_ \\| __| '__/ _ \\| | |/ _ \\ '__|   | |/ _ \\/ __| __| | '_ \\ / _` |\r\n"
				+ " | |__| (_) | | | | |_| | | (_) | | |  __/ |      | |  __/\\__ \\ |_| | | | | (_| |\r\n"
				+ "  \\____\\___/|_| |_|\\__|_|  \\___/|_|_|\\___|_|      |_|\\___||___/\\__|_|_| |_|\\__, |\r\n"
				+ "                                                                           |___/ ");

		System.out.println("~~~~~~~~~~~~~~~~~~~~add employee~~~~~~~~~~~~~~~~~~~~~~");

		Employee e1 = new Employee("jack batista", 10000);
		Employee e2 = new Employee("Queen Gambit", 10000);
		System.out.println(restTemplate.postForEntity("http://localhost:8080/company/add", e1, String.class));
		System.out.println(restTemplate.postForEntity("http://localhost:8080/company/add", e2, String.class));

		System.out.println("~~~~~~~~~~~~~ Get-One-Employee ~~~~~~~~~~~~~");
		companyService.getOneEmployee((long) 1);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		System.out.println(
				restTemplate.getForEntity("http://localhost:8080/company/get-single/{id}", String.class, params));

		System.out.println("~~~~~~~~~~~~~ Get-All-Employees ~~~~~~~~~~~~~");
		ResponseEntity<String> res1 = restTemplate.getForEntity("http://localhost:8080/company/get-all", String.class);
		System.out.println(res1);
		
		System.out.println("~~~~~~~~~~~~~ Get-Employees-By-Name ~~~~~~~~~~~~~");
		params.put("name", "jack bauer");
		System.out.println(restTemplate.getForObject("http://localhost:8080/company/get-single1/{name}", String.class, params));

	}

}
