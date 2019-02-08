package com.myspring.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.employee.model.Employee;
import com.myspring.employee.service.impl.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService emplService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployeeDetails(@RequestBody Employee employee) {
		return emplService.addEmployee(employee);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployeeDetails(@RequestBody Employee employee) {
		return emplService.updateEmployee(employee);
	}
	
	@GetMapping("/getEmployeeDetail/{empId}")
	public Employee getEmployeeDetail(@PathVariable("empId") int empId) {
		Employee e = emplService.getEmployee(empId);
		System.out.println(e.toString());
		return e;
	}
	
	@GetMapping("/getAllEmployeeDetails")
	@HystrixCommand(fallbackMethod = "getDataFallback")
	public List<Employee> getEmployeeDetail() {
		
		System.out.println("*********************Inside Get all employee details page**********************************");
		List<Employee> empList = emplService.getAllEmployees();
		if(!empList.isEmpty()) {
			throw new RuntimeException();
		}
		return empList;
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public void deleteEmployee(@PathVariable("empId") int empId) {
		emplService.deleteEmployee(empId);
	}
	
	public List<Employee> getDataFallback() {
		
		System.out.println("*********************Inside Falback Method**********************************");
		Employee emp = new Employee();
		emp.setEmpNo(2);
		emp.setEmpName("Dhivya");
		emp.setDesignation("SE");
		emp.setSalary("10000");
		
		List<Employee> empList = new ArrayList<>();
		empList.add(emp);
		return empList;
		
	}

}
