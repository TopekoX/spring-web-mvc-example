package com.timposu.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.timposu.dao.PersonDao;
import com.timposu.model.Person;

@Repository
public class PersonDaoImp implements PersonDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Person person) {
		sessionFactory.getCurrentSession().saveOrUpdate(person);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Person> findAll() {
		return (List<Person>) (sessionFactory.getCurrentSession()
				.createCriteria(Person.class).list());
	}

	@Override
	public Person findOne(Integer id) {
		Person person = sessionFactory.getCurrentSession()
				.get(Person.class, id);
		return person;
	}

	@Override
	public void delete(Integer id) {
		Person person = sessionFactory.getCurrentSession()
				.get(Person.class, id);
		sessionFactory.getCurrentSession().delete(person);
	}

}
