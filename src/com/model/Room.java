package com.model;

public class Room {
    private int room_id;
    private int room_no;
    private String room_type;
    private double price;
    private String status;

    public Room(){}

    public Room(int room_no,String room_type){
        this.room_no=room_no;
        this.room_type=room_type;
    }

    public Room(int room_id, int room_no,String room_type, double price, String status){
        this(room_no, room_type);
        this.room_id=room_id;
        this.price=price;
        this.status=status;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getRoom_no() {
        return room_no;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override 
    public String toString(){
        return String.format(
            "| %-3s | %-5s | %-8s | %-8s | %-10s |",
            room_id, room_no, room_type, price, status
        );
    }
    
}
