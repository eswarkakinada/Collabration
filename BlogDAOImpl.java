package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaboration.model.Blog;
@EnableTransactionManagement
@Repository(value = "blogDAO")
public class BlogDAOImpl implements BlogDAO {
	public BlogDAOImpl() {
		System.out.println("in blogDAO Impl");
	}
	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}
	public boolean save(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Blog get(int blogid) {
		String hql = "from Blog where blogid=" + "'" + blogid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Blog> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	public List<Blog> list() {
		String hql = "from blog";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

}
