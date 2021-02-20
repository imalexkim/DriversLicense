package com.codingdojo.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.license.models.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long>{
	List<Person> findAll();
}
