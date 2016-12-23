package com.niit.bank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.bank.model.Friend;



@Repository
public interface FriendDAO {
	public boolean save(Friend friend);

	public boolean update(Friend friend);

	public boolean delete(Friend friend);

	public Friend get(int friendid);

	public List<Friend> list();

}
