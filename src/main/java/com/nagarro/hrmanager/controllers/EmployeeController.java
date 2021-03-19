package com.nagarro.hrmanager.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lowagie.text.DocumentException;
import com.nagarro.hrmanager.createpdf.CreatePDF;
import com.nagarro.hrmanager.entity.Employee;
import com.nagarro.hrmanager.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	
	
	@GetMapping("/employeeList")
	public String Employee(Model model) {
	List<Employee> employee = this.employeeService.allEmployee();
	model.addAttribute("employeeList",employee);
	return "EmployeeList";
	}
	
	@GetMapping("/showFormNewEmployee")
	public String employeeForm() {
		return "AddNewEmployee";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String updateEmployeeForm(@PathVariable("id") long id,Model model) {
		Employee employee = this.employeeService.getEmployeeById(id);
		model.addAttribute("employeeData", employee);
		return "UpdateEmployeeDetails";
	}
	
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employeeData") Employee employeeData) {
		System.out.println("saving");
		this.employeeService.saveEmployee(employeeData);
		return "redirect:/employeeList";
	}
	
	@PostMapping("/updateEmployee/{id}")
	public String updateEmployee(@ModelAttribute("employeeData") Employee employeeData) {
		System.out.println("updating");
		this.employeeService.updateEmployee(employeeData);
		return "redirect:/employeeList";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") long id,Model model) {
		System.out.println("deleting");
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/employeeList";
	}
	
	
	@GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=employeeList_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        
        List<Employee> listEmployee = employeeService.listAll();
        
        CreatePDF exporter = new CreatePDF(listEmployee);
        exporter.export(response);
        
    }

}
