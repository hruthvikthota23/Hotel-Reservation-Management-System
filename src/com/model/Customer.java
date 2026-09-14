package com.model;

public class Customer {
    private int customer_id;
    private String name;
    private String contact;
    private String address;

    public Customer(){}

    public Customer(String name, String contact, String address){
        this.name=name;
        this.contact=contact;
        this.address=address;
    }

    public Customer(int customer_id,String name, String contact, String address){
        this(name,contact,address);
        this.customer_id=customer_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override 
    public String toString(){
        return String.format(
            "| %-3s | %-12s | %-10s | %-15s |",
            customer_id, name, contact, address
        );
    }
}
