package com.dejkoveci.enocaChallenge.service;

import java.util.List;

import com.dejkoveci.enocaChallenge.model.City;

public interface ICityService {
	List<City> getAllCities();
	void addCity(Long countryId,City city);
	void updateCity(City city);
	void deleteCity(Long cityId);
	City getCityById(Long cityId);
}
