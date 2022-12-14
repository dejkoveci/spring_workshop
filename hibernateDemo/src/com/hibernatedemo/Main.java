package com.hibernatedemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		
		//Unit of Work
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
		    
			//HQL --> Hibernate Query Language
			
			/*
			 * List<City> cities = session
			 * .createQuery("from City c where countryCode='TUR'") .getResultList();
			 * 
			 * for(City city:cities) { System.out.println(city.getName()); }
			 */
			
			/*
			 * List<String> countryCodes = session
			 * .createQuery("select c.countryCode from City c GROUP BY countryCode")
			 * .getResultList(); //executeUpdate();
			 * 
			 * for(String countryCode:countryCodes) { System.out.println(countryCode); }
			 */
			
			//Insert
			/*
			 * City city = new City(); city.setName("Düzce 10"); city.setCountryCode("TUR");
			 * city.setDistrict("Karadeniz"); city.setPopulation(100000);
			 * 
			 * session.save(city);
			 */
			
			//Update
			/*
			 * City city = session.get(City.class, 4080);
			 * System.out.println(city.getName()); city.setPopulation(11000);
			 * 
			 * session.save(city);
			 */
			
			//Delete
			City city = session.get(City.class, 4080);
			session.delete(city);
			
			
			
			session.getTransaction().commit();
			System.out.println("Şehir silindi");
		
		} finally {
			factory.close();
		}
		
	}
}
