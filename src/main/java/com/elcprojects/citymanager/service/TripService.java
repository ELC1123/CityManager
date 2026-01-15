package com.elcprojects.citymanager.service;

import com.elcprojects.citymanager.domain.City;
import com.elcprojects.citymanager.domain.Trip;
import com.elcprojects.citymanager.repository.CityRepository;
import com.elcprojects.citymanager.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final CityRepository cityRepository;

    public TripService(TripRepository tripRepository, CityRepository cityRepository) {
        this.tripRepository = tripRepository;
        this.cityRepository = cityRepository;
    }

    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    public Trip saveTrip(Trip trip) {
        if(trip.getCity() != null && trip.getCity().getId() != 0) {
            City realCity = cityRepository.findById(trip.getCity().getId()).orElse(null);
            trip.setCity(realCity);
        }
        return tripRepository.save(trip);
    }

    public Trip findTripById(int id) {
        Optional<Trip> result = tripRepository.findById(id);

        Trip theTrip = null;
        if(result.isPresent()) {
            theTrip = result.get();
        }
        else {
            throw new RuntimeException("Could not find Trip ID - " + id);
        }

        return theTrip;
    }

    public void deleteTripById(int id) {
        tripRepository.deleteById(id);
    }
}
