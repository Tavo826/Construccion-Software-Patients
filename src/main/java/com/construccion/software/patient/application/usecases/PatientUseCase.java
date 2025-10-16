package com.construccion.software.patient.application.usecases;

import com.construccion.software.patient.domain.models.Patient;
import com.construccion.software.patient.domain.services.CreatePatient;
import com.construccion.software.patient.domain.services.DeletePatient;
import com.construccion.software.patient.domain.services.GetPatient;
import com.construccion.software.patient.domain.services.UpdatePatient;
import org.springframework.stereotype.Service;

@Service
public class PatientUseCase {

    private final GetPatient getPatient;
    private final CreatePatient createPatient;
    private final UpdatePatient updatePatient;
    private final DeletePatient deletePatient;

    public PatientUseCase(
            GetPatient getPatient,
            CreatePatient createPatient,
            UpdatePatient updatePatient,
            DeletePatient deletePatient) {
        this.getPatient = getPatient;
        this.createPatient = createPatient;
        this.updatePatient = updatePatient;
        this.deletePatient = deletePatient;
    }

    public Patient getPatientByDocumentId(long documentId) throws Exception {

        return getPatient.getByDocumentId(documentId);
    }

    public Patient createPatient(Patient patient) throws Exception {

        return createPatient.create(patient);
    }

    public Patient updatePatient(Patient patient) throws Exception {

        return updatePatient.update(patient);
    }

    public void deletePatient(long documentId) throws Exception {

        deletePatient.delete(documentId);
    }

}
