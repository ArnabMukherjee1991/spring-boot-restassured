package com.example.springbootrestassured.controller;

import com.example.springbootrestassured.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.example.springbootrestassured.util.APiConstants.ADD_Employee;

@RestController
public class EmployeeController {
    @PostMapping(path = ADD_Employee, consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String addEmployee(@RequestBody Employee employee) {
        return "Employee " + employee.getFname() + " " + employee.getLname() + " added successfully";
    }
}
