package com.example.JobAppJPA1.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobAppJPA1.model.JobPost;

public interface JobAppRepository extends JpaRepository<JobPost,Integer> {
	public List<JobPost> findByPostProfileContainingOrPostDescContaining(String keyword, String keyword2);

}
