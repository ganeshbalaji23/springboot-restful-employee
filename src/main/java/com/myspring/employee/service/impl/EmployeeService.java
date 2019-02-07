package com.myspring.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.employee.model.Employee;
import com.myspring.employee.repository.IEmployeeRepository;
import com.myspring.employee.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository empRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return empRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return empRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emplList = new ArrayList<>();
		empRepository.findAll().forEach(emplList::add);
		return emplList;
	}

	@Override
	public Employee getEmployee(int empId) {
		return empRepository.findById(empId).get();
	}

	@Override
	public boolean deleteEmployee(int empId) {
		 empRepository.deleteById(empId);
		 return true;
	}

}
