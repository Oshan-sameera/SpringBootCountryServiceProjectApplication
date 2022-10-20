package com.oshcoding.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oshcoding.beans.Country;
import com.oshcoding.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	public List getAllCountries() {
		List<Country> countries = countryRepository.findAll(); // extranal dependency method so we have top mock it
		
		return countries;
	}

	public Country getCountryById(int id) {
		// return countryRepository.findById(id).get();
		List<Country> countries = countryRepository.findAll();
		Country country = null;

		for (Country con : countries) {
			if (con.getId() == id) {
				country = con;
			}
		}

		return country;
	}

	public Country getCountryByName(String nameName) {
		List<Country> countries = countryRepository.findAll();

		Country country = null;

		for (Country con : countries) {
			if (con.getCountryName().equalsIgnoreCase(nameName)) {
				country = con;
			}
		}

		return country;

	}

	public Country addCountry(Country country) {
		countryRepository.save(country);
		return country;

	}

	public Country updateCountry(Country country) {
		countryRepository.save(country);
		return country;

	}

	public void deleteCountry(Country country) {
		countryRepository.delete(country);
		//return id + " has been deleted";
	}
}
