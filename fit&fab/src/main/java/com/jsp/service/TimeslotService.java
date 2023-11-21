package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.TimeslotDao;
import com.jsp.dto.Timeslot;
@Component
public class TimeslotService {

	@Autowired
	private TimeslotDao timeslotDao;

	public Timeslot saveTimeslot(Timeslot timeslot) {
		if (timeslot != null) {
			return timeslotDao.saveTimeslot(timeslot);
		}
		return null;
	}

	public List<Timeslot> getAllTimeslots() {
		return timeslotDao.getAllTimeslots();
	}

	public boolean deleteById(int id) {
		return timeslotDao.deleteById(id);
	}
	public Timeslot updateTimeslotById(int id,Timeslot timeslot) {
		Timeslot s=timeslotDao.getTimeslotById(id);
		s.setCount(timeslot.getCount());
		s.setLimit(timeslot.getLimit());
		s.setTiming(timeslot.getTiming());
		return timeslotDao.updateTimeslotById(s);
	}


}
