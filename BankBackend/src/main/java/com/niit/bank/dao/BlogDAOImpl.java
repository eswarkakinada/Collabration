package com.niit.bank.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.bank.model.Blog;


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

	@Transactional
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

	@Transactional
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

	@Transactional
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

	@Transactional
	public Blog get(int blogid) {
		String hql = "from Blog where blogid=" + blogid ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Blog> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	@Transactional
	public List<Blog> list() {
		String hql = "from Blog";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

}
