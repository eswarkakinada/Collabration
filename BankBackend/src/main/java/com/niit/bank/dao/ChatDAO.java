package com.niit.bank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.bank.model.Chat;



@Repository
public interface ChatDAO {
	public boolean save(Chat chat);

	public boolean update(Chat chat);

	public boolean delete(Chat chat);

	public Chat get(int chatid);

	public List<Chat> list();
}
