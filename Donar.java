package com.wipro.ndms.entity;

public class Donor {
	private String donorId;
    private String name;
    private String email;
    private String phone;

    public Donor(String donorId, String name, String email, String phone) {
        this.donorId = donorId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

