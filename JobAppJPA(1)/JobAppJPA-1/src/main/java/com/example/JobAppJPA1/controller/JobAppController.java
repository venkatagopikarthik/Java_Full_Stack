package com.example.JobAppJPA1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JobAppJPA1.model.JobPost;
import com.example.JobAppJPA1.service.JobAppService;

@RestController
public class JobAppController {
	
	@Autowired
	JobAppService service;
	
	@PostMapping("/jobpost")
	public void addJob(@RequestBody JobPost job) {
		service.createJob(job);
	}
	@GetMapping("/jobposts")
	public List<JobPost> getAllJobs() {
		return service.findJobs();
	}
	@GetMapping("/jobpost/{postId}")
	public Optional<JobPost> getJobById(@PathVariable int postId) {
		return service.getById(postId);
	}
	@PutMapping("/jobpost")
	public void updateJob(@RequestBody JobPost job) {
		service.updateJob(job);
	}
	@DeleteMapping("/jobpost/{postId}")
	public void deleteJob(@PathVariable int postId) {
		service.deleteJob(postId);
	}
	@GetMapping("/jobpost/keyword/{keyword}")
	public List<JobPost> findByKeyword(@PathVariable String keyword){
		return service.findByKeyword(keyword);
	}
	


}
