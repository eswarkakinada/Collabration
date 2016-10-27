package com.niit.collaboration.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "chat1")
@Component
public class Chat {
	@Id

	private int userid;
	private int forumid;
	private String friendname;
	private String history;
	private Date startedtime;
	private String status;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public String getFriendname() {
		return friendname;
	}

	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public Date getStartedtime() {
		return startedtime;
	}

	public void setStartedtime(Date startedtime) {
		this.startedtime = startedtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
