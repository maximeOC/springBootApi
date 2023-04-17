package com.apigouv.examenJava.repository;

import com.apigouv.examenJava.model.PostalCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostalCodeRepository extends JpaRepository<PostalCode, Long> {
}
