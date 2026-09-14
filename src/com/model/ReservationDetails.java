package com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationDetails {
    private final int reservation_id;
    private final String customer_name;
    private final String room_no;
    private final String room_type;
    private final LocalDate check_in;
    private final LocalDate check_out;
    private final LocalDateTime reservation_date;
    private final String status;
    public ReservationDetails(int reservation_id, String customer_name, String room_no, String room_type,
                              LocalDate check_in, LocalDate check_out, LocalDateTime reservation_date, String status) {
        this.reservation_id = reservation_id;
        this.customer_name = customer_name;
        this.room_no = room_no;
        this.room_type = room_type;
        this.check_in = check_in;
        this.check_out = check_out;
        this.reservation_date = reservation_date;
        this.status = status;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getRoom_no() {
        return room_no;
    }

    public String getRoom_type() {
        return room_type;
    }

    public LocalDate getCheck_in() {
        return check_in;
    }

    public LocalDate getCheck_out() {
        return check_out;
    }

    public LocalDateTime getReservation_date() {
        return reservation_date;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-6s | %-16s | %-7s | %-10s | %-10s | %-10s | %-12s |",
                reservation_id,
                customer_name,
                room_no,
                room_type,
                check_in,
                check_out,
                status
        );
    }
}
