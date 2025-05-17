/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.roombooking;

/**
 *
 * @author User
 */
public class PremiumRoom extends Room implements Bookable
{
    String bookingDetails;
    
    PremiumRoom(String roomNo)
    {
        super(roomNo, "Deluxe");
    }
    
    @Override
    public void book()
    {
        this.isBooked = true;
        this.bookingDetails = "Booked"; 
    }
    
    @Override
    public void cancel()
    {
        this.isBooked = false;
        this.bookingDetails = "";
    }
    
    @Override
    public void editBooking(String newDetails)
    {
        this.bookingDetails = newDetails;
    }
    
    @Override
    public String toString()
    {
        return getRoomInfo() + (isBooked ? "| Details: " + bookingDetails : "");
    }

}
