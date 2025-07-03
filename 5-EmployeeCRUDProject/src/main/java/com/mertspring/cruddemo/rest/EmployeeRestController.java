package com.mertspring.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mertspring.cruddemo.dao.EmployeeDAO;
import com.mertspring.cruddemo.entity.Employee;
import com.mertspring.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper){
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee findByID(@PathVariable int employeeID){
        Employee emp = employeeService.finByID(employeeID);

        if (emp == null){
            throw new RuntimeException("Employee not found. ID: "+employeeID);}

        return  emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee emp = employeeService.save(employee);
        return emp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.save(employee);

        return emp;
    }

    @PatchMapping("employees/{employeeid}")
    public Employee patchEmployee(@PathVariable int employeeid,
                                  @RequestBody Map<String,Object> patchBody){

        Employee emp = employeeService.finByID(employeeid);

        if (emp == null){
            throw new RuntimeException("Employee id not found: "+employeeid);
        }

        if(patchBody.containsKey("id")){
            throw  new RuntimeException("Patch body cant contain id key");
        }

        Employee patchEmp = apply(emp,patchBody);

        Employee dbEmp = employeeService.save(patchEmp);

        return dbEmp;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        if (employeeService.finByID(id) == null){
            throw new RuntimeException(String.format("Employee with id: %d can't be found.",id));
        }

        employeeService.delete(id);

        return String.format("Employee %d is deleted",id);
    }

    private Employee apply(Employee emp, Map<String, Object> patchBody) {

        ObjectNode employeeNode = objectMapper.convertValue(emp, ObjectNode.class);

        ObjectNode patchNode = objectMapper.convertValue(patchBody,ObjectNode.class);

        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode,Employee.class);
    }

}
