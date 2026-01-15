package com.elcprojects.citymanager.repository;

import com.elcprojects.citymanager.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
