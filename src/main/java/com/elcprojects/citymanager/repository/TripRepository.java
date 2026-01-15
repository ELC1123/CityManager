package com.elcprojects.citymanager.repository;

import com.elcprojects.citymanager.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}
