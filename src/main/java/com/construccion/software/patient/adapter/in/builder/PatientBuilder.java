package com.construccion.software.patient.adapter.in.builder;

import com.construccion.software.patient.adapter.in.validators.PatientValidator;
import com.construccion.software.patient.application.exceptions.InputsException;
import com.construccion.software.patient.domain.models.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientBuilder {

    private final PatientValidator patientValidator;

    public PatientBuilder(PatientValidator patientValidator) {
        this.patientValidator = patientValidator;
    }

    public Patient build(
            String documentId,
            String name,
            String genre,
            String address,
            String phone,
            String email) throws InputsException {

        Patient patient = new Patient();
        patient.setDocumentId(patientValidator.documentValidator(documentId));
        patient.setName(patientValidator.nameValidator(name));
        patient.setGenre(patientValidator.genreValidator(genre));
        patient.setAddress(patientValidator.addressValidator(address));
        patient.setPhone(patientValidator.phoneValidator(phone));
        patient.setEmail(patientValidator.emailValidator(email));

        return patient;
    }

    public long getDocumentId(String documentId) throws InputsException {

        return patientValidator.documentValidator(documentId);
    }
}
