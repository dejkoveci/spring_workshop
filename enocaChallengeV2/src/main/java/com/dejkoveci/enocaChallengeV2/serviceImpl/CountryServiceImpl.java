package com.dejkoveci.enocaChallengeV2.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.dejkoveci.enocaChallengeV2.dto.CountryDto;
import com.dejkoveci.enocaChallengeV2.exception.ResourceNotFoundException;
import com.dejkoveci.enocaChallengeV2.model.Country;
import com.dejkoveci.enocaChallengeV2.repository.ICountryRepository;
import com.dejkoveci.enocaChallengeV2.service.ICountryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CountryServiceImpl implements ICountryService{
	
	private final ICountryRepository countryRepository;
	
	private final ModelMapper modelMapper;

	@Override
	public List<CountryDto> getAllCountries() {
		List<Country> countries = countryRepository.findAll();
		return countries.stream().map(country->modelMapper.map(country, CountryDto.class)).collect(Collectors.toList());
	}

	@Override
	public CountryDto addCountry(CountryDto countryDto) {
		Country country = modelMapper.map(countryDto, Country.class);
		countryRepository.save(country);
		return modelMapper.map(country, CountryDto.class);
	}

	@Override
	public CountryDto updateCountry(CountryDto countryDto, Long countryId) {
		Country country = countryRepository.findById(countryId).orElseThrow(() -> new ResourceNotFoundException("Error : Country Not Found"));
		country.setName(countryDto.getName());
		country.setRegion(countryDto.getRegion());
		countryRepository.save(country);
		return modelMapper.map(country, CountryDto.class);
	}

	@Override
	public void deleteCountry(Long countryId) {
		Country country = countryRepository.findById(countryId).orElseThrow(() -> new ResourceNotFoundException("Error : Country Not Found"));
		countryRepository.delete(country);
	}

	@Override
	public CountryDto getCountryById(Long countryId) {
		Country country = countryRepository.findById(countryId).orElseThrow(() -> new ResourceNotFoundException("Error : Country Not Found"));
		return modelMapper.map(country, CountryDto.class);
	}

}
