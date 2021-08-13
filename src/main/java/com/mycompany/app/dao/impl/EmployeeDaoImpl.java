package com.mycompany.app.dao.impl;




import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.app.dao.EmaployeeDao;
import com.mycompany.app.entity.Employee;
import com.mycompany.app.service.EmployeeService;


@Repository
public class EmployeeDaoImpl implements EmaployeeDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		employee.setName("arhutl");
		session1.save(employee);
		session1.close();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		empList = session.createQuery("from Employee").list();
		session.getTransaction().commit();
		session.close();
		return empList;
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(session.get(Employee.class, employeeId));
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Employee> searchEmployee(String searchTerm) {
		List<Employee> empList = new ArrayList();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		empList = session.createSQLQuery("select * from employee where name like ?1").setString(1, searchTerm).list();
		session.getTransaction().commit();
		session.close();
		return empList;
	}

}
