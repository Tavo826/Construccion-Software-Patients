package com.construccion.software.patient.infrastructure.persistence.mapper;

import com.construccion.software.patient.domain.models.EmergencyContact;
import com.construccion.software.patient.domain.models.HealthInsurance;
import com.construccion.software.patient.domain.models.Patient;
import com.construccion.software.patient.domain.models.enums.Genre;
import com.construccion.software.patient.infrastructure.persistence.entities.EmergencyContactEntity;
import com.construccion.software.patient.infrastructure.persistence.entities.HealthInsuranceEntity;
import com.construccion.software.patient.infrastructure.persistence.entities.PatientEntity;

public class PatientMapper {

    public static PatientEntity toEntity(Patient patient) {

        if (patient == null) {
            return null;
        }

        PatientEntity entity = new PatientEntity();
        entity.setDocumentId(patient.getDocumentId());
        entity.setName(patient.getName());
        entity.setSurname(patient.getSurname());
        entity.setGenre(patient.getGenre().name());
        entity.setAddress(patient.getAddress());
        entity.setPhone(patient.getPhone());
        entity.setEmail(patient.getEmail());
        entity.setEmergencyContact(toEntity(patient.getEmergencyContact()));
        entity.setHealthInsurance(toEntity(patient.getHealthInsurance()));

        return entity;
    }

    private static EmergencyContactEntity toEntity(EmergencyContact emergencyContact) {

        if (emergencyContact == null) {
            return null;
        }

        EmergencyContactEntity entity = new EmergencyContactEntity();
        entity.setName(emergencyContact.getName());
        entity.setSurname(emergencyContact.getSurname());
        entity.setRelationship(emergencyContact.getRelationship());
        entity.setPhone(emergencyContact.getPhone());

        return entity;
    }

    private static HealthInsuranceEntity toEntity(HealthInsurance healthInsurance) {

        if (healthInsurance == null) {
            return null;
        }

        HealthInsuranceEntity entity = new HealthInsuranceEntity();
        entity.setCompanyName(healthInsurance.getCompanyName());
        entity.setPolicyNumber(healthInsurance.getPolicyNumber());
        entity.setActive(healthInsurance.isActive());
        entity.setPolicyValidity(healthInsurance.getPolicyValidity());

        return entity;
    }

    public static Patient toDomain(PatientEntity entity) {

        if (entity == null) {
            return null;
        }

        Patient patient = new Patient();
        patient.setDocumentId(entity.getDocumentId());
        patient.setName(entity.getName());
        patient.setSurname(entity.getSurname());
        patient.setGenre(Genre.valueOf(entity.getGenre()));
        patient.setAddress(entity.getAddress());
        patient.setPhone(entity.getPhone());
        patient.setEmail(entity.getEmail());
        patient.setEmergencyContact(toDomain(entity.getEmergencyContact()));
        patient.setHealthInsurance(toDomain(entity.getHealthInsurance()));

        return patient;
    }

    private static EmergencyContact toDomain(EmergencyContactEntity entity) {

        if (entity == null) {
            return null;
        }

        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setName(entity.getName());
        emergencyContact.setSurname(entity.getSurname());
        emergencyContact.setRelationship(entity.getRelationship());
        emergencyContact.setPhone(entity.getPhone());

        return emergencyContact;
    }

    private static HealthInsurance toDomain(HealthInsuranceEntity entity) {

        if (entity == null) {
            return null;
        }

        HealthInsurance healthInsurance = new HealthInsurance();
        healthInsurance.setCompanyName(entity.getCompanyName());
        healthInsurance.setPolicyNumber(entity.getPolicyNumber());
        healthInsurance.setActive(entity.isActive());
        healthInsurance.setPolicyValidity(entity.getPolicyValidity());

        return healthInsurance;
    }
}
