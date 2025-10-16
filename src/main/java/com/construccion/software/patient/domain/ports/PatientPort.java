package com.construccion.software.patient.domain.ports;

import com.construccion.software.patient.domain.models.Patient;

public interface PatientPort {

    public Patient findByDocumentId(long documentId);
    public Patient save(Patient patient);
    public Patient update(Patient patient);
    public void delete(long documentId);

}
