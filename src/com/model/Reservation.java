package com.model;

import java.time.*;

public class Reservation {
    private int reservation_id;
    private int customer_id;
    private int room_id;
    private LocalDate check_in;
    private LocalDate check_out;
    private LocalDateTime reservation_date;
    private String status;

    public Reservation(){}

    public Reservation(int customer_id, int room_id, LocalDate check_in, LocalDate check_out){
        this.customer_id=customer_id;
        this.room_id=room_id;
        this.check_in=check_in;
        this.check_out=check_out;
    }

    public Reservation(int reservation_id,int customer_id, int room_id, 
        LocalDate check_in, LocalDate check_out,LocalDateTime reservation_date, String status){
        this(customer_id, room_id, check_in, check_out);
        this.reservation_id=reservation_id;
        this.reservation_date=reservation_date;
        this.status=status;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public LocalDate getCheck_in() {
        return check_in;
    }

    public void setCheck_in(LocalDate check_in) {
        this.check_in = check_in;
    }

    public LocalDate getCheck_out() {
        return check_out;
    }

    public void setCheck_out(LocalDate check_out) {
        this.check_out = check_out;
    }

    public LocalDateTime getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(LocalDateTime reservation_date) {
        this.reservation_date = reservation_date;
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
            "| %-7s | %-7s | %-7s | %-10s | %-10s | %-17s | %-10s |",
            reservation_id,
            customer_id,
            room_id,
            check_in,
            check_out,
            reservation_date,
            status
        );
    }
}
