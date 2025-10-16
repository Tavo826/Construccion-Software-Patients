package com.construccion.software.patient.domain.services;

import com.construccion.software.patient.application.exceptions.PatientNotFoundException;
import com.construccion.software.patient.domain.models.Patient;
import com.construccion.software.patient.domain.ports.PatientPort;
import org.springframework.stereotype.Service;

@Service
public class UpdatePatient {

    private final PatientPort patientPort;

    public UpdatePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public Patient update(Patient patient) throws Exception {

        Patient updatedPatient = patientPort.update(patient);
        if (updatedPatient == null) {
            throw new PatientNotFoundException("No existe un paciente con el documento " + patient.getDocumentId());
        }

        return updatedPatient;
    }
}
