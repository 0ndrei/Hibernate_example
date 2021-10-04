package com.example.hibernate_example.controller;

import com.example.hibernate_example.model.City;
import com.example.hibernate_example.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService){
        super();
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<City> create(@RequestBody City city){
        return new ResponseEntity<City>(cityService.save(city), HttpStatus.CREATED);
    }

    @GetMapping
    public List<City> get(){
        return cityService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<City> get(@PathVariable("id") long id){
        return new ResponseEntity<City>(cityService.get(id), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<City> update(@PathVariable("id") long id, @RequestBody City city) {
        return new ResponseEntity<City>(cityService.update(city, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        cityService.delete(id);
        return new ResponseEntity<String>("City is deleted", HttpStatus.OK);
    }
}
