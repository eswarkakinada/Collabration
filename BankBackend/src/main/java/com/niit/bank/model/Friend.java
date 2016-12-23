package com.niit.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "friend")
@Component
public class Friend extends BaseDomain{
	@Id
	private int friendid;
	private int userid;
	private String friendname;
	private String status;
	private String gender;

	public int getFriendid() {
		return friendid;
	}

	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFriendname() {
		return friendname;
	}

	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
