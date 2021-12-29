package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.model.Employee;

public interface EmployeeRepository 
			extends JpaRepository<Employee, Integer> {
	

}
