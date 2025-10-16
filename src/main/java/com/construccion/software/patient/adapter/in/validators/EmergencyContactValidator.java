package com.construccion.software.patient.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class EmergencyContactValidator extends SimpleValidator {

    public String nameValidator(String value) throws Exception {
        return stringValidator("nombre de contacto", value);
    }

    public String surnameValidator(String value) throws Exception {
        return stringValidator("apellido de contacto", value);
    }

    public String relationshipValidator(String value) throws Exception {
        return stringValidator("relación de contacto", value);
    }

    public long phoneValidator(String value) throws Exception {
        return phoneValidator("teléfono de contacto", value);
    }
}
