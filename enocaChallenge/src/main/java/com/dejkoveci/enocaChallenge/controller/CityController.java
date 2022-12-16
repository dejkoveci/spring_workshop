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

import com.dejkoveci.enocaChallenge.model.City;
import com.dejkoveci.enocaChallenge.service.ICityService;


@RestController
@RequestMapping("/api")
public class CityController {
	
	private ICityService cityService;
	
	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/city")
	public List<City> get(){
		return cityService.getAllCities();
	}
	
	@PostMapping("/city/add")
	public void add(@PathVariable Long countryId,@RequestBody City city) {
		cityService.addCity(countryId, city);
	}
	
	@PutMapping("/city/{cityId}")
	public void update(@RequestBody City city) {
		cityService.updateCity(city);
	}
	
	@DeleteMapping("/city/{cityId}")
	public void delete(@PathVariable Long cityId) {
		cityService.deleteCity(cityId);
	}
	
	@GetMapping("/city/{cityId}")
	public City getById(@PathVariable Long cityId){
		return cityService.getCityById(cityId);
	}

}
