package com.sboot.sbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sboot.sbootcrud.dto.PatientDTO;

@Component
public interface PatientRepository extends JpaRepository<PatientDTO, Integer> {

}
