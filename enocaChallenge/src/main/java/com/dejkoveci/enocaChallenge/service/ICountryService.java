package com.dejkoveci.enocaChallenge.service;

import java.util.List;

import com.dejkoveci.enocaChallenge.model.City;
import com.dejkoveci.enocaChallenge.model.Country;

public interface ICountryService {
	List<Country> getAllCountries();
	void addCountry(Country country);
	void updateCountry(Country country);
	void deleteCountry(Long countryId);
	Country getCountryById(Long countryId);
}
