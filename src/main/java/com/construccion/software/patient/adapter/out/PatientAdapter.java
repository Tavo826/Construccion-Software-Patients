package com.construccion.software.patient.adapter.out;

import com.construccion.software.patient.domain.models.Patient;
import com.construccion.software.patient.domain.ports.PatientPort;
import com.construccion.software.patient.infrastructure.persistence.entities.EmergencyContactEntity;
import com.construccion.software.patient.infrastructure.persistence.entities.HealthInsuranceEntity;
import com.construccion.software.patient.infrastructure.persistence.entities.PatientEntity;
import com.construccion.software.patient.infrastructure.persistence.mapper.PatientMapper;
import com.construccion.software.patient.infrastructure.persistence.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientAdapter implements PatientPort {

    private final PatientRepository patientRepository;

    public PatientAdapter(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() throws Exception {

        List<PatientEntity> patientList = patientRepository.findAll();

        return PatientMapper.toDomain(patientList);
    }

    @Override
    public Patient findByDocumentId(long documentId) {

        Optional<PatientEntity> patientOptional = patientRepository.findById(documentId);

        if (patientOptional.isPresent()) {

            PatientEntity patientEntity = patientOptional.get();

            return PatientMapper.toDomain(patientEntity);
        }

        return null;
    }

    @Override
    public Patient save(Patient patient) {

        PatientEntity patientEntity = patientRepository.save(PatientMapper.toEntity(patient));

        return PatientMapper.toDomain(patientEntity);
    }

    @Override
    public Patient update(Patient patient) {

        Optional<PatientEntity> patientOptional = patientRepository.findById(patient.getDocumentId());

        if (patientOptional.isPresent()) {
            PatientEntity patientEntity = patientOptional.get();

            EmergencyContactEntity emergencyContactEntity = new EmergencyContactEntity();
            emergencyContactEntity.setName(patient.getEmergencyContact().getName());
            emergencyContactEntity.setSurname(patient.getEmergencyContact().getSurname());
            emergencyContactEntity.setRelationship(patient.getEmergencyContact().getRelationship());
            emergencyContactEntity.setPhone(patient.getEmergencyContact().getPhone());

            HealthInsuranceEntity healthInsuranceEntity = new HealthInsuranceEntity();
            healthInsuranceEntity.setCompanyName(patient.getHealthInsurance().getCompanyName());
            healthInsuranceEntity.setPolicyNumber(patient.getHealthInsurance().getPolicyNumber());
            healthInsuranceEntity.setActive(patient.getHealthInsurance().isActive());
            healthInsuranceEntity.setPolicyValidity(patient.getHealthInsurance().getPolicyValidity());

            patientEntity.setName(patient.getName());
            patientEntity.setSurname(patient.getSurname());
            patientEntity.setBirthDate(patient.getBirthDate());
            patientEntity.setGender(patient.getGender().name());
            patientEntity.setAddress(patient.getAddress());
            patientEntity.setPhone(patient.getPhone());
            patientEntity.setEmail(patient.getEmail());
            patientEntity.setEmergencyContact(emergencyContactEntity);
            patientEntity.setHealthInsurance(healthInsuranceEntity);

            PatientEntity updatedPatient = patientRepository.save(patientEntity);

            return PatientMapper.toDomain(updatedPatient);
        }

        return null;
    }

    @Override
    public void delete(long documentId) {

        patientRepository.deleteById(documentId);
    }
}
