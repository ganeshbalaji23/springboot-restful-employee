package com.myspring.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.employee.model.Employee;
import com.myspring.employee.service.impl.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService emplService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployeeDetails(@RequestBody Employee employee) {
		return emplService.addEmployee(employee);
	}
	
	@PutMapping("/updateEmployee/{empId}")
	public Employee updateEmployeeDetails(@RequestBody Employee employee, @PathVariable("empId") String empId) {
		return emplService.updateEmployee(employee);
	}
	
	@GetMapping("/getEmployeeDetail/{empId}")
	public Employee getEmployeeDetail(@PathVariable("empId") String empId) {
		return emplService.getEmployee(empId);
	}
	
	@GetMapping("/getAllEmployeeDetails}")
	public List<Employee> getEmployeeDetail() {
		return emplService.getAllEmployees();
	}

}
