package com.jobportal.backend.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Builder(toBuilder = true, setterPrefix = "set")
@Entity
@Table(name = "ORGANIZATION")
public class Organization {
    @Id
    @Column(name = "ORGANIZATION_ID", nullable = false, updatable = false)
    String organizationId;
    String organizationName;
    OrganizationType organizationType;
    String address;
    String city;

   /* @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
    //@JoinColumn(name = "JOB_ID")
    List<JobDetails> jobDetailsList;*/

}
