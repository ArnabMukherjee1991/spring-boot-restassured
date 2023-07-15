package com.example.springbootrestassured.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Builder(toBuilder = true, setterPrefix = "set")
public class JobDetails {

    String id;
    String jobTitle;
    String salary;
    int minExperience;
    int maxExperience;
    String location;
    List<String> coreSkills;
    List<String> additionalSkills;
    String jobDescription;
    LocalDate postedDate;
}
