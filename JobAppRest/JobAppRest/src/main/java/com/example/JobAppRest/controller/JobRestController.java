package com.example.JobAppRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.JobAppRest.model.JobPost;
import com.example.JobAppRest.service.JobService;

@RestController
public class JobRestController {
	@Autowired
	JobService service;
   @GetMapping("/jobposts")
   public List<JobPost> getAllJobs(){
	   return service.getAllJobs();
}
   @PostMapping("/jobpost")
   public void addJob(@RequestBody JobPost job) {
	   service.addJob(job);
   }
   @GetMapping("/jobpost/{postId}")
   public JobPost getJobById(@PathVariable int postId  ){
	   return service.getJobById(postId);
	   
   }
   @PutMapping("/jobpost")
   public String updateJob(@RequestBody JobPost job  ){
	    service.updateJob(job);
	    return "Updated";
	   
   }
   @DeleteMapping("/jobpost/{postId}")
   public String deleteById(@PathVariable int postId  ){
	    service.deleteById(postId);
	    return "deleted";
	   
   }
}
