package com.dejkoveci.enocaChallengeV2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dejkoveci.enocaChallengeV2.model.City;

public interface ICityRepository extends JpaRepository<City, Long>{

	List<City> findAllByCountryId(Long countryId);
	
}
