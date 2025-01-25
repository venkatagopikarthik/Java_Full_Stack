package com.example.JobAppJPA1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JobAppJPA1.Repo.JobAppRepository;
import com.example.JobAppJPA1.model.JobPost;

@Service
public class JobAppService {
	@Autowired
	
JobAppRepository repo;
	
	public void createJob(JobPost job) {
		repo.save(job);
		
	}
	public List<JobPost> findJobs(){
		return repo.findAll();
		}
	public Optional<JobPost> getById(int postId) {
		return repo.findById(postId);
		
	}
	public void updateJob(JobPost job) {
		repo.save(job);
	}
	public void deleteJob(int postId) {
		repo.deleteById(postId);
	}
	public List<JobPost> findByKeyword(String keyword){
		return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
	}
	
}
