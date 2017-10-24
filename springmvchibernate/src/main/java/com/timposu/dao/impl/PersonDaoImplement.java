package com.timposu.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.timposu.dao.PersonDao;
import com.timposu.model.Person;

@Repository
public class PersonDaoImplement implements PersonDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Person person) {
		sessionFactory.getCurrentSession().save(person);
	}

	@Override
	public List<Person> findAll() {
		TypedQuery<Person> query = sessionFactory.getCurrentSession()
				.createQuery("from Person", Person.class);
		return query.getResultList();
	}

}
