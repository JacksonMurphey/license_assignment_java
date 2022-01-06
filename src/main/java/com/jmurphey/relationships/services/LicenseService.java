package com.jmurphey.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmurphey.relationships.models.License;
import com.jmurphey.relationships.models.Person;
import com.jmurphey.relationships.repositories.LicenseRepo;
import com.jmurphey.relationships.repositories.PersonRepo;

@Service
public class LicenseService {

	public final LicenseRepo licenseRepo;
	public final PersonRepo personRepo;
	
	public LicenseService(LicenseRepo licenseRepo, PersonRepo personRepo) {
		this.licenseRepo = licenseRepo;
		this.personRepo = personRepo;
		
	}
	
	public License findPersonLicense(Long id) {
		Optional<Person> personOptional = personRepo.findById(id);
		if(personOptional.isPresent()) {
			Optional<License> licenOptional = licenseRepo.findByPerson(personOptional.get());
			return licenOptional.get();
			} else {
				return null;
			}
			
	}
		
	
	
	public License findLink(Person person) {
		Optional<License> licenseOptional = licenseRepo.findByPerson(person);
		if(licenseOptional.isPresent()) {
			return licenseOptional.get();
		} else {
			return null;
		}
	}
	
	public License createLicense(License license) {
		license.setNumber(this.generateLicenseNumber());
		return licenseRepo.save(license);
	}
	
	
	// how to generate license number
	public int generateLicenseNumber() {
		License license = this.licenseRepo.findTopByOrderByNumberDesc();
		if(license == null) {
			return 1;
		} else {
			int previousLicenseNumber = license.getNumber();
			previousLicenseNumber++;
			return (previousLicenseNumber);
		}
	}
}
