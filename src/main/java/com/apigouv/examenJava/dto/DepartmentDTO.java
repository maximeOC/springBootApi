package com.apigouv.examenJava.dto;

import com.apigouv.examenJava.model.City;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Id;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DepartmentDTO {

    @Id
    private Long id;
    private String name;

    private String code;

    private String regionName;
    

    public DepartmentDTO(String name, String code) {
    }

    public DepartmentDTO(String name, String code, String name1, List<City> cities) {
    }
}
