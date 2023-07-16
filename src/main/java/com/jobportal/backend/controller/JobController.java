package com.jobportal.backend.controller;

import com.jobportal.backend.model.JobDetails;
import com.jobportal.backend.model.records.JobInput;
import com.jobportal.backend.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class JobController {

    @Autowired
    JobService jobService;
    @SchemaMapping(typeName = "Mutation", field = "addJob")
    public JobDetails addJobDetails(@Argument JobInput jobInput) {
        return jobService.addJobDetails(JobDetails.createJobDetails(jobInput));
    }

    @QueryMapping
    public List<JobDetails> jobById(@Argument String id) {
        return List.of(JobDetails.builder()
                .setId(UUID.randomUUID())
                .setJobTitle("Senior Developer")
                .build());
    }

    @QueryMapping
    public List<JobDetails> findAllJobs() {
        return List.of(JobDetails.builder()
                        .setId(UUID.randomUUID())
                        .setJobTitle("JavaScript Developer")
                        .build(),
                JobDetails.builder()
                        .setId(UUID.randomUUID())
                        .setJobTitle("Java Developer")
                        .build());
    }
    /*@QueryMapping
    public Iterable<JobDetails> jobById(@Argument String id) {
        return List.of(JobDetails.builder().setJobId(id)
                .setJobTitle("Senior Developer").build());
    }*/
      /*  @SchemaMapping
        public Author author(Book book) {
            return Author.getById(book.getAuthorId());
        }*/
}
