package com.niit.bank.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "forum")
@Component
public class Forum extends BaseDomain {

	@Id
	private int forumid;
	private String forumname;
	private String topicname;
	private int userid;
	private Date creationdate;
	private String topic_content;

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public String getForumname() {
		return forumname;
	}

	public void setForumname(String forumname) {
		this.forumname = forumname;
	}

	public String getTopicname() {
		return topicname;
	}

	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public String getTopic_content() {
		return topic_content;
	}

	public void setTopic_content(String topic_content) {
		this.topic_content = topic_content;
	}

}
