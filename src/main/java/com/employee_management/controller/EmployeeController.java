package com.employee_management.controller;

import com.employee_management.model.Employee;
import com.employee_management.service.EmployeeService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggerGroup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("allemplist",employeeService.getAllEmployee());
       // System.out.println(employeeService.getAllEmployee());
         return "index";
    }
    @GetMapping("/add")
   public String addNewEmployee(Model model){
//        Employee employee = new Employee(11,"name","email","age","something");
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "addEmployee";
   }
   @PostMapping("/save")
    public  String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/";
   }
   @GetMapping("updateform/{id}")
    public String updateForm(@PathVariable(value="id") long id, Model model){
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee",employee);
        return "update";
   }
   @GetMapping("/delete/{id}")
   public String deleteById(@PathVariable(value="id") long id){
        employeeService.deleteById(id);
        return "redirect:/";
   }

}
