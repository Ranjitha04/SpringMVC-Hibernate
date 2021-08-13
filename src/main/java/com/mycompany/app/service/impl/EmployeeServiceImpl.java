package com.mycompany.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.dao.EmaployeeDao;
import com.mycompany.app.entity.Employee;
import com.mycompany.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmaployeeDao employeeDao;
	
	@Override
	public void saveEmployee(Employee employee) {
	
		employeeDao.saveEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployees();
	}

	@Override
	public void delete(int employeeId) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(employeeId);
	}

	@Override
	public List<Employee> searchEmployee(String searchTerm) {
		// TODO Auto-generated method stub
		return employeeDao.searchEmployee(searchTerm);
	}

}
