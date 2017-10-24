package com.timposu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timposu.dao.PersonDao;
import com.timposu.model.Person;
import com.timposu.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;

	@Override
	public void save(Person person) {
		personDao.save(person);		
	}

	@Override
	public List<Person> findAll() {
		return personDao.findAll();
	}

}
