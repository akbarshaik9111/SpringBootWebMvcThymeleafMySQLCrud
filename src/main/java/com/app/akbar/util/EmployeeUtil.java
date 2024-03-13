package com.app.akbar.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;

import com.app.akbar.entity.Employee;

public interface EmployeeUtil {
	
	public static void commonCalculations(Employee employee) {
		double hra = employee.getEmpSal()*(6.0/100);
		double ta = employee.getEmpSal()*(4.0/100);
		employee.setEmpHa(hra);
		employee.setEmpTra(ta);
	}
	
	public static void departmentList(Model model) {
		List<String> deptList = Arrays.asList("DEV", "QA", "PROD", "BA", "ADMIN", "IT");
		model.addAttribute("deptList", deptList);
	}

}
