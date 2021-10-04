package com.example.hibernate_example.service.impl;

import com.example.hibernate_example.exception.ResourceNotFoundException;
import com.example.hibernate_example.model.Country;
import com.example.hibernate_example.repository.CountryRepository;
import com.example.hibernate_example.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository;

    public  CountryServiceImpl(CountryRepository countryRepository){
        super();
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country get(long id) {
        return countryRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Country", "id", id));
    }

    @Override
    public Country updateCountry(Country country, long id, Country code) {

        Country exitingCountry = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country", "id", id));
        exitingCountry.setName(country.getName());
        exitingCountry.setId(country.getId());
        exitingCountry.setCode(country.getCode());
        countryRepository.save(exitingCountry);
        return null;
    }

    @Override
    public void delete(long id) {
        countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country", "id", id));
        countryRepository.deleteById(id);
    }

}
