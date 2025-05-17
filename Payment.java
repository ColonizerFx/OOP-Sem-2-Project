package com.mycompany.roombooking;

/**
 * Handles payment processing for IIUM room bookings
 */
public class Payment {
    private static int nextTransactionId = 1000;
    
    private final String transactionId;
    private final Booking booking;
    private final double amount;
    private String paymentMethod; // "BancSoft", "MyIIUM Portal", "Cash"
    private boolean isVerified;

    public Payment(Booking booking, double amount, String paymentMethod) {
        this.transactionId = "PYMT" + nextTransactionId++;
        this.booking = booking;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.isVerified = false;
    }

    public boolean verifyPayment() {
        // In a real system, this would connect to IIUM's payment gateway
        this.isVerified = true;
        booking.markAsPaid();
        return true;
    }

    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public boolean isVerified() { return isVerified; }

    @Override
    public String toString() {
        return String.format("Payment %s: %s for %s (Amount: RM%.2f, Method: %s)",
                transactionId, booking.getBookingId(), booking.getStudent().getName(),
                amount, paymentMethod);
    }
}
