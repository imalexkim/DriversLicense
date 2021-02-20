package com.codingdojo.license.controllers;

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

import com.codingdojo.license.models.License;
import com.codingdojo.license.models.Person;
import com.codingdojo.license.models.services.LicenseService;
import com.codingdojo.license.models.services.PersonService;


@Controller
public class MainController {
	@Autowired
	private PersonService ps;
	
	@Autowired
	private LicenseService ls;
	
	
	@GetMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person, Model model) {
		List<Person> p = ps.allPersons();
		model.addAttribute("persons", p);
		return "new.jsp";	
	}
	
	@PostMapping("/person/new")
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Person> p = ps.allPersons();
			model.addAttribute("persons", p);
			return "/new.jsp";
		}else {
			ps.createPerson(person);
			return "redirect:/person/new";
		}
		
	}
	
	@GetMapping("/license/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> p = ps.allPersons();
		model.addAttribute("persons", p);
		return "newLicense.jsp";
	}
	
	
	@PostMapping("/license")
	public String create(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Person> p = ps.allPersons();
			model.addAttribute("persons", p);
			return "/newLicense.jsp";
		}else {
			ls.createLicense(license);
			return "redirect:/license/new";
		}
	}
	@GetMapping("/person/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Person person = ps.findPerson(id);
		License license = ls.findLicense(id);
		model.addAttribute("person", person);
		model.addAttribute("license", license);
		return "show.jsp";
	}

}
