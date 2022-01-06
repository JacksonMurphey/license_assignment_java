package com.jmurphey.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmurphey.relationships.models.Person;
import com.jmurphey.relationships.repositories.PersonRepo;

@Service
public class PersonService {

//	private final PersonRepo personRepo;
//	
//	public PersonService(PersonRepo personRepo) {
//		this.personRepo = personRepo;
//	}
	
	
	@Autowired
	private PersonRepo personRepo;
	
	
	
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}
	
	// This allows me to not have to create an optional method in my repo. 
	public Person getOnePerson(Long id) {
		return this.personRepo.findById(id).orElse(null);
	}
	
	public List<Person> getAllPersons(){
		return personRepo.findAll();
	}
	
	public List<Person> getPeopleWithNoLicense(){
		return this.personRepo.findByLicenseIdIsNull();
	}
	
//	public Person findPerson(Long id) {
//		Optional<Person> personOptional = personRepo.findById(id);
//		if(personOptional.isPresent()) {
//			return personOptional.get();
//		} else { 
//			return null;
//		}
//	}
//	
//	public Person getPerson(Long id) {
//		return this.findPerson(id);
//	}
	
	
	

	
	
	
	
}
