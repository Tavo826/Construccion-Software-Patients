package com.construccion.software.patient.domain.ports;

import com.construccion.software.patient.domain.models.Patient;

import java.util.List;

public interface PatientPort {

    List<Patient> findAll() throws Exception;
    Patient findByDocumentId(long documentId);
    Patient save(Patient patient);
    Patient update(Patient patient);
    void delete(long documentId);

}
