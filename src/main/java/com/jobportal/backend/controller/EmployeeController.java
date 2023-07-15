package com.jobportal.backend.controller;

import com.jobportal.backend.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.jobportal.backend.util.APiConstants.ADD_Employee;
import static com.jobportal.backend.util.APiConstants.GET_Employee;

@RestController
public class EmployeeController {
    @PostMapping(path = ADD_Employee, consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String addEmployee(@RequestBody Employee employee) {
        return "Employee " + employee.getFname() + " " + employee.getLname() + " added successfully";
    }

    @GetMapping(path = GET_Employee, consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@RequestParam String employeeId) {
        return Employee.builder().setID(employeeId).setFname("John").setLname("Doe").setEmail("test@gmail.com").build();
    }
}
