package com.jobportal.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Builder(setterPrefix = "set", toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, updatable = false)
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

   /* @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "EMPLOYEE_JOB_DETAILS",
            joinColumns = { @JoinColumn(name = "EMPLOYEE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "JOB_ID") }
    )
    Set<JobDetails> jobDetailsSet;*/

}
