package com.construccion.software.patient.infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class PatientEntity {

    @Id
    private Long documentId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String surname;

    @Column(nullable = false, length = 10)
    private String genre;

    @Column(nullable = false, length = 30)
    private String address;

    @Column(nullable = false, length = 10)
    private long phone;

    @Column(nullable = true, length = 50)
    private String email;

    @Embedded
    private EmergencyContactEntity emergencyContact;

    @Embedded
    private HealthInsuranceEntity healthInsurance;



    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmergencyContactEntity getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContactEntity emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public HealthInsuranceEntity getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(HealthInsuranceEntity healthInsurance) {
        this.healthInsurance = healthInsurance;
    }
}
