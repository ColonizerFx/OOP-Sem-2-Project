/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.roombooking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class RoomBookingDemo 
{

    public static void main(String[] args) // 6 standard, 4 deluxe, 2 premium (by default)
    {
        ArrayList<Bookable> rooms = new ArrayList<>();
        rooms.add(new StandardRoom("S01"));
        rooms.add(new StandardRoom("S02"));
        rooms.add(new StandardRoom("S03"));
        rooms.add(new StandardRoom("S04"));
        rooms.add(new StandardRoom("S05"));
        rooms.add(new StandardRoom("S06"));
        rooms.add(new DeluxeRoom("D01"));
        rooms.add(new DeluxeRoom("D02"));
        rooms.add(new DeluxeRoom("D03"));
        rooms.add(new DeluxeRoom("D04"));
        rooms.add(new PremiumRoom("P01"));
        rooms.add(new PremiumRoom("P02"));
        
        
        
        Scanner in = new Scanner(System.in);
        boolean running = true;

        while (running) {
        System.out.println("1. Add Room\n2. Delete Room\n3. Show Rooms\n4. Book Room \n5. Exit");
        int choice = in.nextInt();
        in.nextLine(); // clear buffer

        switch (choice) 
        {
            case 1:
            {
                System.out.print("Enter room number: ");
                String roomNo = in.nextLine();
                System.out.print("Enter room type: \n1.Standard\n2.Deluxe\n3.Premium");
                int type = in.nextInt();
                    switch (type)
                    {
                        case 1: rooms.add(new StandardRoom(roomNo));
                        System.out.print("\nAdded\n");
                        break;
                    
                        case 2: rooms.add(new DeluxeRoom(roomNo));
                        System.out.print("\nAdded\n");
                        break;
                    
                        case 3: rooms.add(new PremiumRoom(roomNo));        
                        System.out.print("\nAdded\n\n");
                        break;
                    }
                break;        
            }
            case 2:
            {
                System.out.print("Enter room number to delete: ");
                String delNum = in.nextLine();
                
                boolean found = false;
                
                for (Bookable room : rooms) 
                {
                    if (room.getRoomNo().equalsIgnoreCase(delNum)) 
                    {
                        rooms.remove(room); // or use iterator if ConcurrentModificationException occurs
                        System.out.println("Room " + delNum + " deleted.");
                        found = true;
                        break;
                    }
                }

                if (!found) 
                {
                    System.out.println("Room not found.");
                }
                break;
            }
        
            case 3: 
            {
                for (Bookable room : rooms) // lisitng available room
                {
                    System.out.println(room);
                }
                break;
            }
            
            case 4:
            {
                System.out.print("Enter room number to book: ");
                
                String bookNum = in.nextLine();

                boolean booked = false;
    
                for (Bookable room : rooms) {
                    if (room.getRoomNo().equalsIgnoreCase(bookNum)) {
                        if (!room.isBooked()) {
                        room.setBooked(true);
                        System.out.println("Room " + bookNum + " has been successfully booked.");
                    } else {
                        System.out.println("Room " + bookNum + " is already booked.");
                    }
                    booked = true;
                    break;
                }
            }
                
            if (!booked) {
                System.out.println("Room not found.");
            }

            break;
                
            }
            
            case 5: running = false; break;
        
            default: System.out.println("Invalid option!");
        
        } // end switch
        
    } // end while
        
    } // end main
    
} // end class
