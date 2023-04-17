package com.apigouv.examenJava.controller;

import com.apigouv.examenJava.dto.DepartmentDTO;
import com.apigouv.examenJava.model.City;
import com.apigouv.examenJava.model.Department;
import com.apigouv.examenJava.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        List<DepartmentDTO> departmentDTOs = new ArrayList<>();
        for (Department department : departments) {
            departmentDTOs.add(new DepartmentDTO(
                    department.getName(),
                    department.getCode()
            ));
        }
        return departmentDTOs;
    }

    @GetMapping("/{code}")
    public DepartmentDTO getDepartmentByCode(@PathVariable String code) {
        Department department = departmentService.getDepartmentByCode(code);
        List<String> cityNames = new ArrayList<>();
        for (City city : department.getCities()) {
            cityNames.add(city.getName());
        }
        return new DepartmentDTO(
                department.getName(),
                department.getCode(),
                department.getRegion().getName(),
                department.getCities()
        );
    }
}

