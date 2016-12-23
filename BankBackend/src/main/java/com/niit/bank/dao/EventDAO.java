package com.niit.bank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.bank.model.Event;





@Repository
public interface EventDAO {
	
	public boolean save(Event event);

	public boolean update(Event event);

	public boolean delete(int event);

	public Event get(int eventid);

	public List<Event> list();
}
