package com.construccion.software.patient.domain.services;

import com.construccion.software.patient.application.exceptions.PatientNotFoundException;
import com.construccion.software.patient.domain.models.Patient;
import com.construccion.software.patient.domain.ports.PatientPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class GetPatient {

    private final PatientPort patientPort;

    public GetPatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public List<Patient> getAllPatient() throws Exception {

        List<Patient> patientList = patientPort.findAll();
        if (patientList.isEmpty()) {
            throw new PatientNotFoundException("no existen pacientes");
        }

        return patientList;
    }

    public Patient getByDocumentId(long documentId) throws Exception {

        Patient patient = patientPort.findByDocumentId(documentId);
        if (patient == null) {
            throw new PatientNotFoundException("No existe un paciente con el documento " + documentId);
        }

        return patient;
    }
}
