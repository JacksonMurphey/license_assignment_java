package com.jmurphey.relationships.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmurphey.relationships.models.License;
import com.jmurphey.relationships.models.Person;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long> {
	
	Optional<License> findByPerson(Person person);
	
	List<License> findAll();
	
	License findTopByOrderByNumberDesc();
	
	
}
