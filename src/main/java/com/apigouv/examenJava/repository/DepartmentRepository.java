package com.apigouv.examenJava.repository;

import com.apigouv.examenJava.model.Department;
import com.apigouv.examenJava.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByCode(String code);
}
