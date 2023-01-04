package com.dejkoveci.enocaChallengeV2.service;

import java.util.List;

import com.dejkoveci.enocaChallengeV2.dto.CityDto;

public interface ICityService {
	
	List<CityDto> getAllCities(Long countryId);
	
	CityDto addCity(CityDto cityDto, Long countryId);
	
	CityDto updateCity(CityDto cityDto, Long cityId);
	
	void deleteCity(Long cityId);
	
	CityDto getCityById(Long cityId);

}
