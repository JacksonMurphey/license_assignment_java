package com.jmurphey.relationships.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmurphey.relationships.models.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {
	
	List<Person> findAll();
	
	List<Person> findByLicenseIdIsNull();
	
//	Optional<Person> findById(Long id);
	
	
	
}
