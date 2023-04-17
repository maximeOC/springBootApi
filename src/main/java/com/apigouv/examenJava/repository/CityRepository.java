package com.apigouv.examenJava.repository;

import com.apigouv.examenJava.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
