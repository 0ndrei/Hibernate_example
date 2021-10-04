package com.example.hibernate_example.service.impl;

import com.example.hibernate_example.exception.ResourceNotFoundException;
import com.example.hibernate_example.model.City;
import com.example.hibernate_example.repository.CityRepository;
import com.example.hibernate_example.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository){
        super();
        this.cityRepository = cityRepository;
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City get(long id) {
        return cityRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Country", "id", id));
    }
}