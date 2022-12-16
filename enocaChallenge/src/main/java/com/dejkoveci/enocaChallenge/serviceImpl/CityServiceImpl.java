package com.dejkoveci.enocaChallenge.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dejkoveci.enocaChallenge.model.City;
import com.dejkoveci.enocaChallenge.repository.ICityRepository;
import com.dejkoveci.enocaChallenge.service.ICityService;

@Service
public class CityServiceImpl implements ICityService{
	
	private ICityRepository cityRepository;
	
	@Autowired
	public CityServiceImpl(ICityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	@Transactional
	public List<City> getAllCities() {
		return this.cityRepository.getAllCities();
	}

	@Override
	@Transactional
	public void addCity(Long countryId, City city) {
		this.cityRepository.addCity(countryId, city);
		
	}

	@Override
	@Transactional
	public void updateCity(City city) {
		this.cityRepository.updateCity(city);
		
	}

	@Override
	@Transactional
	public void deleteCity(Long cityId) {
		this.cityRepository.deleteCity(cityId);
		
	}

	@Override
	@Transactional
	public City getCityById(Long id) {
		return this.cityRepository.getCityById(id);
	}

}
