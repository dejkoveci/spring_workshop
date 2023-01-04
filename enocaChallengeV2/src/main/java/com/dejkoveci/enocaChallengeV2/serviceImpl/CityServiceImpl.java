package com.dejkoveci.enocaChallengeV2.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.dejkoveci.enocaChallengeV2.dto.CityDto;
import com.dejkoveci.enocaChallengeV2.exception.ResourceNotFoundException;
import com.dejkoveci.enocaChallengeV2.model.City;
import com.dejkoveci.enocaChallengeV2.model.Country;
import com.dejkoveci.enocaChallengeV2.repository.ICityRepository;
import com.dejkoveci.enocaChallengeV2.service.ICityService;
import com.dejkoveci.enocaChallengeV2.service.ICountryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CityServiceImpl implements ICityService{
	
	private final ICityRepository cityRepository;
	
	private final ICountryService countryService;
	
	private final ModelMapper modelMapper;

	@Override
	public List<CityDto> getAllCities(Long countryId) {
		List<City> cities = cityRepository.findAllByCountryId(countryId);
		return cities.stream().map(city->modelMapper.map(city, CityDto.class)).collect(Collectors.toList());
	}

	@Override
	public CityDto addCity(CityDto cityDto, Long countryId) {
		City city = modelMapper.map(cityDto, City.class);
		Country country = modelMapper.map(countryService.getCountryById(countryId), Country.class);
		city.setCountry(country);
		cityRepository.save(city);
		return modelMapper.map(city, CityDto.class);
	}

	@Override
	public CityDto updateCity(CityDto cityDto, Long cityId) {
		City city = cityRepository.findById(cityId).orElseThrow(() -> new ResourceNotFoundException("Error : City Not Found"));
		city.setName(cityDto.getName());
		cityRepository.save(city);
		return modelMapper.map(city, CityDto.class);
	}

	@Override
	public void deleteCity(Long cityId) {
		City city = cityRepository.findById(cityId).orElseThrow(() -> new ResourceNotFoundException("Error : City Not Found"));
		cityRepository.delete(city);
	}

	@Override
	public CityDto getCityById(Long cityId) {
		City city = cityRepository.findById(cityId).orElseThrow(() -> new ResourceNotFoundException("Error : City Not Found"));
		return modelMapper.map(city, CityDto.class);
	}

}
