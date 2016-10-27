package com.niit.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@RestController
public class UsersController {
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUser() {
		logger.debug("->->Calling method ListAllUsers");
		List<User> users = userDAO.list();

		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);// return[]

		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);// return  200 success
	}
   //http://localhost:8092/Collaboration/user/
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		logger.debug("calling method createUser" + user.getUserid());
		if (userDAO.get(user.getUserid()) == null) {
			userDAO.save(user);
		}
		logger.debug("user already exists with id:" + user.getUserid());
		// user.setErrorMessage("user already exists with id:"
		// +user.getUserid();
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") int userid, @RequestBody User user) {
		logger.debug("calling method updateUser" + user.getUserid());
		if (userDAO.get(userid) == null) {
			logger.debug("user does not exists with id:" + user.getUserid());
			user = new User();//
			// user.setErrorMessage("user does not exists with id:" +
			// user.getUserid());
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		userDAO.update(user);
		logger.debug("user updated successfully");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	//http://localhost:8092/Collaboration/user/student1
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") int userid) {
		logger.debug("calling method deleteUser for user id: " + userid);
		User user = userDAO.get(userid);
		if (user == null) {
			logger.debug("user does not exists with id:" + userid);
			user = new User();
			// user.setErrorMessage("user does not exists with id:" + user_id);
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		userDAO.delete(userid);
		logger.debug("userid deleted successfully");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
    //http://localhost:8092/Collaboration/user/1or2or 3 
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") int userid) {
		logger.debug("calling method getUser for user id: " + userid);
		User user = userDAO.get(userid);
		if (user == null) {
			logger.debug("user does not exists with id:" + userid);
			user = new User();// it does not means we are inserting new row
			// user.setErrorMessage("user does not exists with id:" + userid);
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		logger.debug("user exists with id:" + userid);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
