package com.oshcoding.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.oshcoding.beans.Country;
import com.oshcoding.repository.CountryRepository;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { ServiceMockitoTests.class })
public class ServiceMockitoTests {

	@Mock
	CountryRepository countryRepository;

	@InjectMocks
	CountryService countryService;

	@Test
	@Order(1)
	public void test_getAllCountries() {
		List<Country> myCountries = new ArrayList<>();
		myCountries.add(new Country(1, "Sri Lanak", "Colombo"));
		myCountries.add(new Country(1, "Australia", "Canberra"));

		when(countryRepository.findAll()).thenReturn(myCountries);// Mocking

		assertEquals(2, countryService.getAllCountries().size());

	}

	@Test
	@Order(2)
	public void test_getCountryById() {
		List<Country> myCountries = new ArrayList<>();
		myCountries.add(new Country(1, "Sri Lanak", "Colombo"));
		myCountries.add(new Country(1, "Australia", "Canberra"));

		int countryId = 1;

		when(countryRepository.findAll()).thenReturn(myCountries);
		assertEquals(countryId, countryService.getCountryById(countryId).getId());

	}

	@Test
	@Order(3)
	public void test_getCountryByName() {
		List<Country> myCountries = new ArrayList<>();
		myCountries.add(new Country(1, "Sri Lanka", "Colombo"));
		myCountries.add(new Country(1, "Australia", "Canberra"));

		String countryName = "Sri Lanka";

		when(countryRepository.findAll()).thenReturn(myCountries); // mocking

		assertEquals(countryName, countryService.getCountryByName(countryName).getCountryName());

	}

	@Test
	@Order(4)
	public void test_addCountry() {

		Country country = new Country(1, "Sri Lanka", "Colombo");

		when(countryRepository.save(country)).thenReturn(country);
		assertEquals(country, countryService.addCountry(country));

	}

	@Test
	@Order(5)
	public void test_updateCountry() {
		Country country = new Country(1, "Sri Lanka", "Colombo");

		when(countryRepository.save(country)).thenReturn(country);

		assertEquals(country, countryService.updateCountry(country));

	}

	@Test
	@Order(6)
	public void test_deleteCountry() {
		Country country = new Country(1, "Sri Lanka", "Colombo");
		countryService.deleteCountry(country);
		verify(countryRepository, times(1)).delete(country);

	}

}
