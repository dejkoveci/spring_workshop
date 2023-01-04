package com.dejkoveci.enocaChallengeV2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dejkoveci.enocaChallengeV2.model.Country;

public interface ICountryRepository extends JpaRepository<Country, Long>{

}
