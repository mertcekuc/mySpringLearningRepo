package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService theService){
        employeeService = theService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        List<Employee> list = employeeService.findAll();

        model.addAttribute("employees",list);

        return "employees/employees-list";
    }

    @GetMapping("/showFormForAdd")
    public String ShowFormForAdd(Model model){
        Employee emp = new Employee();

        model.addAttribute("employee",emp);

        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);

        return "redirect:/employees/list";

    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("id") int id, Model model){
        Employee emp = employeeService.findById(id);

        model.addAttribute("employee",emp);

        return "/employees/employee-update-form";
    }

    @RequestMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id){
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
