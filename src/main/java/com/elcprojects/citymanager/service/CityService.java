package com.elcprojects.citymanager.service;

import com.elcprojects.citymanager.domain.City;
import com.elcprojects.citymanager.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    public City findCityById(int id) {
        Optional<City> result = cityRepository.findById(id);

        City theCity = null;
        if(result.isPresent()) {
            theCity = result.get();
        }
        else {
            throw new RuntimeException("Did not find City ID - " + id);
        }

        return theCity;
    }

    public void deleteCityById(int id) {
        cityRepository.deleteById(id);
    }
}
