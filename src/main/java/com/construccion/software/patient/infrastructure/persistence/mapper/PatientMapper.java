package com.construccion.software.patient.infrastructure.persistence.mapper;

import com.construccion.software.patient.domain.models.Patient;
import com.construccion.software.patient.domain.models.enums.Genre;
import com.construccion.software.patient.infrastructure.persistence.entities.PatientEntity;

public class PatientMapper {

    public static PatientEntity toEntity(Patient patient) {

        if (patient == null) {
            return null;
        }

        PatientEntity entity = new PatientEntity();
        entity.setDocumentId(patient.getDocumentId());
        entity.setName(patient.getName());
        entity.setGenre(patient.getGenre().name());
        entity.setAddress(patient.getAddress());
        entity.setPhone(patient.getPhone());
        entity.setEmail(patient.getEmail());

        return entity;
    }

    public static Patient toDomain(PatientEntity entity) {

        if (entity == null) {
            return null;
        }

        Patient patient = new Patient();
        patient.setDocumentId(entity.getDocumentId());
        patient.setName(entity.getName());
        patient.setGenre(Genre.valueOf(entity.getGenre()));
        patient.setAddress(entity.getAddress());
        patient.setPhone(entity.getPhone());
        patient.setEmail(entity.getEmail());

        return patient;
    }
}
