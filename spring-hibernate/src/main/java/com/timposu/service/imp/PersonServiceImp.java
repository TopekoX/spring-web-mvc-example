package com.timposu.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timposu.dao.PersonDao;
import com.timposu.model.Person;
import com.timposu.service.PersonService;

@Service
@Transactional
public class PersonServiceImp implements PersonService {

	@Autowired
	private PersonDao pd;
	
	@Override
	public void save(Person person) {
		pd.save(person);
	}

	@Override
	public List<Person> findAll() {
		return pd.findAll();
	}

	@Override
	public Person findOne(Integer id) {
		return pd.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		pd.delete(id);
	}

}
