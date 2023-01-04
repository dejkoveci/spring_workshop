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

import com.dejkoveci.enocaChallengeV2.dto.CityDto;
import com.dejkoveci.enocaChallengeV2.service.ICityService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CityController {
	
	private final ICityService cityService;
	
	@GetMapping("/city/all/{countryId}")
	public List<CityDto> get(@PathVariable Long countryId){
		return cityService.getAllCities(countryId);
	}
	
	@PostMapping("/city/add/{countryId}")
	public ResponseEntity<CityDto> add(@PathVariable Long countryId, @RequestBody CityDto cityDto){
		return new ResponseEntity<>(cityService.addCity(cityDto, countryId), HttpStatus.CREATED);
	}
	
	@PutMapping("/city/{cityId}")
	public ResponseEntity<CityDto> update(@PathVariable Long cityId, @RequestBody CityDto cityDto){
		return new ResponseEntity<>(cityService.updateCity(cityDto, cityId), HttpStatus.OK);
	}
	
	@DeleteMapping("/city/{cityId}")
	public ResponseEntity<String> delete(@PathVariable Long cityId){
		cityService.deleteCity(cityId);
		return new ResponseEntity<>("Message : City Deleted Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/city/{cityId}")
	public ResponseEntity<CityDto> getById(@PathVariable Long cityId){
		return new ResponseEntity<>(cityService.getCityById(cityId), HttpStatus.OK);
	}

}
