package com.construccion.software.patient.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmergencyContactEntity {

    @Column(name = "contact_name", nullable = false, length = 50)
    private String name;

    @Column(name = "contact_surname", nullable = false, length = 50)
    private String surname;

    @Column(nullable = false, length = 20)
    private String relationship;

    @Column(name = "contact_phone", nullable = false, length = 10)
    private long phone;

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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
