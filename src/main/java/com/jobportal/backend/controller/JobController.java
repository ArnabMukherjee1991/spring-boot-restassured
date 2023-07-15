package com.jobportal.backend.controller;

import com.jobportal.backend.model.JobDetails;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class JobController {
    @QueryMapping
    public List<JobDetails> jobById(@Argument String id) {
        return List.of(JobDetails.builder()
                .setId(id)
                .setJobTitle("Senior Developer")
                .build());
    }

    @QueryMapping
    public List<JobDetails> findAllJobs() {
        return List.of(JobDetails.builder()
                        .setId("1234")
                        .setJobTitle("JavaScript Developer")
                        .build(),
                JobDetails.builder()
                        .setId("1235")
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
