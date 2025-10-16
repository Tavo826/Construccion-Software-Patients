package com.construccion.software.patient.domain.models;

import java.time.LocalDate;

public class HealthInsurance {

    private String companyName;
    private long policyNumber;
    private boolean active;
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
