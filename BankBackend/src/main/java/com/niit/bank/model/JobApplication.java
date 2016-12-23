package com.niit.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="JOB_APPLICATION")
@Component
public class JobApplication  extends BaseDomain{
	@Id
	private int id;
	private int jobid;
	private int userid;
	private char status;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
}
