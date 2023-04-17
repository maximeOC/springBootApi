package com.apigouv.examenJava.service;

import com.apigouv.examenJava.model.City;
import com.apigouv.examenJava.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City city) {
        City existingCity = cityRepository.findById(id).orElse(null);
        if (existingCity != null) {
            existingCity.setName(city.getName());
            existingCity.setCode(city.getCode());
            existingCity.setPopulation(city.getPopulation());
            existingCity.setSiren(city.getSiren());
            existingCity.setDepartment(city.getDepartment());
            return cityRepository.save(existingCity);
        }
        return null;
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
