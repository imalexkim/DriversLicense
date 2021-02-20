package com.codingdojo.license.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.license.models.License;
import com.codingdojo.license.models.services.LicenseService;

public class LicenseApi {
	private final LicenseService licenseService;
	
	public LicenseApi(LicenseService licenseService) {
		this.licenseService = licenseService;
		
	}
	@RequestMapping("/api/licenes")
	public List<License> index(){
		return licenseService.allLicenses();
	}
    
    @RequestMapping(value="/api/licenses", method=RequestMethod.POST)
    public License create(@RequestParam(value="number") String number, 
    						@RequestParam(value="expirationDate") Date expirationDate,
    						@RequestParam(value="state") String state) {
        License license = new License(number, expirationDate, state);
        return licenseService.createLicense(license);
    }
    
    @RequestMapping("/api/licenses/{id}")
    public License show(@PathVariable("id") Long id) {
        License license = licenseService.findLicense(id);
        return license;
    }
    

    @RequestMapping(value="/api/licenses/{id}", method=RequestMethod.PUT)
    public License update(@PathVariable("id") Long id, 
    		@RequestParam(value="number") String number, 
    		@RequestParam(value="expirationDate") Date expirationDate,
    		@RequestParam(value="state") String state) {
    	License license = licenseService.updateLicense(id, number, expirationDate, state);
    	return license;
    }
    
    
    @RequestMapping(value="/api/licenes/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
       licenseService.deleteLicense(id);
    }

	

}

