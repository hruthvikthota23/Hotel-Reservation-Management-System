package com.ui;

import com.model.Room;
import com.service.RoomService;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class RoomMenu {
    private final Scanner sc;
    private final RoomService roomService;
    public RoomMenu(Scanner sc){
        this.sc=sc;
        this.roomService=new RoomService();
    }
    public void showMenu() {
        while (true) { 
            System.out.println();
            System.out.println("-----------------------------------");
            System.out.println("         ROOM MANAGEMENT");
            System.out.println("-----------------------------------");
            System.out.println("1. View All Rooms");
            System.out.println("2. View Available Rooms");
            System.out.println("3. Search Room By ID");
            System.out.println("4. Search Room By Number");
            System.out.println("0. Exit");
            System.out.println("-----------------------------------");
            System.out.print("Enter Your Choice : ");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    try {
                        List<Room> rooms=roomService.getAllRooms();
                        System.out.println("--------------------------------------------------");
                        System.out.println("| ID  | Room  | Type     | Price    | Status     |");
                        System.out.println("--------------------------------------------------");
                        for(Room room:rooms){
                            System.out.println(room);
                        }
                        System.out.println("--------------------------------------------------");
                    } 
                    catch (SQLException e) {
                        System.out.println("Error : "+e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        List<Room> rooms=roomService.getAvailableRooms();
                        System.out.println("--------------------------------------------------");
                        System.out.println("| ID  | Room  | Type     | Price    | Status     |");
                        System.out.println("--------------------------------------------------");
                        for(Room room:rooms){
                            System.out.println(room);
                        }
                        System.out.println("--------------------------------------------------");
                    } 
                    catch (SQLException e) {
                        System.out.println("Error : "+e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.print("Enter Room ID : ");
                        int roomID=sc.nextInt();
                        sc.nextLine();
                        Room room=roomService.getRoomById(roomID);
                        System.out.println("--------------------------------------------------");
                        System.out.println("| ID  | Room  | Type     | Price    | Status     |");
                        System.out.println("--------------------------------------------------");
                        System.out.println(room);
                        System.out.println("--------------------------------------------------");
                    } 
                    catch (SQLException e) {
                        System.out.println("Error : "+e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        System.out.print("Enter Room No : ");
                        int roomNo=sc.nextInt();
                        sc.nextLine();
                        Room room=roomService.getRoomByNumber(roomNo);
                        System.out.println("--------------------------------------------------");
                        System.out.println("| ID  | Room  | Type     | Price    | Status     |");
                        System.out.println("--------------------------------------------------");
                        System.out.println(room);
                        System.out.println("--------------------------------------------------");
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
