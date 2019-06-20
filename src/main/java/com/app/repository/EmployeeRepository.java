package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByEmpId(Integer id);
	List<Employee> findByEmpSal(Double empsal);
	List<Employee> findByEmpNameLike(String name);
	List<Employee> findByEmpNameIsNotNullOrderByEmpSal();
	List<Employee> findByEmpIdOrEmpSalGreaterThan(Integer id,Double sal);
	
}
