package com.elcprojects.citymanager.controller;

import com.elcprojects.citymanager.domain.City;
import com.elcprojects.citymanager.service.CityService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> findAll() {
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public City findCityById(@PathVariable int id) {
        return cityService.findCityById(id);
    }

    @PostMapping
    public City addCity(@Valid @RequestBody City city) {
        return cityService.saveCity(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable int id, @Valid @RequestBody City city) {
        city.setId(id);
        return cityService.saveCity(city);
    }

    @DeleteMapping("/{id}")
    public String deleteCityById(@PathVariable int id) {
        cityService.deleteCityById(id);
        return "Successfully deleted City ID - " + id;
    }
}
