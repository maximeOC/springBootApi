package com.apigouv.examenJava.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RegionDTO {
    private String name;
    private String code;
    private List<DepartmentDTO> department;

    public RegionDTO(String name, String code, List<DepartmentDTO> departments) {
        this.name = name;
        this.code = code;
        this.department = departments;
    }
}
