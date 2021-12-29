package com.rest.service;

import java.util.List;

import com.rest.model.Employee;

public interface IEmployeeService {
	public Employee saveEmployee(Employee e);
	public Employee updateEmployee(Integer empId, Employee e);
	public void deleteEmployee(Integer id);
	
	public Employee getOneEmployee(Integer id);
	public List<Employee> getAllEmployees();
	

}
