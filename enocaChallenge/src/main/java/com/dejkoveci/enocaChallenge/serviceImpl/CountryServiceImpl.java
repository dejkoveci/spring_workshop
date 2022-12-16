package com.dejkoveci.enocaChallenge.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dejkoveci.enocaChallenge.model.Country;
import com.dejkoveci.enocaChallenge.repository.ICountryRepository;
import com.dejkoveci.enocaChallenge.service.ICountryService;

@Service
public class CountryServiceImpl implements ICountryService{

	private ICountryRepository countryRepository;
	
	@Autowired
	public CountryServiceImpl(ICountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	@Override
	@Transactional
	public List<Country> getAllCountries() {
		return this.countryRepository.getAllCountries();
	}

	@Override
	@Transactional
	public void addCountry(Country country) {
		this.countryRepository.addCountry(country);
		
	}

	@Override
	@Transactional
	public void updateCountry(Country country) {
		this.countryRepository.updateCountry(country);
		
	}

	@Override
	@Transactional
	public void deleteCountry(Long countryId) {
		this.countryRepository.deleteCountry(countryId);
		
	}

	@Override
	@Transactional
	public Country getCountryById(Long id) {
		return this.countryRepository.getCountryById(id);
	}

}
