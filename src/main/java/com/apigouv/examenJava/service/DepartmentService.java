package com.apigouv.examenJava.service;

import com.apigouv.examenJava.model.Department;
import com.apigouv.examenJava.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public Department getDepartmentByCode(String code){
        return departmentRepository.findByCode(code).orElse(null);
    }

    public Department updateDepartment(Long id, Department department) {
        Department existingDepartment = departmentRepository.findById(id).orElse(null);
        if (existingDepartment != null) {
            existingDepartment.setName(department.getName());
            existingDepartment.setCode(department.getCode());
            existingDepartment.setRegion(department.getRegion());
            return departmentRepository.save(existingDepartment);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
