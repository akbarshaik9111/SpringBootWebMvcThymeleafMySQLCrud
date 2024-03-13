package com.app.akbar.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.akbar.entity.Employee;
import com.app.akbar.exception.EmployeeNotFoundException;
import com.app.akbar.repo.EmployeeRepository;
import com.app.akbar.service.IEmployeeService;
import com.app.akbar.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmployee(Employee employee) {
		EmployeeUtil.commonCalculations(employee);
		Employee emp = repo.save(employee);
		return emp.getEmpId();
	}

	@Override
	public void updateEmployee(Employee employee) {
		EmployeeUtil.commonCalculations(employee);
		repo.save(employee);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		//Optional<Employee> emp = repo.findById(id);
		//return emp.get();
		return repo.findById(id)
			.orElseThrow(() -> new EmployeeNotFoundException("Employee '"+id+"' Not Found"));
	}

	@Override
	public void deleteEmployee(Integer id) {
		/*
		Optional<Employee> opt = repo.findById(id);
		if(opt.isPresent()) {
			repo.delete(opt.get());
		} else {
			throw new EmployeeNotFoundException("EMPLOYEE '"+id+"' NOT FOUND");
		}
		*/
		repo.delete(
				this.getOneEmployee(id));

	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = repo.findAll();
		return list;
	}
	
	public Page<Employee> getAllEmployees(Pageable pageable) {
		Page<Employee> pages = repo.findAll(pageable);
		return pages;
	}
}
