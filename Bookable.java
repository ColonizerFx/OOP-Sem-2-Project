package com.mycompany.roombooking;

public interface Bookable {
    void book();
    void cancel();
    void editBooking(String newDetails);
    String getRoomNo();
    boolean isBooked();
    void setBooked(boolean isBooked);
}
