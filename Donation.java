package com.wipro.ndms.entity;

public class Donation {
	private String donationId;
    private String donorId;
    private double amount;
    private String date;
    private String purpose;

    public Donation(String donationId, String donorId,
                    double amount, String date, String purpose) {

        this.donationId = donationId;
        this.donorId = donorId;
        this.amount = amount;
        this.date = date;
        this.purpose = purpose;
    }

    public String getDonationId() {
        return donationId;
    }

    public void setDonationId(String donationId) {
        this.donationId = donationId;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}

