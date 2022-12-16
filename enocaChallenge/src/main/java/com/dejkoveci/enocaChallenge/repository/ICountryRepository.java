package com.dejkoveci.enocaChallenge.repository;

import java.util.List;

import com.dejkoveci.enocaChallenge.model.City;
import com.dejkoveci.enocaChallenge.model.Country;

public interface ICountryRepository {
	List<Country> getAllCountries();
	void addCountry(Country country);
	void updateCountry(Country country);
	void deleteCountry(Long countryId);
	Country getCountryById(Long countryId);
}
