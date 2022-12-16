package com.dejkoveci.enocaChallenge.dal;

import java.util.List;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dejkoveci.enocaChallenge.model.City;
import com.dejkoveci.enocaChallenge.model.Country;
import com.dejkoveci.enocaChallenge.repository.ICityRepository;
import com.dejkoveci.enocaChallenge.serviceImpl.CountryServiceImpl;

import jakarta.persistence.EntityManager;

@Repository
public class CityDal implements ICityRepository{
	
	private EntityManager entityManager;
	
	private CountryDal countryDal;
	
	
	@Autowired
	public CityDal(EntityManager entityManager,CountryDal countryDal) {
		this.entityManager = entityManager;
		this.countryDal = countryDal;
	}

	@Override
	@Transactional
	public List<City> getAllCities() {
		Session session = entityManager.unwrap(Session.class);
		List<City> cities = session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	@Override
	public void addCity(Long countryId, City city) {
		Session session = entityManager.unwrap(Session.class);
		Country country = countryDal.getCountryById(countryId);
		city.setCountry(country);
		session.saveOrUpdate(city);
	}

	@Override
	public void updateCity(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}

	@Override
	public void deleteCity(Long cityId) {
		Session session = entityManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class, cityId);
		session.delete(cityToDelete);
		
	}

	@Override
	public City getCityById(Long cityId) {
		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class, cityId);
		return city;
	}

}
