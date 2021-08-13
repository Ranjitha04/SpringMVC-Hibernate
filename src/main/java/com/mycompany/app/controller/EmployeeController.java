package com.mycompany.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.app.entity.Employee;
import com.mycompany.app.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute(employee);			
		return "employeeform";
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee employee, Model model) {
		employeeService.saveEmployee(employee);
		return "redirect:/getAllEmployees";
	}
	
	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		List<Employee> employeeList = employeeService.getAllEmployees();
		model.addAttribute("empList", employeeList);
		return "employeelist";
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
	public String updateEmployee(@RequestParam("employeeId") int employeeId) {
		
		return "employeelist";
	}
	
	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("employeeId") int employeeId) {
		employeeService.delete(employeeId);
		return "employeelist";
	}
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee(@RequestParam("searchTerm") String searchTerm, Model model) {
		List<Employee> employeeList = employeeService.searchEmployee(searchTerm);
		model.addAttribute("empList", employeeList);
		return "employeelist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/springrest", method = RequestMethod.GET)
	public String springrest() {	
		return "Hello, this is spring REST Demo";
	}	
}
