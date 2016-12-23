package com.niit.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.bank.model.Forum;


@EnableTransactionManagement
@Repository(value = "forumDAO")
public class ForumDAOImpl implements ForumDAO {

	public ForumDAOImpl() {
		System.out.println("in forumDAO Impl");
	}

	@Autowired
	private SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	public boolean save(Forum forum) {
		try {
			sessionFactory.getCurrentSession().save(forum);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Forum forum) {
		try {
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Forum get(int forumid) {
		String hql = "from forum where forumid=" + "'" + forumid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	public List<Forum> list() {
		String hql = "from forum";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
