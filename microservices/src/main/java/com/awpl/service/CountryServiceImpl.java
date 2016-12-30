package com.awpl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awpl.data.CountryRepository;
import com.awpl.model.Country;

@Service
@Transactional
public class CountryServiceImpl implements CountryService
{
	@Autowired
	CountryRepository countryRepository;
	/**
	 * @return the countryRepository
	 */
	public CountryRepository getCountryRepository()
	{
		return countryRepository;
	}
	/**
	 * @param countryRepository the countryRepository to set
	 */
	public void setCountryRepository(CountryRepository countryRepository)
	{
		this.countryRepository = countryRepository;
	}
	@Override
	public List<Country> listCountries()
	{
		return countryRepository.findAll();
	}

}
