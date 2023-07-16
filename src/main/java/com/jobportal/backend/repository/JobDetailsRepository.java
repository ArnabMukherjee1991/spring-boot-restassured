package com.jobportal.backend.repository;

import com.jobportal.backend.model.JobDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDetailsRepository extends JpaRepository<JobDetails,String> {

    public JobDetails findByJobTitle(String jobTitle);

    //public JobDetails save(JobDetails jobDetails);

    //public List<JobDetails> addAllJobDetails(List<JobDetails> jobDetailsList);

    //public JobDetails updateJobDetails(JobDetails jobDetails);

   //public List<JobDetails> updateAllJobDetails(List<JobDetails> jobDetailsList);

    //public JobDetails deleteJobDetails(JobDetails jobDetails);

    //public List<JobDetails> findAllJobDetails();

}
