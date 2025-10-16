package com.construccion.software.patient.adapter.in.validators;

import com.construccion.software.patient.application.exceptions.InputsException;
import com.construccion.software.patient.domain.models.enums.Genre;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class SimpleValidator {

    public String stringValidator(String element, String value) throws Exception {
        if (value == null || value.equals("")) {
            throw new InputsException(element + " no puede tener un valor vacio o nulo");
        }
        return value;
    }

    public long longValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            throw new InputsException(element + " debe ser un valor numérico");
        }
    }

    public long phoneValidator(String element, String value) throws Exception {
        stringValidator(element, value);

        try {

            if (value.length() > 11) {
                throw new InputsException(element + " debe contener entre 1 y 10 caracteres");
            }

            return Long.parseLong(value);

        } catch (Exception e) {
            throw new InputsException(element + " debe ser un valor numérico");
        }
    }

    public Genre genreValidator(String element, String value) throws Exception {
        stringValidator(element, value);
        try {
            return Genre.valueOf(value);
        } catch (Exception e) {
            throw new InputsException(element + " no es un rol válido");
        }
    }

    public String addressValidator(String element, String value) throws Exception {
        stringValidator(element, value);

        if (!value.isEmpty() && value.length() < 30) {
            return value;
        }

        throw new InputsException(element + "máximo 30 caracteres");
    }

    public LocalDate dateValidator(String element, String value) throws Exception {
        stringValidator(element, value);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate date = LocalDate.parse(value, formatter);

            if (date.isAfter(LocalDate.now().plusYears(150))) {
                throw new InputsException(element + " máximo 150 años");
            }

            return date;
        } catch (Exception e) {
            throw new InputsException(element + " debe ser una fecha válida en formato dd/MM/yyyy");
        }
    }

    public String emailValidator(String element, String value) throws Exception {

        if (value == null || value.equals("")) {
            return "";
        }

        if (!value.contains("@")) {
            throw new InputsException(element + " debe contener el símbolo @");
        }

        String[] parts = value.split("@");

        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            throw new InputsException(element + " debe tener el formato: usuario@dominio.com");
        }

        String dominio = parts[1];

        if (!dominio.contains(".")) {
            throw new InputsException(element + " debe tener un dominio válido");
        }

        String[] dominioParts = dominio.split("\\.");
        String extension = dominioParts[dominioParts.length - 1];

        if (extension.length() < 2) {
            throw new InputsException(element + " debe tener una extensión de dominio válida");
        }

        return value;
    }
}
