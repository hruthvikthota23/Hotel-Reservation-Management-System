package com.dao;

import com.model.Reservation;
import com.model.ReservationDetails;
import com.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    public int createReservation(Reservation reservation) throws SQLException{
        String query="""
                INSERT INTO reservations(customer_id, room_id, check_in, check_out)
                VALUES (?, ?, ?, ?);
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ){
            ps.setInt(1, reservation.getCustomer_id());
            ps.setInt(2, reservation.getRoom_id());
            ps.setDate(3, Date.valueOf(reservation.getCheck_in()));
            ps.setDate(4, Date.valueOf(reservation.getCheck_out()));
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

    public List<ReservationDetails> getAllReservations() throws SQLException{
        List<ReservationDetails> reservations=new ArrayList<>();
        String query="""
                SELECT 
                    r.reservation_id, 
                    c.name AS customer_name, 
                    rm.room_no, rm.room_type, 
                    r.check_in, r.check_out, r.reservation_date, r.status 
                FROM reservations r 
                JOIN customers c 
                    ON r.customer_id = c.customer_id 
                JOIN rooms rm 
                    ON r.room_id = rm.room_id 
                ORDER BY r.reservation_id;
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery()
        ){
            while(rs.next()){
                reservations.add(
                    new ReservationDetails( 
                        rs.getInt("reservation_id"), 
                        rs.getString("customer_name"), 
                        rs.getString("room_no"), 
                        rs.getString("room_type"), 
                        rs.getDate("check_in").toLocalDate(), 
                        rs.getDate("check_out").toLocalDate(), 
                        rs.getTimestamp("reservation_date").toLocalDateTime(), 
                        rs.getString("status")
                    )
                );       
            }
        }
        return reservations;
    }
            
    public ReservationDetails getReservationDetailsById(int reservationID) throws SQLException{
        String query="""
                    SELECT 
                        r.reservation_id, 
                        c.name AS customer_name, 
                        rm.room_no, rm.room_type, 
                        r.check_in, r.check_out, r.reservation_date, r.status 
                    FROM reservations r 
                    JOIN customers c 
                        ON r.customer_id = c.customer_id 
                    JOIN rooms rm 
                        ON r.room_id = rm.room_id 
                    WHERE reservation_id=?;
                    """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query)
        ){
            ps.setInt(1, reservationID);
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    return new ReservationDetails(
                        rs.getInt("reservation_id"),
                        rs.getString("customer_name"),
                        rs.getString("room_no"),
                        rs.getString("room_type"),
                        rs.getDate("check_in").toLocalDate(),
                        rs.getDate("check_out").toLocalDate(),
                        rs.getTimestamp("reservation_date").toLocalDateTime(),
                        rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

    public Reservation getReservationById(int reservationID) throws SQLException{
        String query="""
                    SELECT reservation_id, customer_id, room_id,
                    check_in, check_out, reservation_date, status
                    FROM reservations
                    WHERE reservation_id=?;
                    """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query)
        ){
            ps.setInt(1, reservationID);
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    return new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("room_id"),
                        rs.getDate("check_in").toLocalDate(),
                        rs.getDate("check_out").toLocalDate(),
                        rs.getTimestamp("reservation_date").toLocalDateTime(),
                        rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

        
    public boolean updateReservation(Reservation reservation) throws SQLException{
        String query="""
                UPDATE reservations
                SET room_id=?, check_in=?, check_out=?
                WHERE reservation_id=?;
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query)
        ){
            ps.setInt(1,reservation.getRoom_id());
            ps.setDate(2, Date.valueOf(reservation.getCheck_in()));
            ps.setDate(3, Date.valueOf(reservation.getCheck_out()));
            ps.setInt(4,reservation.getReservation_id());
            return ps.executeUpdate()>0;
        }
    }
            
    public boolean cancelReservation(int reservationID) throws SQLException{
        String query="""
                UPDATE reservations
                SET status=?
                WHERE reservation_id=?;
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query)
        ){
            ps.setString(1, "Cancelled");
            ps.setInt(2, reservationID);
            return ps.executeUpdate()>0;
        }
    }
}
