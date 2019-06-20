package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.repository.EmployeeRepository;

@Component
public class FindByRunnerClass implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.findByEmpIdOrEmpSalGreaterThan(2,56.4).forEach(System.out::println);
		System.out.println(" ok Done");
	}

}
