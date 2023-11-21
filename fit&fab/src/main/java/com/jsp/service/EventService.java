package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.EventDao;
import com.jsp.dto.Event;

@Component
public class EventService {

	@Autowired
	private EventDao eventDao;

	public Event saveEvent(Event event) {
		if (event != null) {
			return eventDao.saveEvent(event);
		}
		return null;
	}

	public List<Event> getAllEvents() {
		return eventDao.getAllEvents();
	}

	public boolean deleteById(int id) {
		return eventDao.deleteById(id);
	}
	public Event updateEventById(int id,Event event) {
		Event s=eventDao.getEventById(id);
		s.setEvent_name(event.getEvent_name());
		s.setDescription(event.getDescription());
		return eventDao.updateEventById(s);
	}
}