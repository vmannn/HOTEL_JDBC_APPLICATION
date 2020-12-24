import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Hotel {

	private static final int NOT_FOUND = -1;
	private String name;
	private String location;
	private int occupationCount;
	//private Room rooms[];
	private ArrayList <Room> rooms;
	private int numOfRooms;
	Database myDatabase;
	
	
	public Hotel() {
		
		rooms = new ArrayList<Room>();
		myDatabase = new Database();
		name = null;
		location = null;
		occupationCount = 0;
		
	}
	
	public Hotel(String name, String location) throws ClassNotFoundException, SQLException {
		
		numOfRooms = 0;
		myDatabase = new Database();
		myDatabase.setHotel(name, location);
		this.name = name;
		this.location = location;
		rooms = new ArrayList<Room>();
		
	}
	
	public void addRoom(int roomNumber, String bedType, char smoking, double rate) throws ClassNotFoundException, SQLException {
		
		
		rooms.add(new Room(roomNumber, bedType, smoking, rate));
		myDatabase.addRoom(roomNumber, bedType, smoking, rate);
		numOfRooms += 1;
		
	    System.out.println("Cannot add any more rooms.");
	}
	
	
	public boolean isFull() {
		
		if(occupationCount >= 10)
				return true;
		else
			return false;
	}
	
	public boolean isEmpty() {
		
		if(occupationCount <= 0) 	
			return true;
		
		else
			return false;
				
	}
	
	public void addReservation(String name, char smoking, String bedType) throws ClassNotFoundException, SQLException {
		StringBuilder sb = new StringBuilder();
		for(Room a: rooms){
			
			if(a.isOccupied())
				continue;
			
			if(smoking == a.getSmoking()){
				
				if(bedType.equals(a.getBedType())) {
					a.setOccupantName(sb.append(name));
					a.setOccupied(true);
					System.out.println("Reservation for " + name + " Successfully created!");
					occupationCount += 1;
					myDatabase.addReservation(name, smoking, bedType);
					return;	
				}
			}		
		}
			
		System.out.println("Cannot make a reservation for " + name + " :(" );	
		
		}	
	

	private int findName(StringBuilder name) {
		
		for(int i = 0; i < rooms.size(); ++i) {
			
			if(rooms.get(i).getOccupantName().toString().equals(name.toString())) {
				
				return i;
				
			}	
		}
		
		return NOT_FOUND;
	}
	
    public void cancelReservation(String name) throws ClassNotFoundException, SQLException {
    
    	StringBuilder sb = new StringBuilder();
    	int i = findName(sb.append(name));
    	sb.replace(0, sb.length(), "Not Occupied");
    	
    	try {
    	rooms.get(i).setOccupied(false);
    	rooms.get(i).setOccupantName(sb);
    	occupationCount -= 1;
    	myDatabase.cancelReservation(name);
    	}
    	catch(ArrayIndexOutOfBoundsException e) {
    		
    		System.out.println("No reservation was made for " + name + " so nothing to cancel...");
    		
    	}
    	
    }
    
    public int findReservation(String name) {
    	
    	int i = 0;
    	for(Room r: rooms) {
    		
    		if(r.getOccupantName().equals(name)) {
    			return i;		
    		}
    		++i;
    	}  	
    	return NOT_FOUND;
    }
    
    public void printReservationList() {
    	
    	for(Room r: rooms) {
    		
    		if(r.isOccupied()) {
    			
    			System.out.println("Room number: " + r.getRoomNum());
    			System.out.println("Occupant name: " + r.getOccupantName());
    			System.out.println("Smoking room: " + r.getSmoking());
    			System.out.println("Bed type: " + r.getBedType());
    			System.out.println("Rate: " + r.getRate() + "\n");
    		
    		}	
    	}	
    }
	
    public double getDailySales() {
    	
    	
    	 double total = 0;
         for(Room r: rooms) {
        	 
        	 if(r.isOccupied()) {
        		 total += r.getRate();    
        	 }
         }
         
         return total;
    }
    
    
    public double occupancyPercentage() {
    	
    	
        return (double) occupationCount/rooms.size();
 	    
     
    }
    
    
    
    @Override
    public String toString() {
    	
    	return "Hotel name: " + name + "\n"
    	+ "Location: " + location + "\n"
    	+ "Number of rooms: " + numOfRooms + "\n"
    	+ "Number of occupied rooms: " + occupationCount + "\n\n"
    	
    	+"Room details are:\n\n" + rooms;
    		
    	
    }
	
    }
    
    
    
	
	
	
	
