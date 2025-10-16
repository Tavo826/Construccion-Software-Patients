package com.construccion.software.patient.adapter.in.validators;

import com.construccion.software.patient.application.exceptions.InputsException;
import com.construccion.software.patient.domain.models.enums.Genre;
import org.springframework.stereotype.Component;

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

    public Genre genreValidator(String value) throws Exception {
        return genreValidator("el género de la persona", value);
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
