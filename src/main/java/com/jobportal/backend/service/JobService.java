package com.jobportal.backend.service;

import com.jobportal.backend.model.JobDetails;
import com.jobportal.backend.repository.JobDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JobService {

    @Autowired
    JobDetailsRepository jobDetailsRepository;
    public JobDetails addJobDetails(JobDetails jobDetails) {
        log.info("Job Details is : {}" , jobDetails.toString() );
        return jobDetailsRepository.saveAndFlush(jobDetails);
    }
}
