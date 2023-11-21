package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Event;

@Component
public class EventDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Event saveEvent(Event event) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(event);
		entityTransaction.commit();
		return event;
	}

	public boolean deleteById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Event event = entityManager.find(Event.class, id);
		if (event != null) {
			entityTransaction.begin();
			entityManager.remove(event);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Event updateEventById(Event event) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(event);
		entityTransaction.commit();
		return event;
	}

	public Event getEventById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Event.class, id);
	}

	public List<Event> getAllEvents() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("SELECT s FROM Event s");
		List<Event> events = query.getResultList();
		return events;
	}
}
