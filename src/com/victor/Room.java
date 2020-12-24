package com.victor;

public class Room {
	
	private int roomNum;
	private String bedType;
	private double rate;
	private StringBuilder occupantName;
	private char smoking;
	private boolean occupied;
	

	
	public Room(int roomNum, String bedType, char smoking, double rate) {
		
		StringBuilder sb = new StringBuilder();

		this.roomNum = roomNum;
		this.bedType = bedType;
		this.smoking = smoking;
		this.rate = rate;
		occupantName = sb.append("Not occupied");
		
		
	}
	public Room() {
		StringBuilder sb = new StringBuilder();
		roomNum = 0;
		bedType = null;
		rate = 0;
		occupantName = sb.append("Not occupied");
		smoking = '\u0000';
		occupied = false;
		
	}
	
	
	
	public String toString() {
		
    return "Room number: " + roomNum + "\n"
    	   + "Occupant name: "  + occupantName + "\n"
    	   + "Smoking room: " + smoking + "\n"
    	   + "Bed Type: " + bedType + "\n" 
    	   + "Rate: " + rate
           + "\n\n";

	}
	
	public boolean isOccupied() {
		
		return occupied;
		
	}


	public int getRoomNum() {
		return roomNum;
	}


	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}


	public String getBedType() {
		return bedType;
	}


	public void setBedType(String bedType) {
		this.bedType = bedType;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public StringBuilder getOccupantName() {
		return occupantName;
	}


	public void setOccupantName(StringBuilder occupantName) {
		this.occupantName.replace(0, this.occupantName.length(), occupantName.toString());
	}


	public char getSmoking() {
		return smoking;
	}


	public void setSmoking(char smoking) {
		this.smoking = smoking;
	}


	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	
	
	
}
