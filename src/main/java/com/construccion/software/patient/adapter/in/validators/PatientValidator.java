package com.construccion.software.patient.adapter.in.validators;

import com.construccion.software.patient.domain.models.enums.Gender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PatientValidator extends SimpleValidator {

    public long documentValidator(String value) throws Exception {
        return longValidator("el documento de la persona", value);
    }

    public String nameValidator(String value) throws Exception {
        return stringValidator("nombre de la persona", value);
    }

    public String surnameValidator(String value) throws Exception {
        return stringValidator("apellido de la persona", value);
    }

    public LocalDate dateValidator(String value) throws Exception {
        return dateValidator("fecha de nacimiento", value);
    }

    public Gender genderValidator(String value) throws Exception {
        return genderValidator("el género de la persona", value);
    }

    public String addressValidator(String value) throws Exception {
        return addressValidator("dirección", value);
    }

    public long phoneValidator(String value) throws Exception {
        return phoneValidator("teléfono", value);
    }

    public String emailValidator(String value) throws Exception {
        return emailValidator("email", value);
    }
}
