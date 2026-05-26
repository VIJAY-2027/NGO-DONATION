package com.wipro.ndms.main;

import java.util.ArrayList;

import com.wipro.ndms.entity.Donation;
import com.wipro.ndms.entity.Donor;
import com.wipro.ndms.service.DonationService;

public class Main {

    public static void main(String[] args) {

        ArrayList<Donor> donors =
                new ArrayList<>();

        donors.add(new Donor(
                "D001",
                "Arun Kumar",
                "arun@mail.com",
                "9876543210"));

        ArrayList<Donation> donations =
                new ArrayList<>();

        DonationService service =
                new DonationService(
                        donors,
                        donations);

        try {

            // Add Donor
            service.addDonor(
                    new Donor(
                            "D002",
                            "Priya Sharma",
                            "priya@mail.com",
                            "9123456780"));

            // Record Donations
            service.recordDonation(
                    new Donation(
                            "DN101",
                            "D001",
                            5000,
                            "2025-08-10",
                            "Education Support"));

            service.recordDonation(
                    new Donation(
                            "DN102",
                            "D001",
                            3000,
                            "2025-09-05",
                            "Flood Relief"));

            // Update Details
            service.updateDonorDetails(
                    "D001",
                    "arun.new@mail.com",
                    "9988776655");

            // Donation History
            System.out.println(
                    "--- Donation History ---");

            for (Donation d :
                    service.getDonationHistory("D001")) {

                System.out.println(
                        d.getPurpose()
                        + " - "
                        + d.getAmount());
            }

            // Summary
            System.out.println(
                    "\n--- Donor Summary ---");

            System.out.println(
                    service.generateDonorSummary("D001"));

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
