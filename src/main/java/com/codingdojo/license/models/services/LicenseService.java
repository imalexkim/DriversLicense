package com.codingdojo.license.models.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.license.models.License;
import com.codingdojo.license.repositories.LicenseRepo;



@Service
public class LicenseService {
	private final LicenseRepo licenseRepo;
	
	public LicenseService(LicenseRepo licenseRepo){
		this.licenseRepo = licenseRepo;	
	}
	  // returns all 
    public List<License> allLicenses() {
        return licenseRepo.findAll();
    }
    
    
    // creates
    public License createLicense(License license) {
    	licenseRepo.save(license);
        Long num = license.getId();
        String str = num.toString();
        int zeros = 6 - str.length();
        for(int i = 0; i < zeros; i++) {
            str = "0" + str;
        }
        license.setNumber(str);
        return licenseRepo.save(license);
        
    }
    // retrieves
    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepo.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
         return null;
        }
    }
     // Updates      
        public License updateLicense (Long id, String number, Date expirationDate, String state) {
        	License  license = findLicense(id);
        	license.setNumber(number);
        	license.setExpirationDate(expirationDate);
        	license.setState(state);
        	return licenseRepo.save(license);	
        }
        
        public void updateLicense(License license) {
        	licenseRepo.save(license);	
        }
        
        //Deletes
        public void deleteLicense(Long id) {
        	licenseRepo.deleteById(id);
        }
	
	


}
