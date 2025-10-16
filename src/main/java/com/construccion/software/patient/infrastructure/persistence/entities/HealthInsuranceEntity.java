package com.construccion.software.patient.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class HealthInsuranceEntity {

    @Column(nullable = false, length = 50)
    private String companyName;

    @Column(nullable = false)
    private long policyNumber;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private LocalDate policyValidity;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(long policyNumber) {
        this.policyNumber = policyNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getPolicyValidity() {
        return policyValidity;
    }

    public void setPolicyValidity(LocalDate policyValidity) {
        this.policyValidity = policyValidity;
    }
}
