package com.dejkoveci.enocaChallenge.repository;

import java.util.List;

import com.dejkoveci.enocaChallenge.model.City;
import com.dejkoveci.enocaChallenge.model.Country;

public interface ICityRepository {
	List<City> getAllCities();
	void addCity(Long countryId,City city);
	void updateCity(City city);
	void deleteCity(Long cityId);
	City getCityById(Long cityId);
}
