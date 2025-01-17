package com.revature.skilledge.service;

import com.revature.skilledge.model.Department;
import com.revature.skilledge.model.Employee;
import com.revature.skilledge.repository.DepartmentRepository;
import com.revature.skilledge.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    @Autowired
    private DepartmentRepository departmentRepo;

    @Value("${app.name}")
    private String appName;

    public void addEmployee(Employee emp){
        repo.save(emp);
    }

    public List<Employee> getEmployee(){

       return repo.findAll();
    }

    public Employee getEmployeeById(Long id){
        return repo.findById(id).orElse(null);
    }


    public void updateEmployee(Employee employee){
        repo.save(employee);
    }

    public List<Department> findByDepartment(String dept){
       return departmentRepo.findByName(dept);
    }

    public String getAppName() {
        return "dummy";
    }
}
