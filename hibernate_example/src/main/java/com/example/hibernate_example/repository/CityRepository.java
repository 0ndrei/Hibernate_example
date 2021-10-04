package com.example.hibernate_example.repository;

import com.example.hibernate_example.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}