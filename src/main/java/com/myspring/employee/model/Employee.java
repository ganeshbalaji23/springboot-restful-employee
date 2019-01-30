package com.myspring.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {
	
	@Id
	@Column(name = "employee_id")
	private String empNo;
	@Column(name = "employee_designation")
	private String empName;
	@Column(name = "employee_name")
	private String designation;
	@Column(name = "employee_salary")
	private String salary;

}
