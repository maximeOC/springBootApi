package com.apigouv.examenJava.service;

import com.apigouv.examenJava.model.Region;
import com.apigouv.examenJava.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Region getRegionById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }

    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }
    public Region getRegionByCode(String code) {
        return regionRepository.findByCode(code).orElse(null);
    }

    public Region updateRegion(Long id, Region region) {
        Region existingRegion = regionRepository.findById(id).orElse(null);
        if (existingRegion != null) {
            existingRegion.setName(region.getName());
            existingRegion.setCode(region.getCode());
            return regionRepository.save(existingRegion);
        }
        return null;
    }

    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }


}