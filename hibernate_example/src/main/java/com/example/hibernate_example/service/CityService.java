package com.example.hibernate_example.service;

import com.example.hibernate_example.model.City;

import java.util.List;

public interface CityService {
    City save(City country);
    List<City> getAll();
    City get(long id);
}