package com.niit.bank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.bank.model.Forum;



@Repository
public interface ForumDAO {

	public boolean save(Forum forum);

	public boolean update(Forum forum);

	public boolean delete(Forum forum);

	public Forum get(int forumid);

	public List<Forum> list();
}
