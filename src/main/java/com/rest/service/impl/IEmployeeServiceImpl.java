package com.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rest.exception.ResourceNotFoundException;
import com.rest.model.Employee;
import com.rest.repo.EmployeeRepository;
import com.rest.service.IEmployeeService;

@Service
public class IEmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee saveEmployee(Employee e) {
		return repo.save(e);
	}

	@Override
	@CachePut(value = "employees", key = "#empId")
	public Employee updateEmployee(Integer empId, Employee e) {
		Employee emp = repo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee Does Not Exist"));
		emp.setEmpName(e.getEmpName());
		emp.setEmpSal(e.getEmpSal());
		return repo.save(e);
	}

	@Override
	@Cacheable(value = "employees", key = "#id")
	public Employee getOneEmployee(Integer id) {
		Employee emp = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Does Not Exist"));
		return emp;
	}

	@Override
	@CacheEvict(value = "employees", allEntries = true)
	public void deleteEmployee(Integer id) {
		Employee emp = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Does Not Exist"));
		repo.deleteById(emp.getId());
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

}
