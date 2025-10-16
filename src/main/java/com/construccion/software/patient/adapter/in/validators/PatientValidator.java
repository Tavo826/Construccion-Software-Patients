package com.construccion.software.patient.adapter.in.validators;

import com.construccion.software.patient.application.exceptions.InputsException;
import com.construccion.software.patient.domain.models.enums.Genre;
import org.springframework.stereotype.Component;

@Component
public class PatientValidator extends SimpleValidator {

    public long documentValidator(String value) throws InputsException {
        return longValidator("el documento de la persona", value);
    }

    public String nameValidator(String value) throws InputsException {
        return stringValidator("nombre de la persona", value);
    }

    public Genre genreValidator(String value) throws InputsException {
        return genreValidator("el género de la persona", value);
    }

    public String addressValidator(String value) throws InputsException {
        return addressValidator("dirección", value);
    }

    public String phoneValidator(String value) throws InputsException {
        return phoneValidator("teléfono", value);
    }

    public String emailValidator(String value) throws InputsException {
        return emailValidator("email", value);
    }
}
