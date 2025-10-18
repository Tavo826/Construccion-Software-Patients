package com.construccion.software.patient.domain.services;

import com.construccion.software.patient.application.exceptions.BusinessException;
import com.construccion.software.patient.domain.models.Patient;
import com.construccion.software.patient.domain.ports.PatientPort;
import org.springframework.stereotype.Service;

@Service
public class DeletePatient {

    private final PatientPort patientPort;

    public DeletePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void delete(long documentId) throws Exception {

        if (patientPort.findByDocumentId(documentId) == null) {
            throw new BusinessException("No existe un paciente con el documento " + documentId);
        }

        patientPort.delete(documentId);
    }
}
