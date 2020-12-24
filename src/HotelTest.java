import java.sql.SQLException;

public class HotelTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		
		Hotel hotel = new Hotel("The Warm Onion", "4354 philly");
	
		//add 10 rooms to the hotel
		hotel.addRoom(46, "king", 's', 12.50);
		hotel.addRoom(23, "twin", 'n', 9.56);
		hotel.addRoom(35, "queen", 'n', 9.32);
		hotel.addRoom(545, "twin", 's', 45.43);
		hotel.addRoom(67, "king", 'n', 115.54);
		hotel.addRoom(34, "queen", 's', 134.54);
		hotel.addRoom(434, "king", 's', 12.50);
		hotel.addRoom(232, "twin", 'n', 9.56);
		hotel.addRoom(354, "queen", 'n', 9.32);
		hotel.addRoom(525, "twin", 's', 45.43);
		hotel.addRoom(525, "twin", 's', 45.43); //This room should fail to be added 
		
		hotel.addReservation("Claudia",'s', "king");
		hotel.addReservation("Arnold", 'n', "twin");
        hotel.addReservation("Spencer", 's', "queen");
        hotel.addReservation("Miles", 'n', "queen");
        hotel.addReservation("Eric", 's', "king");
        hotel.addReservation("Paulina", 's', "king"); //should fail to reserve (no more rooms of this kind for paulina)
        hotel.addReservation("Janette", 'n', "queen");
        
        
       
        System.out.println("\n\n\nUse the hotels toString() method");
		System.out.println("\n" + hotel);  //Use the hotels toString() method
		
        hotel.cancelReservation("Janette");
        
        if(hotel.findReservation("Janette") == -1)
        	 System.out.println("Janette removed sucessfully.. checked from main test with findReservation() method"); // test if Janette was really removed
        
        
        System.out.println("Daily sales for the hotel were " + hotel.getDailySales());      //test sales and occupancy 
        System.out.println("Current occupacy percentage is " + hotel.occupancyPercentage() + "\n\n\n"); 
        
        System.out.println("Print the reservation list with the function\n\n");
        //Print the reservation list with the function
        hotel.printReservationList();
        
        	
        
        
		
		
	}

}
