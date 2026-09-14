package com.service;

import com.dao.RoomDAO;
import com.model.Room;
import java.sql.SQLException;
import java.util.List;

public class RoomService {
    private final RoomDAO roomDAO;

    public RoomService(){
        roomDAO=new RoomDAO();
    }

    public List<Room> getAllRooms() throws SQLException{
        List<Room> rooms=roomDAO.getAllRooms();
        if(rooms.isEmpty()){
            throw new IllegalArgumentException("No Rooms Found.");
        }
        return rooms;
    }
    
    public List<Room> getAvailableRooms() throws SQLException{
        List<Room> rooms=roomDAO.getAvailableRooms();
        if(rooms.isEmpty()){
            throw new IllegalArgumentException("No Available Rooms Found.");
        }
        return rooms;
    }

    public Room getRoomById(int roomID) throws SQLException{
        if(roomID<=0){
            throw new IllegalArgumentException("Invalid Room ID");
        }
        Room room=roomDAO.getRoomById(roomID);
        if (room==null) {
            throw new IllegalArgumentException("Room Not Found.");
        }
        return room;
    }

    public Room getRoomByNumber(int roomNo) throws SQLException{
        if(roomNo<=0){
            throw new IllegalArgumentException("Invalid Room Number");
        }
        Room room=roomDAO.getRoomByNumber(roomNo);
        if (room==null) {
            throw new IllegalArgumentException("Room Not Found.");
        }
        return room;
    }

}
