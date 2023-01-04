package com.dejkoveci.enocaChallengeV2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dejkoveci.enocaChallengeV2.dto.CountryDto;
import com.dejkoveci.enocaChallengeV2.service.ICountryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CountryController {
	
	private final ICountryService countryService;
	
	@GetMapping("/country")
	public List<CountryDto> get(){
		return countryService.getAllCountries();
	}
	
	@PostMapping("/country/add")
	public ResponseEntity<CountryDto> add(@RequestBody CountryDto countryDto){
		return new ResponseEntity<>(countryService.addCountry(countryDto), HttpStatus.CREATED);
	}
	
	@PutMapping("/country/{countryId}")
	public ResponseEntity<CountryDto> update(@PathVariable Long countryId, @RequestBody CountryDto countryDto){
		return new ResponseEntity<>(countryService.updateCountry(countryDto, countryId), HttpStatus.OK);
	}
	
	@DeleteMapping("/country/{countryId}")
	public ResponseEntity<String> delete(@PathVariable Long countryId){
		countryService.deleteCountry(countryId);
		return new ResponseEntity<>("Message : Country Deleted Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/country/{countryId}")
	public ResponseEntity<CountryDto> getById(@PathVariable Long countryId){
		return new ResponseEntity<>(countryService.getCountryById(countryId), HttpStatus.OK);
	}

}
