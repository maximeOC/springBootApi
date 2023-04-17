package com.apigouv.examenJava.controller;

import com.apigouv.examenJava.dto.DepartmentDTO;
import com.apigouv.examenJava.dto.RegionDTO;
import com.apigouv.examenJava.model.Department;
import com.apigouv.examenJava.model.Region;
import com.apigouv.examenJava.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("")
    public List<RegionDTO> getAllRegions() {
        List<Region> region = regionService.getAllRegions();
        return region.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{code}")
    public RegionDTO getRegionByCode(@PathVariable String code) {
        Region region = regionService.getRegionByCode(code);
        return convertToDTO(region);
    }

    private RegionDTO convertToDTO(Region region) {
        if (region == null) {
            return null;
        }
        List<DepartmentDTO> departments = region.getDepartments().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new RegionDTO(region.getName(), region.getCode(), departments);
    }

    private DepartmentDTO convertToDTO(Department department) {
        if (department == null) {
            return null;
        }
        return new DepartmentDTO(department.getName(), department.getCode());
    }
}