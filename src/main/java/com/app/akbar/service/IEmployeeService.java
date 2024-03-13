package com.app.akbar.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.app.akbar.entity.Employee;

public interface IEmployeeService {

	Integer saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	Employee getOneEmployee(Integer id);

	void deleteEmployee(Integer id);

	List<Employee> getAllEmployees();
	
	Page<Employee> getAllEmployees(Pageable pageable);

}
