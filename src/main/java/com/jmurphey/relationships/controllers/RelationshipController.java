package com.jmurphey.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jmurphey.relationships.models.License;
import com.jmurphey.relationships.models.Person;
import com.jmurphey.relationships.services.LicenseService;
import com.jmurphey.relationships.services.PersonService;

@Controller
@RequestMapping("/")
public class RelationshipController {
	
	@Autowired
	LicenseService licenseService;
	
	@Autowired
	PersonService personService;
	
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("persons", personService.getAllPersons());
		return "index.jsp";
	}
	
	
	@GetMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "new.jsp";
	}
	
	
	@PostMapping("/person/new")
	public String create(@Valid @ModelAttribute("person")Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/";
		}
	}
	
	
	
//	@GetMapping("/license")
//	public String indexLicense(@ModelAttribute("person")Person person, Model model) {
//		List<Person> persons = personService.getAllPersons();
//		model.addAttribute("persons", persons);
//		return "license.jsp";
//	}
	
	
	
	@GetMapping("/license")
	public String newLicense(Model model, @ModelAttribute("license") License license) {
		model.addAttribute("people", personService.getPeopleWithNoLicense());
		return "license.jsp";
	}
	
	@PostMapping("/license/new")
	public String newLicense(@Valid @ModelAttribute("license")License license, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("people", personService.getPeopleWithNoLicense());
			return "license.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", personService.getOnePerson(id));
		return "show.jsp";
	}
	
}
