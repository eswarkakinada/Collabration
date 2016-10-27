package com.niit.collaboration.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "job1")
@Component
public class Job {
	@Id
	private int jobid;
	private String jobtitle;
	private String companyname;
	private String details;
	private Date creationdate;
	private Date closingdate;

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Date getClosingdate() {
		return closingdate;
	}

	public void setClosingdate(Date closingdate) {
		this.closingdate = closingdate;
	}

	
}
