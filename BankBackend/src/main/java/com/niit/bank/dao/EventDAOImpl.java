package com.niit.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.bank.model.Event;


@EnableTransactionManagement
@Repository(value = "eventDAO")
public class EventDAOImpl implements EventDAO {
	public EventDAOImpl() {
		System.out.println("in EventDAO Impl");
	}
	@Autowired
	private SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	public boolean save(Event event) {
		try {
			sessionFactory.getCurrentSession().save(event);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Event event) {
		try {
			sessionFactory.getCurrentSession().update(event);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int event) {
		try {
			sessionFactory.getCurrentSession().delete(event);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Event get(int eventid) {
		String hql = "from Event where eventid=" + "'" + eventid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	public List<Event> list() {
		String hql = "from event";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

}
