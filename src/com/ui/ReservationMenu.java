package com.ui;

import com.model.ReservationDetails;
import com.service.ReservationService;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReservationMenu {
    private final Scanner sc;
    private final ReservationService reservationService;
    public ReservationMenu(Scanner sc){
        this.sc=sc;
        this.reservationService=new ReservationService();
    }
    public void showMenu() {
        while (true) { 
            System.out.println();
            System.out.println("-----------------------------------");
            System.out.println("       RESERVATION MANAGEMENT");
            System.out.println("-----------------------------------");
            System.out.println("1. Reserve Room");
            System.out.println("2. View All Reservations");
            System.out.println("3. Search Reservation");
            System.out.println("4. Update Reservation Details");
            System.out.println("5. Cancel Reservation");
            System.out.println("0. Exit");
            System.out.println("-----------------------------------");
            System.out.print("Enter Your Choice : ");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Customer ID : ");
                        int customerID=sc.nextInt();
                        sc.nextLine();
                        System.out.print("Room ID : ");
                        int roomID=sc.nextInt();
                        sc.nextLine();
                        System.out.print("Check-In (YYYY-MM-DD) : ");
                        String checkIn=sc.nextLine();
                        System.out.print("Check-Out (YYYY-MM-DD) : ");
                        String checkOut=sc.nextLine();
                        int reservationID=reservationService.createReservation(customerID, roomID, LocalDate.parse(checkIn), LocalDate.parse(checkOut));
                        System.out.println("Room Reserved Successfully!");
                        System.out.println("Reservation ID : "+reservationID);
                    } 
                    catch (SQLException e) {
                        System.out.println("Error : "+e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        List<ReservationDetails> reservations=reservationService.getAllReservations();
                        System.out.println("---------------------------------------------------------------------------------------------");
                        System.out.println("| Res ID | Customer Name    | Room No | Room Type  | Check-In   | Check-Out  | Status       |");
                        System.out.println("---------------------------------------------------------------------------------------------");
                        for(ReservationDetails reservation:reservations){
                            System.out.println(reservation);
                        }
                        System.out.println("---------------------------------------------------------------------------------------------");
                    } 
                    catch (SQLException e) {
                        System.out.println("Error : "+e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.print("Enter Reservation ID : ");
                        int reservationID=sc.nextInt();
                        sc.nextLine();
                        ReservationDetails reservation=reservationService.getReservationDetailsById(reservationID);
                        System.out.println("---------------------------------------------------------------------------------------------");
                        System.out.println("| Res ID | Customer Name    | Room No | Room Type  | Check-In   | Check-Out  | Status       |");
                        System.out.println("---------------------------------------------------------------------------------------------");
                        System.out.println(reservation);
                        System.out.println("---------------------------------------------------------------------------------------------");
                    } 
                    catch (SQLException e) {
                        System.out.println("Error : "+e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        System.out.print("Reservation ID : ");
                        int reservationID=sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Room ID : ");
                        int roomID=sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Check-In (YYYY-MM-DD) : ");
                        String checkIn=sc.nextLine();
                        System.out.print("New Check-Out (YYYY-MM-DD) : ");
                        String checkOut=sc.nextLine();
                        reservationService.updateReservation(reservationID, roomID, LocalDate.parse(checkIn), LocalDate.parse(checkOut));
                        System.out.println("Reservation Updated Successfully.");
                    } 
                    catch (SQLException e) {
                        System.out.println("Error : "+e.getMessage());
                    }
                }
                case 5 -> {
                    try {
                        System.out.print("Reservation ID : ");
                        int reservationID=sc.nextInt();
                        sc.nextLine();
                        reservationService.cancelReservation(reservationID);
                        System.out.println("Reservation Cancelled.");
                    } 
                    catch (SQLException e) {
                        System.out.println("Error : "+e.getMessage());
                    }
                }
                case 0 ->{
                    System.out.println();
                    System.out.println("Returning to Main Menu...");
                    return;
                }
                default ->{
                    System.out.println("Invalid Choice! Try Again...");
                }
            }
        }
    }
}
