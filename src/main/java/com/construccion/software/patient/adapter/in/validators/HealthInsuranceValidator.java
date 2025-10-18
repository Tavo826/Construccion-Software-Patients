package com.construccion.software.patient.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class HealthInsuranceValidator extends SimpleValidator {

    public String companyNameValidator(String value) throws Exception {
        return stringValidator("nombre de compañía", value);
    }

    public long policyNumberValidator(String value) throws Exception {
        return longValidator("numero de póliza", value);
    }

    public LocalDate policyDateValidator(String value) throws Exception {
        return dateValidator("vigencia de póliza", value);
    }
}
