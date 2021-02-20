package com.codingdojo.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.license.models.License;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long>{
	List<License> findAll();

}
