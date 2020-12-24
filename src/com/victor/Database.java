package com.victor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

	public void loadRoomsIntoArraylist(ArrayList<Room> rooms) throws SQLException, ClassNotFoundException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ "hotelapplication","root","jamjamcholo");
		System.out.println("----Loading database entries into ArrayList----");
		
        Statement s = c1.createStatement();
        s.execute("select * from rooms");
        ResultSet rs = s.getResultSet();
        
        //public Room(int roomNum, String bedType, char smoking, double rate)
        while(rs.next()) {
        	
        	Room room = new Room(rs.getInt(2), rs.getString(5), rs.getString(6).charAt(0), rs.getDouble(3));
        	StringBuilder sb = new StringBuilder();
        	sb.append(rs.getString(4));
        	room.setOccupantName(sb);
        	room.setOccupied(rs.getBoolean(7));
        	rooms.add(room);
        	
        }

       
        
		
	}
	
	
	public void addRoom(int roomNumber, String bedType, char smoking, double rate) throws ClassNotFoundException, SQLException {
		
		if(getRoomCount() < 10) {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ "hotelapplication","root","jamjamcholo");
		System.out.println("---connected---");
		PreparedStatement ps = c1.prepareStatement("insert into rooms values(?, ? , ?, ? , ?, ?, ?)");
	
		ps.setInt(1, 1);
		ps.setInt(2, roomNumber);
		ps.setDouble(3, rate);
		ps.setString(4, null);
		ps.setString(5, bedType);
		ps.setString(6, String.valueOf(smoking));
		ps.setBoolean(7, false);
		
		ps.executeUpdate();
		
		}
		
		else
			System.out.println("Cannot add any more rooms to database. We have passed the limit of 10");
		
	}
	
	public void setHotel(String name, String address) throws ClassNotFoundException, SQLException {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ "hotelapplication","root","jamjamcholo");
		System.out.println("---connected---");
		PreparedStatement ps = c1.prepareStatement("insert into hotel values(?, ?, ?, ? ,?)");
		
		ps.setInt(1, 1); //hotel id
	    ps.setString(2, name);
	    ps.setString(3, address);
	    ps.setInt(4, 0); //occupation count initially is 0
		ps.setInt(5, 10); //number of rooms is 10
	    ps.executeUpdate();
		
		
	}
	
	public int getRoomCount() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ "hotelapplication","root","jamjamcholo");
		
		PreparedStatement ps = c1.prepareStatement("select count(*) from rooms");
		ps.execute();
		ResultSet rs = ps.getResultSet();
	

			while(rs.next()) {
			return rs.getInt(1);
			}
			
	
		return 0;
		
		
	}
	
	public void addReservation(String name, char smoking, String bedType) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ "hotelapplication","root","jamjamcholo");
		
		PreparedStatement ps = c1.prepareStatement("select room_number from rooms where smoking = ? and bed_type = ?");
		
		ps.setString(1, String.valueOf(smoking));
		ps.setString(2, bedType);
		ps.execute();
		ResultSet rs = ps.getResultSet();
		
		int roomNumber = 0;
		while(rs.next()) {
		  roomNumber = rs.getInt(1);
		}
		PreparedStatement ps2 = c1.prepareStatement("update rooms set occupant_name = ?, occupied = true where room_number = ?");
		
		ps2.setString(1, name);
		ps2.setInt(2, roomNumber);
		ps2.executeUpdate();
		System.out.println("this is the room numbers " + roomNumber);
		
	}
	
	
	public void cancelReservation(String name) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ "hotelapplication","root","jamjamcholo");
		
		PreparedStatement ps = c1.prepareStatement("update rooms set occupant_name = null, occupied = false where occupant_name = ?");
		
		ps.setString(1, name);
		ps.executeUpdate();
		
		System.out.println("Removed reservation for " + name);
		
		
	}
	
	
	
	
}
