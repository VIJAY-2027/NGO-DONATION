package com.wipro.ndms.service;
import java.util.ArrayList;

import com.wipro.ndms.entity.Donation;
import com.wipro.ndms.entity.Donor;
import com.wipro.ndms.util.DonorNotFoundException;
import com.wipro.ndms.util.DuplicateDonorException;
import com.wipro.ndms.util.InvalidDonationException;

public class DonationService {
	 private ArrayList<Donor> donors;
	    private ArrayList<Donation> donations;

	    public DonationService(ArrayList<Donor> donors,
	                           ArrayList<Donation> donations) {

	        this.donors = donors;
	        this.donations = donations;
	    }
	    public void addDonor(Donor donor)
	            throws DuplicateDonorException {

	        for (Donor d : donors) {
	            if (d.getDonorId().equals(donor.getDonorId())) {
	                throw new DuplicateDonorException(
	                        "Donor ID already exists");
	            }
	        }

	        donors.add(donor);
	    }
	    public Donor findDonor(String donorId)
	            throws DonorNotFoundException {

	        for (Donor d : donors) {
	            if (d.getDonorId().equals(donorId)) {
	                return d;
	            }
	        }

	        throw new DonorNotFoundException(
	                "Donor not found");
	    }
	    public void updateDonorDetails(String donorId,
	                                   String newEmail,
	                                   String newPhone)
	            throws DonorNotFoundException {

	        Donor donor = findDonor(donorId);

	        donor.setEmail(newEmail);
	        donor.setPhone(newPhone);
	    }
	    public void recordDonation(Donation donation)
	            throws DonorNotFoundException,
	                   InvalidDonationException {

	        findDonor(donation.getDonorId());

	        if (donation.getAmount() <= 0) {
	            throw new InvalidDonationException(
	                    "Invalid donation amount");
	        }

	        if (donation.getPurpose() == null ||
	                donation.getPurpose().isEmpty()) {

	            throw new InvalidDonationException(
	                    "Purpose cannot be empty");
	        }

	        donations.add(donation);
	    }
	    public ArrayList<Donation> getDonationHistory(String donorId)
	            throws DonorNotFoundException {

	        findDonor(donorId);

	        ArrayList<Donation> history =
	                new ArrayList<>();

	        for (Donation d : donations) {

	            if (d.getDonorId().equals(donorId)) {
	                history.add(d);
	            }
	        }

	        return history;
	    }

	    // Total Donations
	    public double calculateTotalDonations(String donorId)
	            throws DonorNotFoundException {

	        findDonor(donorId);

	        double total = 0;

	        for (Donation d : donations) {

	            if (d.getDonorId().equals(donorId)) {
	                total += d.getAmount();
	            }
	        }

	        return total;
	    }
	    public String generateDonorSummary(String donorId) {

	        try {

	            Donor donor = findDonor(donorId);

	            double total =
	                    calculateTotalDonations(donorId);

	            int count = 0;
	            String lastPurpose = "";

	            for (Donation d : donations) {

	                if (d.getDonorId().equals(donorId)) {

	                    count++;
	                    lastPurpose = d.getPurpose();
	                }
	            }

	            return "Donor Name : " + donor.getName()
	                    + "\nTotal Donations : " + total
	                    + "\nDonation Count : " + count
	                    + "\nLast Donation Purpose : "
	                    + lastPurpose;

	        } catch (Exception e) {

	            return e.getMessage();
	        }
	    }
	}
