package com.niit.bank.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.bank.dao.JobDAO;
import com.niit.bank.dao.UserDAO;
import com.niit.bank.model.Job;
import com.niit.bank.model.User;

@Controller
public class HomeController {
	@Autowired
	UserDAO userDAO;
	@Autowired
	User a;
	
	@Autowired
	JobDAO jobDAO;
	@Autowired
	Job j;
	

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
		/*a.setUserid(6);
		a.setUsername("Harika");
		a.setPassword("hello1");
		a.setEmail("Harika@gmail.com");
		//a.setRole("ROLE_USER");
	//	a.setCreationdate(save.Date());
		a.setContact(31588026);
		userDAO.save(a);*/
		
		j.setJobid(1);
		j.setJobtitle("TechSupport");
		j.setCompanyname("Wipro");
		j.setDetails("Bcom Students");
		jobDAO.save(j);
		
		System.out.println("completed");
		return mv;
	}

	
}
