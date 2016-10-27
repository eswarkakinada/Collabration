package com.niit.collaboration.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.Blog;



@Repository
public interface BlogDAO {

	public boolean save(Blog blog);

	public boolean update(Blog blog);

	public boolean delete(Blog blog);

	public Blog get(int id);

	public List<Blog> list();
}
