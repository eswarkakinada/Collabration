package com.niit.bank.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.bank.dao.BlogDAO;
import com.niit.bank.model.Blog;






@RestController
public class BlogController {

private static final Logger logger	= LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	BlogDAO blogDAO;
	
	@RequestMapping(value="/blogs",method=RequestMethod.GET)
	public ResponseEntity<List<Blog>> listAllBlogs(){
		logger.debug("calling method listAllBlogs");
		List<Blog> blog=blogDAO.list();
		if(blog.isEmpty()){
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Blog>>(blog,HttpStatus.OK);
	}

	@RequestMapping(value="/blog/",method=RequestMethod.POST)
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
		logger.debug("calling method createBlog" + blog.getBlogid());
		if (blogDAO.save(blog) == true) {
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		}
		logger.debug("blog already exists with id:" + blog.getBlogid());
		blog.setErrormessage("blog already exists with id:" + blog.getBlogid());
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
			}
	
	@RequestMapping(value="/blog/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Blog> updateBlog(@PathVariable("id") int blogid,@RequestBody Blog blog){
		logger.debug("calling method updateBlog" + blog.getBlogid());
		if(blogDAO.get(blogid)==null){
			logger.debug("blog does not exists with id:" + blog.getBlogid());		
			blog=new Blog();
			blog.setErrormessage("blog does not exists with id:" + blog.getBlogid());
			return new ResponseEntity<Blog> (blog,HttpStatus.NOT_FOUND);
		}
		blogDAO.update(blog);
		logger.debug("blog updated successfully");
		return new ResponseEntity<Blog> (blog,HttpStatus.OK);		
	}

	@RequestMapping(value="/blog/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Blog> deleteBlog(@PathVariable("id") int blogid){
		logger.debug("calling method deleteBlog for blog id: " + blogid);
		Blog blog=blogDAO.get(blogid);
		if(blog==null){
			logger.debug("blog does not exists with id:" + blogid);
			blog=new Blog();
			blog.setErrormessage("blog does not exists with id:" + blogid);
			return new ResponseEntity<Blog> (blog,HttpStatus.NOT_FOUND);	
		}
		blogDAO.delete(blog);
		logger.debug("blog deleted successfully");
		return new ResponseEntity<Blog> (blog,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/blog/{id}",method=RequestMethod.GET)
	public ResponseEntity<Blog> getBlog(@PathVariable("id") int blogid){
		logger.debug("calling method getBlog for blog id: " + blogid);
		Blog blog=blogDAO.get(blogid);
		if(blog==null){
			logger.debug("blog does not exists with id:" + blogid);
			blog=new Blog();
			blog.setErrormessage("blog does not exists with id:" + blogid);
			return new ResponseEntity<Blog> (blog,HttpStatus.NOT_FOUND);
		}
		logger.debug("blog exists with id:" + blogid);
		return new ResponseEntity<Blog> (blog,HttpStatus.OK);
	}


}