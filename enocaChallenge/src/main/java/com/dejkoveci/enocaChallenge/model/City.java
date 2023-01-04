package com.dejkoveci.enocaChallenge.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "city")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cityId;
	
	@Column(name = "name")
	private String cityName;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "countryId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Country country;

	public City(Long cityId, String cityName, Country country) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.country = country;
	}
	
	public City() {}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
