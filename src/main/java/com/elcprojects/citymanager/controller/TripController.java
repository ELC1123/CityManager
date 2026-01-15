package com.elcprojects.citymanager.controller;

import com.elcprojects.citymanager.domain.Trip;
import com.elcprojects.citymanager.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {
    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public List<Trip> findAll() {
        return tripService.findAll();
    }

    @GetMapping("/{id}")
    public Trip findTripById(@PathVariable int id) {
        return tripService.findTripById(id);
    }

    @PostMapping
    public Trip addTrip(@RequestBody Trip trip) {
        return tripService.saveTrip(trip);
    }

    @PutMapping("/{id}")
    public Trip updateTrip(@PathVariable int id, @RequestBody Trip trip) {
        trip.setId(id);
        return tripService.saveTrip(trip);
    }

    @DeleteMapping("/{id}")
    public String deleteTripById(@PathVariable int id) {
        tripService.deleteTripById(id);
        return "Successfully deleted Trip ID - " + id;
    }
}
