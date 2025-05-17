package com.mycompany.roombooking;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Manages booking details including dates and student information
 */
public class Booking {
    private static int nextId = 1;
    
    private final String bookingId;
    private final Student student;
    private final Room room;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private boolean isPaid;
    private boolean isApproved;

    public Booking(Student student, Room room, LocalDate startDate, LocalDate endDate) {
        this.bookingId = "BK" + String.format("%04d", nextId++);
        this.student = student;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPaid = false;
        this.isApproved = false;
    }

    // Getters
    public String getBookingId() { return bookingId; }
    public Student getStudent() { return student; }
    public Room getRoom() { return room; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public boolean isPaid() { return isPaid; }
    public boolean isApproved() { return isApproved; }

    public long getDurationInDays() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public void markAsPaid() {
        this.isPaid = true;
    }

    public void approveBooking() {
        this.isApproved = true;
    }

    public boolean isActive() {
        LocalDate today = LocalDate.now();
        return !today.isBefore(startDate) && !today.isAfter(endDate);
    }

    @Override
    public String toString() {
        return String.format("Booking %s: %s for %s (%s to %s) - %s",
                bookingId, student.getName(), room.getRoomNo(),
                startDate, endDate, isApproved ? "Approved" : "Pending");
    }
}
