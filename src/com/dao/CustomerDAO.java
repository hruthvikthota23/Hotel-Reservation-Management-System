package com.dao;

import com.model.Customer;
import com.util.DBConnection;
import java.sql.*;
import java.util.*;

public class CustomerDAO {

    public int addCustomer(Customer customer) throws SQLException{
        String query="""
                INSERT INTO customers(name, contact, address)
                VALUES (?, ?, ?);
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ){
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getContact());
            ps.setString(3, customer.getAddress());
            int affectedRows=ps.executeUpdate();
            if(affectedRows>0){
                try(ResultSet rs=ps.getGeneratedKeys()){
                    if(rs.next()){
                        return rs.getInt(1);
                    }
                }
            }
        } 
        return -1;
    }

    public List<Customer> getAllCustomers() throws SQLException{
        List<Customer> customers=new ArrayList<>();
        String query="""
                SELECT customer_id, name, contact, address
                FROM customers;
                """;
            try(
                Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);
                ResultSet rs=ps.executeQuery();
            ){
            while(rs.next()){
                customers.add(
                    new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("contact"),
                        rs.getString("address")
                    )
                );
            }
        }
        return customers;
    }
    
    public Customer getCustomerById(int customerID) throws SQLException{
        String query="""
                SELECT customer_id, name, contact, address
                FROM customers
                WHERE customer_id=?;
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query)
        ){
            ps.setInt(1, customerID);
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    return new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("contact"),
                        rs.getString("address")
                    );
                }
            }
        }
        return null;
    }
    
    public boolean updateCustomer(Customer customer) throws SQLException{
        String query="""
                UPDATE customers
                SET name=?, contact=?, address=?
                WHERE customer_id=?;
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query)
        ){
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getContact());
            ps.setString(3, customer.getAddress());
            ps.setInt(4, customer.getCustomer_id());
            return ps.executeUpdate()>0;
        }
    }

    public boolean deleteCustomer(Customer customer) throws SQLException{
        String query="""
                DELETE FROM customers
                WHERE customer_id=?;
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query)
        ){
            ps.setInt(1, customer.getCustomer_id());
            return ps.executeUpdate()>0;
        }
    }
}
