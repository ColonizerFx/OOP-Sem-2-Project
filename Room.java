/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.roombooking;

/**
 *
 * @author User
 */
public class Room 
{
    String roomNo;
    String roomType;
    boolean isBooked;
    
    Room(String roomNo, String roomType)
    {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.isBooked = false; // not booked by default
    }
    
    
    /**
     * @return the roomNo
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * @param roomNo the roomNo to set
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * @return the roomType
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * @param roomType the roomType to set
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    public boolean isBooked() {
        return isBooked;
}

    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
}
    
    
    public String getRoomInfo()
    {
        return getRoomNo() + "(" + getRoomType() + ") -" + (isBooked? "Booked" : "Available");
    }
}
