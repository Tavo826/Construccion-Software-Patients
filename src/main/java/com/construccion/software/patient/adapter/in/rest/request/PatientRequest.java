package com.construccion.software.patient.adapter.in.rest.request;

public class PatientRequest {

    private String documentId;
    private String name;
    private String surname;
    private String birthDate;
    private String gender;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
