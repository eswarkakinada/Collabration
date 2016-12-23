package com.niit.bank.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.bank.dao.EventDAO;
import com.niit.bank.model.Event;

public class EventController {

	
	@Autowired
	EventDAO eventDAO;
	
	@RequestMapping(value="/events",method=RequestMethod.GET)
	public ResponseEntity<List<Event>> listAllEvents(){
		
		List<Event> event=eventDAO.list();
		if(event.isEmpty()){
			return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Event>>(event,HttpStatus.OK);
	}

	@RequestMapping(value="/event/",method=RequestMethod.POST)
	public ResponseEntity<Event> createEvent(@RequestBody Event event){
	
		if(eventDAO.get(event.getEventid())==null){
			eventDAO.save(event);			
		}
	
		event.setErrormessage("event already exists with id:" + event.getEventid());
		return new ResponseEntity<Event>(event,HttpStatus.OK);
			}
	
	@RequestMapping(value="/event/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Event> updateEvent(@PathVariable("id") int event_id,@RequestBody Event event){
		
		if(eventDAO.get(event_id)==null){
				
			event=new Event();
			event.setErrormessage("event does not exists with id:" + event.getEventid());
			return new ResponseEntity<Event> (event,HttpStatus.NOT_FOUND);
		}
		eventDAO.update(event);
		
		return new ResponseEntity<Event> (event,HttpStatus.OK);		
	}

	@RequestMapping(value="/event/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Event> deleteEvent(@PathVariable("id") int eventid){
		
		Event event=eventDAO.get(eventid);
		if(event==null){
			
			event=new Event();
			event.setErrormessage("event does not exists with id:" + eventid);
			return new ResponseEntity<Event> (event,HttpStatus.NOT_FOUND);	
		}
		eventDAO.delete(eventid);
		
		return new ResponseEntity<Event> (event,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/event/{id}",method=RequestMethod.GET)
	public ResponseEntity<Event> getEvent(@PathVariable("id") int eventid){
		//
		Event event=eventDAO.get(eventid);
		if(event==null){
		
			event=new Event();
			event.setErrormessage("event does not exists with id:" + eventid);
			return new ResponseEntity<Event> (event,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Event> (event,HttpStatus.OK);
	}

}
