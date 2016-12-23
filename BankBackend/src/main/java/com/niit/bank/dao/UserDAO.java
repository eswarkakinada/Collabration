package com.niit.bank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.bank.model.User;

@Repository
public interface UserDAO {
	public boolean save(User user);

	public boolean update(User user);

	public boolean delete(User user);

	public User get(int userid);

	public List<User> list();

	public User authenticate(String email, String password);
}
