package com.niit.bank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.bank.model.Job;
import com.niit.bank.model.JobApplication;



@Repository
public interface JobDAO {

	public boolean save(Job job);

	public boolean update(Job job);

	public boolean delete(Job job);

	public Job get(int jobid);

	public List<Job> getAllVacantJobs();

	public List<Job> list();

	public JobApplication get(int jobID, int userID);

	public JobApplication getMyAppliedJobs(int userID);

	public boolean updateJobApplication(JobApplication jobApplication);

	public boolean applyForJob(JobApplication jobApplication);

	public JobApplication getJobApplication(int jobID);
}
