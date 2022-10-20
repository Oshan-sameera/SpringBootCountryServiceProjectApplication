package com.oshcoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oshcoding.beans.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
