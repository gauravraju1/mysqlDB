package com.app.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;

//@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
        System.out.println("");
		System.out.println("----Sort----");
		repo.findAll(Sort.by(Direction.DESC, "empId")).forEach(System.out::println);
		System.out.println("----Example====");
		repo.findAll(Example.of(new Employee("b",55.5))).forEach(System.out::println);
		System.out.println("----Example with Sort");
		repo.findAll(Example.of(new Employee("b",55.5)),Sort.by(Direction.DESC, "empId")).forEach(System.out::println);
		System.out.println("----Pagination----");
		repo.findAll(PageRequest.of(1, 3)).forEach(System.out::println);
		System.out.println("----Pagination with Example----");
		repo.findAll(Example.of(new Employee("b",55.5)),PageRequest.of(1, 3)).forEach(System.out::println);
		
		System.out.println("----------- find by ids-------------");
		repo.findAllById(Arrays.asList(6,7,10)).forEach(System.out::println);
		
		System.exit(0);
	}

}
