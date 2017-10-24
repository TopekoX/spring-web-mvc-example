package com.timposu.dao;

import java.util.List;

import com.timposu.model.Person;

public interface PersonDao {
	
	public void save(Person person);
	
	public List<Person> findAll();
}
