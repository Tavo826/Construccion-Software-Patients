package com.construccion.software.patient.adapter.out;

import com.construccion.software.patient.domain.models.Patient;
import com.construccion.software.patient.domain.ports.PatientPort;
import com.construccion.software.patient.infrastructure.persistence.entities.PatientEntity;
import com.construccion.software.patient.infrastructure.persistence.mapper.PatientMapper;
import com.construccion.software.patient.infrastructure.persistence.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientAdapter implements PatientPort {

    private final PatientRepository patientRepository;

    public PatientAdapter(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
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
    public Patient update(Patient employee) {

        Optional<PatientEntity> patientOptional = patientRepository.findById(employee.getDocumentId());

        if (patientOptional.isPresent()) {
            PatientEntity patientEntity = patientOptional.get();

            patientEntity.setName(employee.getName());
            patientEntity.setGenre(employee.getGenre().name());
            patientEntity.setAddress(employee.getAddress());
            patientEntity.setPhone(employee.getPhone());
            patientEntity.setEmail(employee.getEmail());

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
