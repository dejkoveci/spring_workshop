package com.dejkoveci.project.hibernateAndJpa.Dal;

import java.util.List;

import org.springframework.data.geo.Circle;

import com.dejkoveci.project.hibernateAndJpa.Entities.City;

public interface ICityDal {
	
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);
	
}
