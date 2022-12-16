package com.dejkoveci.enocaChallenge.dal;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dejkoveci.enocaChallenge.model.City;
import com.dejkoveci.enocaChallenge.model.Country;
import com.dejkoveci.enocaChallenge.repository.ICountryRepository;

import jakarta.persistence.EntityManager;

@Repository
public class CountryDal implements ICountryRepository{
	
	private EntityManager entityManager;
	
	@Autowired
	public CountryDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Country> getAllCountries() {
		Session session = entityManager.unwrap(Session.class);
		List<Country> countries = session.createQuery("from Country",Country.class).getResultList();
		return countries;
	}

	@Override
	public void addCountry(Country country) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(country);
		
	}

	@Override
	public void updateCountry(Country country) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(country);

	}

	@Override
	public void deleteCountry(Long countryId) {
		Session session = entityManager.unwrap(Session.class);
		Country countryToDelete = session.get(Country.class, countryId);
		session.delete(countryToDelete);
		
	}

	@Override
	public Country getCountryById(Long countryId) {
		Session session = entityManager.unwrap(Session.class);
		Country country = session.get(Country.class, countryId);
		return country;
	}

}
