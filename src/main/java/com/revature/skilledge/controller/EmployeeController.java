package com.revature.skilledge.controller;

import com.revature.skilledge.model.Department;
import com.revature.skilledge.model.Employee;
import com.revature.skilledge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //@Controller & @ResponseBody
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployee();
    }

    @GetMapping("/find/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }



    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return  employee;
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        //logback
        return  employee;
    }

    @GetMapping("/department/{name}")
    public List<Department> getDepartments(@PathVariable String name){
        return employeeService.findByDepartment(name);
    }


//JWT Token

    //Request - URl(path variable & query params) + req headers (authentication - jwt, mime-type ) + req method + req body

}
