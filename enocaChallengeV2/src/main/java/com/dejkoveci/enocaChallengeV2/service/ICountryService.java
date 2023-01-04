package com.dejkoveci.enocaChallengeV2.service;

import java.util.List;

import com.dejkoveci.enocaChallengeV2.dto.CountryDto;

public interface ICountryService {
	
	List<CountryDto> getAllCountries();
	
	CountryDto addCountry(CountryDto countryDto);
	
	CountryDto updateCountry(CountryDto countryDto, Long countryId);
	
	void deleteCountry(Long countryId);
	
	CountryDto getCountryById(Long countryId);
	
}
