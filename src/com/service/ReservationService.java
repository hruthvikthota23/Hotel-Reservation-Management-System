package com.service;

import com.dao.CustomerDAO;
import com.dao.ReservationDAO;
import com.dao.RoomDAO;
import com.model.Customer;
import com.model.Reservation;
import com.model.ReservationDetails;
import com.model.Room;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ReservationService {
    private final CustomerDAO customerDAO;
    private final RoomDAO roomDAO;
    private final ReservationDAO reservationDAO;

    public ReservationService(){
        customerDAO=new CustomerDAO();
        roomDAO=new RoomDAO();
        reservationDAO=new ReservationDAO();
    }

    public int createReservation(int customerID, int roomID, LocalDate checkIn, LocalDate checkOut) throws SQLException{
        if(customerID<=0){
            throw new IllegalArgumentException("Invalid Customer ID.");
        }
        Customer customer=customerDAO.getCustomerById(customerID);
        if(customer==null){
            throw new IllegalArgumentException("Customer Not Found.");
        }
        if(roomID<=0){
            throw new IllegalArgumentException("Invalid Room ID.");
        }
        Room room=roomDAO.getRoomById(roomID);
        if(room==null){
            throw new IllegalArgumentException("Room Not Found.");
        }
        if(!room.getStatus().equalsIgnoreCase("Available")){
            throw new IllegalArgumentException("Room Not Available.");
        }
        if(checkIn==null){
            throw new IllegalArgumentException("Check-In Can't Be Empty.");
        }
        if(checkIn.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Check-In can't Be In Past.");
        }
        if(checkOut==null){
            throw new IllegalArgumentException("Check-Out Can't Be Empty.");
        }
        if(!checkOut.isAfter(checkIn)){ 
            throw new IllegalArgumentException("Check-Out Must Be After Check-In.");
        }
        int reservationID=reservationDAO.createReservation(new Reservation(customerID, roomID, checkIn, checkOut));
        if(reservationID<=0){
            throw new IllegalArgumentException("Reservation Failed.");
        }
        boolean roomUpdated=roomDAO.updateRoomStatus(roomID, "Occupied");
        if(!roomUpdated){
            throw new SQLException("Reservation Created, But Room Status Not updated.");
        }
        return reservationID;
    }
    
    public List<ReservationDetails> getAllReservations() throws SQLException{
        List<ReservationDetails> reservations=reservationDAO.getAllReservations();
        if(reservations.isEmpty()){
            throw new IllegalArgumentException("No Reservations Found.");
        }
        return reservations;
    }

    public ReservationDetails getReservationDetailsById(int reservationID) throws SQLException{
        if(reservationID<=0){
            throw new IllegalArgumentException("Invalid Reservation ID.");
        }
        ReservationDetails reservation=reservationDAO.getReservationDetailsById(reservationID);
        if(reservation==null){
            throw new IllegalArgumentException("Reservation Not Found.");
        }
        return reservation;
    }
    
    public Reservation getReservationById(int reservationID) throws SQLException{
        if(reservationID<=0){
            throw new IllegalArgumentException("Invalid Reservation ID.");
        }
        Reservation reservation=reservationDAO.getReservationById(reservationID);
        if(reservation==null){
            throw new IllegalArgumentException("Reservation Not Found.");
        }
        return reservation;
    }
    
    public boolean updateReservation(int reservationID, int roomID, LocalDate checkIn, LocalDate checkOut) throws SQLException{
        if(reservationID<=0){
            throw new IllegalArgumentException("Invalid Reservation ID.");
        }
        if(roomID<=0){
            throw new IllegalArgumentException("Invalid Room ID.");
        }
        if(checkIn==null){
            throw new IllegalArgumentException("Check-In Can't Be Empty.");
        }
        if(checkOut==null){
            throw new IllegalArgumentException("Check-Out Can't Be Empty.");
        }
        if (!checkOut.isAfter(checkIn)) {
            throw new IllegalArgumentException("Check-Out Must Be After Check-In.");
        }
        Reservation reservation=reservationDAO.getReservationById(reservationID);
        if(reservation==null){
            throw new IllegalArgumentException("Reservation Not Found.");
        }
        Room room=roomDAO.getRoomById(roomID);
        if(room==null){
            throw new IllegalArgumentException("Room Not Found.");
        }
        if(roomID != reservation.getRoom_id() && !room.getStatus().equalsIgnoreCase("Available")){
            throw new IllegalArgumentException("Room Not Available.");
        }
        Reservation updatedReservation=new Reservation(reservationID, reservation.getCustomer_id(), roomID, checkIn, checkOut, reservation.getReservation_date(), reservation.getStatus()); 
        boolean updated=reservationDAO.updateReservation(updatedReservation);
        if(!updated){
            throw new IllegalArgumentException("Reservation Update Failed.");
        }
        if (roomID != reservation.getRoom_id()) {
            boolean oldRoomUpdated =roomDAO.updateRoomStatus(reservation.getRoom_id(),"Available");
            if(!oldRoomUpdated){
                throw new IllegalArgumentException("Failed To Update Old Room Status.");
            }
            boolean newRoomUpdated =roomDAO.updateRoomStatus(roomID,"Occupied");
            if (!newRoomUpdated) {
                throw new IllegalArgumentException("Failed To Update New Room Status.");
            }
        }
        return updated;
    }
    
    public boolean cancelReservation(int reservationID) throws SQLException{
        if(reservationID<=0){
            throw new IllegalArgumentException("Invalid Reservation ID.");
        }
        Reservation reservation=reservationDAO.getReservationById(reservationID);
        if(reservation==null){
            throw new IllegalArgumentException("Reservation Not Found.");
        }
        if(reservation.getStatus().equalsIgnoreCase("Cancelled")){
            throw new IllegalArgumentException("Reservation Already Cancelled");
        }
        boolean cancelled=reservationDAO.cancelReservation(reservationID);
        if(!cancelled){
            throw new IllegalArgumentException("Reservation Cancel Failed.");
        }
        boolean updated=roomDAO.updateRoomStatus(reservation.getRoom_id(),"Available");
        if(!updated){
            throw new IllegalArgumentException("Reservation Cancelled, But Room Status Update Failed.");
        }
        return cancelled;
    }
}
