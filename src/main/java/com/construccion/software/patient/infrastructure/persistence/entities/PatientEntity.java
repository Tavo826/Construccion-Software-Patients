package com.construccion.software.patient.infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class PatientEntity {

    @Id
    private Long documentId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 10)
    private String genre;

    @Column(nullable = false, length = 30)
    private String address;

    @Column(nullable = false, length = 10)
    private String phone;

    @Column(nullable = true, length = 50)
    private String email;

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
}
