package com.construccion.software.patient.infrastructure.persistence.repository;

import com.construccion.software.patient.infrastructure.persistence.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
