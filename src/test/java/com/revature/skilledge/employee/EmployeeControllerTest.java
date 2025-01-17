package com.revature.skilledge.employee;


import com.revature.skilledge.controller.EmployeeController;
import com.revature.skilledge.model.Department;
import com.revature.skilledge.model.Employee;
import com.revature.skilledge.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeService employeeService;


    @Test
    void testGetEmployeesById() throws Exception {
        when(employeeService.getEmployeeById(4l)).thenReturn(new Employee(4l, "John", new Department(), 120000));


        mockMvc.perform(get("/api/employees/find/4")).andExpect(status().isOk()).andExpect(jsonPath("name").value("John"));
    }



}
