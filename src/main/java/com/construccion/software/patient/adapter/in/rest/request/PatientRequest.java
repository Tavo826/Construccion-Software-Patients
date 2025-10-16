package com.construccion.software.patient.adapter.in.rest.request;

import com.construccion.software.patient.domain.models.enums.Genre;

public class PatientRequest {

    private String documentId;
    private String name;
    private String surname;
    private String genre;
    private String address;
    private String phone;
    private String email;
    private EmergencyContactRequest emergencyContact;
    private HealthInsuranceRequest healthInsurance;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmergencyContactRequest getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContactRequest emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public HealthInsuranceRequest getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(HealthInsuranceRequest healthInsuranceRequest) {
        this.healthInsurance = healthInsuranceRequest;
    }
}
