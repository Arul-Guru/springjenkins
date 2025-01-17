package com.revature.skilledge.employee;

import com.revature.skilledge.model.Department;
import com.revature.skilledge.model.Employee;
import com.revature.skilledge.repository.EmployeeRepository;
import com.revature.skilledge.service.EmployeeService;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService service;

    @Mock
    private EmployeeRepository repository; //stubbing

    @BeforeEach
    public void display(){
        System.out.println("testing employee service");
    }

    public EmployeeServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @AfterAll
    public static void displayEnd(){

        System.out.println("testing employee service done");
    }


    @Test
    public void testGetAppname(){
        service = new EmployeeService();
        String appName = service.getAppName();
        System.out.println("App name: "+appName);
        Assertions.assertEquals("dummy",appName);
    }

    @Test
    public void testGetAllEmployee(){
        List<Employee> employees = Arrays.asList(new Employee(1l,"arul", new Department(), 100000),new Employee(2L,"Guru", new Department(), 100000));

        when(repository.findAll()).thenReturn(employees);

//        when(repository.findByName("arul")).thenReturn(employees);


        List<Employee> employees1 = service.getEmployee();  //
        Assertions.assertEquals(2,employees1.size());
        Assertions.assertEquals("Guru", employees1.get(1).getName());
    }


}
