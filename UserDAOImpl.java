package com.niit.collaboration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaboration.model.User;

@EnableTransactionManagement
@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO {

	public UserDAOImpl() {
		System.out.println("in userDAO Impl");
	}

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	

	@Transactional
	public User get(int userid) {
		String hql = "from User where userid=" + userid;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = (List<User>)query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	@Transactional
	public List<User> list() {
		String hql = "from User";
	    Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
@Transactional
	public boolean delete(int userid) {
		try {
			sessionFactory.getCurrentSession().delete(userid);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}



}
