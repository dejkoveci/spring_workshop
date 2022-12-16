package com.dejkoveci.enocaChallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dejkoveci.enocaChallenge.model.Country;
import com.dejkoveci.enocaChallenge.service.ICountryService;

@RestController
@RequestMapping("/api")
public class CountryController {
	
	private ICountryService countryService;
	
	@Autowired
	public CountryController(ICountryService countryService) {
		this.countryService = countryService;
	}
	
	@GetMapping("/country")
	public List<Country> get(){
		return countryService.getAllCountries();
	}
	
	@PostMapping("/country/add")
	public void add(@RequestBody Country country) {
		countryService.addCountry(country);
	}
	
	@PutMapping("/country/{countryId}")
	public void update(@RequestBody Country country) {
		countryService.updateCountry(country);
	}
	
	@DeleteMapping("/country/{countryId}")
	public void delete(@PathVariable Long countryId) {
		countryService.deleteCountry(countryId);
	}
	
	@GetMapping("/country/{countryId}")
	public Country getById(@PathVariable Long countryId){
		return countryService.getCountryById(countryId);
	}

}

