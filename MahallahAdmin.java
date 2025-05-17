package com.mycompany.roombooking;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an IIUM Mahallah administrator with approval powers
 */
public class MahallahAdmin {
    private final String adminId;
    private final String mahallahName; // e.g., "Mahallah Ali"
    private final List<Booking> pendingApprovals;

    public MahallahAdmin(String adminId, String mahallahName) {
        this.adminId = adminId;
        this.mahallahName = mahallahName;
        this.pendingApprovals = new ArrayList<>();
    }

    public void addApprovalRequest(Booking booking) {
        pendingApprovals.add(booking);
    }

    public void approveBooking(String bookingId) {
        for (Booking booking : pendingApprovals) {
            if (booking.getBookingId().equals(bookingId)) {
                booking.approveBooking();
                booking.getRoom().setBooked(true);
                pendingApprovals.remove(booking);
                System.out.println("Booking " + bookingId + " approved!");
                return;
            }
        }
        System.out.println("Booking not found in pending approvals.");
    }

    public void rejectBooking(String bookingId) {
        pendingApprovals.removeIf(booking -> booking.getBookingId().equals(bookingId));
        System.out.println("Booking " + bookingId + " rejected.");
    }

    public void viewPendingApprovals() {
        if (pendingApprovals.isEmpty()) {
            System.out.println("No pending approvals.");
            return;
        }
        System.out.println("Pending Approvals for " + mahallahName + ":");
        pendingApprovals.forEach(System.out::println);
    }

    public String getAdminId() { return adminId; }
    public String getMahallahName() { return mahallahName; }
}
