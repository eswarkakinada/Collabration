package com.niit.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.bank.model.Friend;


@EnableTransactionManagement
@Repository(value = "friendDAO")
public class FriendDAOImpl implements FriendDAO {
	public FriendDAOImpl() {
		System.out.println("in FriendDAO Impl");
	}
	@Autowired
	private SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	public boolean save(Friend friend) {
		try {
			sessionFactory.getCurrentSession().save(friend);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Friend friend) {
		try {
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Friend friend) {
		try {
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Friend get(int friendid) {
		String hql = "from Friend where friendid=" + "'" + friendid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	public List<Friend> list() {
		String hql = "from friend";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

}
