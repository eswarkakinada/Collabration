package com.niit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@Controller
public class HomeController {
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	User a;
	
	
	

	@RequestMapping("/")
	public ModelAndView showIndex() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "thank for visit");
		return mv;
		
	}
	
	@RequestMapping("/next")
	public ModelAndView next() {
		ModelAndView mv = new ModelAndView("next");
		System.out.println("in next ");
		a.setUserid(2);
		a.setUsername("Eswar1");
		a.setPassword("hello1");
		a.setEmail("eswar@gmail.com");
	//	a.setCreationdate(save.Date());
		a.setContact(318026);
		userDAO.save(a);
		System.out.println("completed");
		return mv;
	}

	
}
