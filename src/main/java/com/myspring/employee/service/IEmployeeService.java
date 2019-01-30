package com.myspring.employee.service;

import java.util.List;

import com.myspring.employee.model.Employee;

public interface IEmployeeService {
	
	Employee addEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployee(String empId);
	
	boolean deleteEmployee(String empId);

}
