package com.jobportal.backend.model.records;



import java.time.LocalDate;
import java.util.List;

public record JobInput(
                       String jobTitle,
                       String salary,
                       int minExperience,
                       int maxExperience,
                       String location,
                       List<String> coreSkills,
                       List<String> additionalSkills,
                       String jobDescription,
                       LocalDate postedDate) {

}
