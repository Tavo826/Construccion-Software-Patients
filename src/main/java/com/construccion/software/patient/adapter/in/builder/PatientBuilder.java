package com.construccion.software.patient.adapter.in.builder;

import com.construccion.software.patient.adapter.in.rest.request.PatientRequest;
import com.construccion.software.patient.adapter.in.validators.EmergencyContactValidator;
import com.construccion.software.patient.adapter.in.validators.HealthInsuranceValidator;
import com.construccion.software.patient.adapter.in.validators.PatientValidator;
import com.construccion.software.patient.application.exceptions.InputsException;
import com.construccion.software.patient.domain.models.EmergencyContact;
import com.construccion.software.patient.domain.models.HealthInsurance;
import com.construccion.software.patient.domain.models.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientBuilder {

    private final PatientValidator patientValidator;
    private final EmergencyContactValidator emergencyContactValidator;
    private final HealthInsuranceValidator healthInsuranceValidator;

    public PatientBuilder(
            PatientValidator patientValidator,
            EmergencyContactValidator emergencyContactValidator,
            HealthInsuranceValidator healthInsuranceValidator) {
        this.patientValidator = patientValidator;
        this.emergencyContactValidator = emergencyContactValidator;
        this.healthInsuranceValidator = healthInsuranceValidator;
    }

    public Patient build(PatientRequest request) throws Exception {

        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setName(emergencyContactValidator.nameValidator(request.getEmergencyContact().getName()));
        emergencyContact.setSurname(emergencyContactValidator.surnameValidator(request.getEmergencyContact().getSurname()));
        emergencyContact.setRelationship(emergencyContactValidator.relationshipValidator(request.getEmergencyContact().getRelationship()));
        emergencyContact.setPhone(emergencyContactValidator.phoneValidator(request.getEmergencyContact().getPhone()));

        HealthInsurance healthInsurance = new HealthInsurance();
        healthInsurance.setCompanyName(healthInsuranceValidator.companyNameValidator(request.getHealthInsurance().getCompanyName()));
        healthInsurance.setPolicyNumber(healthInsuranceValidator.policyNumberValidator(request.getHealthInsurance().getPolicyNumber()));
        healthInsurance.setActive(request.getHealthInsurance().isActive());
        healthInsurance.setPolicyValidity(healthInsuranceValidator.policyDateValidator(request.getHealthInsurance().getPolicyValidity()));

        Patient patient = new Patient();
        patient.setDocumentId(patientValidator.documentValidator(request.getDocumentId()));
        patient.setName(patientValidator.nameValidator(request.getName()));
        patient.setSurname(patientValidator.surnameValidator(request.getSurname()));
        patient.setGenre(patientValidator.genreValidator(request.getGenre()));
        patient.setAddress(patientValidator.addressValidator(request.getAddress()));
        patient.setPhone(patientValidator.phoneValidator(request.getPhone()));
        patient.setEmail(patientValidator.emailValidator(request.getEmail()));
        patient.setEmergencyContact(emergencyContact);
        patient.setHealthInsurance(healthInsurance);

        return patient;
    }

    public long getDocumentId(String documentId) throws Exception {

        return patientValidator.documentValidator(documentId);
    }
}
