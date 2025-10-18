package com.construccion.software.patient.domain.services;

import com.construccion.software.patient.application.exceptions.BusinessException;
import com.construccion.software.patient.domain.models.Patient;
import com.construccion.software.patient.domain.ports.PatientPort;
import org.springframework.stereotype.Service;

@Service
public class CreatePatient {

    private final PatientPort patientPort;

    public CreatePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public Patient create(Patient patient) throws Exception {

        if (patientPort.findByDocumentId(patient.getDocumentId()) != null) {
            throw new BusinessException("ya existe una persona registrada con esa cédula");
        }

        return patientPort.save(patient);
    }
}
