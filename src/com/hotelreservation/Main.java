package com.hotelreservation;

import com.ui.CustomerMenu;
import com.ui.ReservationMenu;
import com.ui.RoomMenu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerMenu customerMenu = new CustomerMenu(sc);
        RoomMenu roomMenu = new RoomMenu(sc);
        ReservationMenu reservationMenu = new ReservationMenu(sc);
        while (true) {
            System.out.println();
            System.out.println("===================================");
            System.out.println("   HOTEL RESERVATION MANAGEMENT");
            System.out.println("===================================");
            System.out.println("1. Customer Management");
            System.out.println("2. Room Management");
            System.out.println("3. Reservation Management");
            System.out.println("0. Exit");
            System.out.println("===================================");
            System.out.print("Enter Your Choice: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> customerMenu.showMenu();
                case "2" -> roomMenu.showMenu();
                case "3" -> reservationMenu.showMenu();
                case "0" -> {
                    System.out.println();
                    System.out.println("Thank You! Visit Again...");
                    sc.close();
                    return;
                }
                default -> {
                    System.out.println();
                    System.out.println("Invalid Choice! Try Again.");
                }
            }
        }
    }
}
