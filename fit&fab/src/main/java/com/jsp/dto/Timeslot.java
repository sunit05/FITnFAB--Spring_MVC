package com.jsp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Timeslot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int count;
	private int limit;
	private double timing;

	@ManyToMany
	private List<Event> events;

	@ManyToMany
	private List<Customer> customers;

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public double getTiming() {
		return timing;
	}

	public void setTiming(double timing) {
		this.timing = timing;
	}

}
