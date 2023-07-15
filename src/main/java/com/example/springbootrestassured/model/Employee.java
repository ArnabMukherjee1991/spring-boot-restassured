package com.example.springbootrestassured.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Builder(setterPrefix = "set", toBuilder = true)
@AllArgsConstructor
public class Employee {
    String ID;
    String fname;
    String lname;
    String email;
    String phone;
    String dept;
    String designation;
    String salary;
    String city;
    String state;
}
