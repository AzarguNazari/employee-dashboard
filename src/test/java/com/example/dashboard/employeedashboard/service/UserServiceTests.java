package com.example.dashboard.employeedashboard.service;


import com.example.dashboard.employeedashboard.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.example.dashboard.employeedashboard.Common.loadUser;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testAddNewUser() throws Exception {

        List<Employee> employees = loadUser();

        employeeService.addAllEmployees(employees);
        Assert.assertEquals(Long.valueOf(employees.size()), employeeService.totalEmployees());

        Assert.assertEquals("username1", employeeService.getByUsername("username1").get().getUsername());

        employeeService.deleteAllEmployees();

        Assert.assertEquals(Long.valueOf(0), employeeService.totalEmployees());

    }


}