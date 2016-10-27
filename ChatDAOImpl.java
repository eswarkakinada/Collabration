package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaboration.model.Chat;

@EnableTransactionManagement
@Repository(value = "chatDAO")
public class ChatDAOImpl implements ChatDAO {
	public ChatDAOImpl() {
		System.out.println("in chatDAO Impl");
	}
	@Autowired
	private SessionFactory sessionFactory;

	public ChatDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	public boolean save(Chat chat) {
		try {
			sessionFactory.getCurrentSession().save(chat);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Chat chat) {
		try {
			sessionFactory.getCurrentSession().update(chat);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Chat chat) {
		try {
			sessionFactory.getCurrentSession().delete(chat);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Chat get(int chatid) {
		String hql = "from Chat where chatid=" + "'" + chatid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Chat> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	public List<Chat> list() {
		String hql = "from chat";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
