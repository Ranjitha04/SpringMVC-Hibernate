package com.mycompany.app.dao;

import java.util.List;

import com.mycompany.app.entity.Employee;

public interface EmaployeeDao {

	void saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	void deleteEmployee(int employeeId);

	List<Employee> searchEmployee(String searchTerm);

}
