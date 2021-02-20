package com.codingdojo.license.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.license.models.Person;
import com.codingdojo.license.repositories.PersonRepo;

@Service
public class PersonService {
	private final PersonRepo personRepo;
	
	public PersonService(PersonRepo personRepo){
		this.personRepo = personRepo;
		
	}
	  // returns all 
    public List<Person> allPersons() {
        return personRepo.findAll();
    }
    
    
    // creates
    public Person createPerson(Person person) {
        return personRepo.save(person);
    }
    // retrieves
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepo.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
         return null;
        }
    }
     // Updates  
        public Person updatePerson (Long id, String firstName, String lastName) {
        	Person  person = findPerson(id);
        	person.setFirstName(firstName);
        	person.setLastName(lastName);
        	return personRepo.save(person);	
        }
        
        public void updatePerson(Person person) {
        	personRepo.save(person);	
        }
        
        //Deletes
        public void deletePerson(Long id) {
        	personRepo.deleteById(id);
        }
	
	

	
	
	
	
}
