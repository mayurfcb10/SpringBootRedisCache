package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Employee;
import com.rest.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService service;

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/one/{id}")
	public Employee getOneEmployee(@PathVariable Integer id) {
		return service.getOneEmployee(id);
	}

	@PutMapping("/modify/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee e) {
		return service.updateEmployee(id, e);
	}

	@DeleteMapping("/remove/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		service.deleteEmployee(id);
		return "Deleted Succesfully"+" => "+id;
	}

}
