package com.jobportal.backend.model;

import com.jobportal.backend.model.records.JobInput;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Builder(toBuilder = true, setterPrefix = "set")
@Entity
@Table(name = "JOB_DETAILS")
@NoArgsConstructor
@AllArgsConstructor
public class JobDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "JOB_ID", nullable = false, updatable = false)
    UUID id;
    String jobTitle;
    String salary;
    int minExperience;
    int maxExperience;
    String location;
    //List<String> coreSkills;
    //List<String> additionalSkills;
    String jobDescription;
    LocalDate postedDate;
    /*@ManyToOne(targetEntity = Organization.class,fetch = LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    private Organization organization;

    @ManyToMany(mappedBy = "jobDetailsSet")
    private Set<Employee> employees;*/

    public static JobDetails createJobDetails(JobInput jobInput) {
        return JobDetails.builder()
                .setJobTitle(jobInput.jobTitle())
                .setSalary(jobInput.salary())
                .setMinExperience(jobInput.minExperience())
                .setMaxExperience(jobInput.maxExperience())
                .setLocation(jobInput.location())
                //.setCoreSkills(jobInput.coreSkills())
                //.setAdditionalSkills(jobInput.additionalSkills())
                .setJobDescription(jobInput.jobDescription())
                .setPostedDate(jobInput.postedDate())
                .build();
    }
}
