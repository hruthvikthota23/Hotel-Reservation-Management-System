package com.dao;

import com.model.Room;
import com.util.DBConnection;
import java.sql.*;
import java.util.*;

public class RoomDAO {

    public List<Room> getAllRooms() throws SQLException{
        List<Room> rooms=new ArrayList<>();
        String query="""
                SELECT room_id, room_no, room_type, price, status
                FROM rooms
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery()
        ){
            while(rs.next()){
                rooms.add(
                    new Room(
                        rs.getInt("room_id"),
                        rs.getInt("room_no"),
                        rs.getString("room_type"),
                        rs.getDouble("price"),
                        rs.getString("status")
                    )
                );
            }
        }
        return rooms;
    }

    public List<Room> getAvailableRooms() throws SQLException{
        List<Room> rooms=new ArrayList<>();
        String query="""
                SELECT room_id, room_no, room_type, price, status
                FROM rooms
                WHERE status=?;
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query);
        ){
            ps.setString(1, "Available");
            try(ResultSet rs=ps.executeQuery()){
                while(rs.next()){
                    rooms.add(
                        new Room(
                            rs.getInt("room_id"),
                            rs.getInt("room_no"),
                            rs.getString("room_type"),
                            rs.getDouble("price"),
                            rs.getString("status")
                        )   
                    );
                }
            }
        }
        return rooms;
    }

    public Room getRoomById(int roomID) throws SQLException{
        String query="""
                SELECT room_id, room_no, room_type, price, status
                FROM rooms
                WHERE room_id=?;
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query)
        ){
            ps.setInt(1, roomID);
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    return new Room(
                        rs.getInt("room_id"),
                        rs.getInt("room_no"),
                        rs.getString("room_type"),
                        rs.getDouble("price"),
                        rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

    public Room getRoomByNumber(int roomNo) throws SQLException{
        String query="""
                SELECT room_id, room_no, room_type, price, status
                FROM rooms
                WHERE room_no=?;
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query)
        ){
            ps.setInt(1, roomNo);
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    return new Room(
                        rs.getInt("room_id"),
                        rs.getInt("room_no"),
                        rs.getString("room_type"),
                        rs.getDouble("price"),
                        rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

    public boolean updateRoomStatus(int roomID,String status) throws SQLException{
        String query="""
                UPDATE rooms SET status=?
                WHERE room_id=?;
                """;
        try(
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query)
        ){
            ps.setString(1, status);
            ps.setInt(2,roomID);
            return ps.executeUpdate()>0;
        }
    }
}
