package com.example.JobAppRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JobAppRest.Repository.JobRepository;
import com.example.JobAppRest.model.JobPost;

@Service
public class JobService {
	@Autowired
	JobRepository repo;
	
	public List<JobPost> getAllJobs(){
		return repo.getAllJobs();
	}
	public void addJob(JobPost job) {
		repo.addJob(job);
	}
	public JobPost getJobById(int jobId) {
		// TODO Auto-generated method stub
		return repo.getJobById(jobId);
	}
	public void updateJob(JobPost job) {
		 repo.updateJob(job);
	}
	public void deleteById(int postId) {
		repo.deleteById(postId);
	}

}
