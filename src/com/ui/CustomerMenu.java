package com.ui;

import com.model.Customer;
import com.service.CustomerService;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    private final Scanner sc;
    private final CustomerService customerService;
    public CustomerMenu(Scanner sc){
        this.sc=sc;
        this.customerService=new CustomerService();
    }
    public void showMenu() {
        while (true) { 
            System.out.println();
            System.out.println("-----------------------------------");
            System.out.println("        CUSTOMER MANAGEMENT");
            System.out.println("-----------------------------------");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Update Customer Details");
            System.out.println("5. Delete Customer");
            System.out.println("0. Exit");
            System.out.println("-----------------------------------");
            System.out.print("Enter Your Choice : ");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Customer Name : ");
                        String name=sc.nextLine();
                        System.out.print("Contact : ");
                        String contact=sc.nextLine();
                        System.out.print("Address : ");
                        String address=sc.nextLine();
                        int customerID=customerService.addCustomer(name, contact, address);
                        System.out.println("Customer Added Successfully!");
                        System.out.println("Customer ID : "+customerID);
                    } 
                    catch (SQLException e) {
                        System.out.println("Error : "+e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        List<Customer> customers=customerService.getAllCustomers();
                        System.out.println("-----------------------------------------------------");
                        System.out.println("| ID  | Name         | Contact    | Address         |");
                        System.out.println("-----------------------------------------------------");
                        for(Customer customer:customers){
                            System.out.println(customer);
                        }
                        System.out.println("-----------------------------------------------------");
                    } 
                    catch (SQLException e) {
                        System.out.println("Error : "+e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.print("Enter Customer ID : ");
                        int customerID=sc.nextInt();
                        sc.nextLine();
                        Customer customer=customerService.getCustomerById(customerID);
                        System.out.println("-----------------------------------------------------");
                        System.out.println("| ID  | Name         | Contact    | Address         |");
                        System.out.println("-----------------------------------------------------");
                        System.out.println(customer);
                        System.out.println("-----------------------------------------------------");
                    } 
                    catch (SQLException e) {
                        System.out.println("Error : "+e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        System.out.print("Enter Customer ID : ");
                        int customerID=sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name : ");
                        String name=sc.nextLine();
                        System.out.print("Contact : ");
                        String contact=sc.nextLine();
                        System.out.print("Address : ");
                        String address=sc.nextLine();
                        customerService.updateCustomer(customerID, name, contact, address);
                        System.out.println("Updated Successfully!");
                    } 
                    catch (SQLException e) {
                        System.out.println("Error : "+e.getMessage());
                    }
                }
                case 5 -> {
                    try{
                        System.out.print("Enter Customer ID : ");
                        int customerID=sc.nextInt();
                        sc.nextLine();
                        customerService.deleteCustomer(customerID);
                        System.out.println("Customer Deleted Successfully");
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
