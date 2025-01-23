package com.example.JobAppRest.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.JobAppRest.model.JobPost;



@Repository
public class JobRepository {
	
	List<JobPost> jobs=new ArrayList<>(Arrays.asList(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
			Arrays.asList("Core Java", "J2EE", "Spring Boot", "Hibernate")),
			new JobPost(2, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
					Arrays.asList("Core Java", "J2EE", "Spring Boot", "Hibernate")),
			new JobPost(3, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
					Arrays.asList("Core Java", "J2EE", "Spring Boot", "Hibernate"))));
	public void addJob(JobPost job) {
		jobs.add(job);
	}
    public List<JobPost> getAllJobs(){
    	return jobs;
    }
	public JobPost getJobById(int jobId) {
		for(JobPost job:jobs) {
			if(job.getPostId()==jobId) {
				return job;
			}
		}
		return null;
	}
	public void updateJob(JobPost job) {
	  for(JobPost job1:jobs) {
		  if(job1.getPostId()==job.getPostId()) {
			  job1.setPostId(job.getPostId());
			  job1.setPostDesc(job.getPostDesc());
			  job1.setPostProfile(job.getPostProfile());
			  job1.setReqExperience(job.getReqExperience());
			  job1.setPostTechStack(job.getPostTechStack());
		  }
		  
	  }
	  
	
	  
	}
	public void deleteById(int postId) {
		Iterator<JobPost> it=jobs.iterator();
		while(it.hasNext()) {
			JobPost job=it.next();
			if(job.getPostId()==postId) {
				it.remove();
			}
		}
		
	}
}
