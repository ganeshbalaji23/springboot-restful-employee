package com.myspring.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.myspring.employee.model.Employee;

@Component
public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {
	
	

}
