package com.construccion.software.patient.adapter.in.rest.request;

public class HealthInsuranceRequest {

    private String companyName;
    private String policyNumber;
    private boolean active;
    private String policyValidity;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPolicyValidity() {
        return policyValidity;
    }

    public void setPolicyValidity(String policyValidity) {
        this.policyValidity = policyValidity;
    }
}
