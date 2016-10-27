package com.niit.collaboration.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.Forum;
import com.niit.collaboration.model.Job;

@Repository
public interface JobDAO {

	public boolean save(Job job);

	public boolean update(Job job);

	public boolean delete(Job job);

	public boolean postjob(Job job);

	public boolean updatejob(Job job);

	public boolean applyforjob(Job job);

	public boolean updatejobapplication(Job job);

	public List<Job> getAllVacantJobs();

	public Job get(int jobid);

	public List<Job> list();
}
