package com.service;

import com.dao.CustomerDAO;
import com.model.Customer;
import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    private final CustomerDAO customerDAO;
    
    public CustomerService(){
        customerDAO=new CustomerDAO();
    }

    public int addCustomer(String name, String contact, String address) throws SQLException{
        if(name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name Can't Be Empty.");
        }
        if(contact==null || contact.trim().isEmpty()){
            throw new IllegalArgumentException("Contact Can't Be Empty.");
        }
        if(!contact.matches("\\d{10}")){
            throw new IllegalArgumentException("Invalid Contact.");
        }
        if(address==null || address.trim().isEmpty()){
            throw new IllegalArgumentException("Address Can't Be Empty.");
        }
        int customerID=customerDAO.addCustomer(new Customer(name, contact, address));
        if(customerID<=0){
            throw new IllegalArgumentException("Add Customer Failed");
        }
        return customerID;
    }
    
    public List<Customer> getAllCustomers() throws SQLException{
        List<Customer> customers=customerDAO.getAllCustomers();
        if(customers.isEmpty()){
            throw new IllegalArgumentException("No Customers Found.");
        }
        return customers;
    }
    
    public Customer getCustomerById(int customerID) throws SQLException{
        if(customerID<=0){
            throw new IllegalArgumentException("Invalid Customer ID");
        }
        Customer customer=customerDAO.getCustomerById(customerID);
        if(customer==null){
            throw new IllegalArgumentException("Customer Not Found.");
        }
        return customer;
    }
    
    public boolean updateCustomer(int customerID, String name, String contact, String address) throws SQLException{
        if(customerID<=0){
            throw new IllegalArgumentException("Invalid Customer ID");
        }
        if(name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name Can't Be Empty.");
        }
        if(contact==null || contact.trim().isEmpty()){
            throw new IllegalArgumentException("Contact Can't Be Empty.");
        }
        if(!contact.matches("\\d{10}")){
            throw new IllegalArgumentException("Invalid Contact.");
        }
        if(address==null || address.trim().isEmpty()){
            throw new IllegalArgumentException("Address Can't Be Empty.");
        }
        boolean updated=customerDAO.updateCustomer(new Customer(customerID, name, contact, address));
        if(!updated){
            throw new IllegalArgumentException("Update Failed.");
        }
        return updated;
    }

    public boolean deleteCustomer(int customerID) throws SQLException{
        if(customerID<=0){
            throw new IllegalArgumentException("Invalid Customer ID");
        }
        Customer customer=customerDAO.getCustomerById(customerID);
        if(customer==null){
            throw new IllegalArgumentException("Customer Not Found.");
        }
        boolean deleted=customerDAO.deleteCustomer(customer);
        if(!deleted){
            System.out.println("Deleted Failed");
        }
        return deleted;
    }
}
