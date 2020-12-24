package com.victor;
import java.sql.SQLException;
import java.util.Scanner;

public class HotelTest {

    
     
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		
		Hotel hotel = new Hotel("The Warm Onion", "4354 philly");
	
		//add 10 rooms to the hotel -----NOTE TO SELF: this will not get added again if we already have 10 rooms in our database :)
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
		hotel.addRoom(525, "twin", 's', 45.43); 
		
		while(true) {
		System.out.println("\nPlease select an option. Type the corresponding number and press enter:\n");
		System.out.println("1. Add reservation          2. Remove reservation" +'\n'
		                  +"3. Print reservations       4. Get daily sales " + '\n' 
				          +"5. Occupation percentage    6. Print all rooms");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		switch(option){
			
		case 1: reserve(hotel); break;
		
		case 2: remove(hotel); break;
		
		case 3: hotel.printReservationList();break;
		
		case 4: System.out.println("The daily sales: " +  hotel.getDailySales());break;
		
		case 5: System.out.println("Current occupacy percentage is " + hotel.occupancyPercentage() + "\n"); ;break;
		
		case 6: System.out.println(hotel);
			
		}
		
	}
		/*hotel.addReservation("Claudia",'s', "king");
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
        
        	
        
        
		*/
		
	}
	
	public static void reserve(Hotel hotel) throws ClassNotFoundException, SQLException {
		
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Please enter the name for the reservation");
	String name = sc.next();
	
	System.out.println("Would you like a smokers room? (type s or n)");
	String smoke = sc.next();
	char smokingRoom = smoke.charAt(0); 
		
	System.out.println("What bedsize? type in 'queen', 'king', or 'twin'");
	String bedsize = sc.next();
	
	hotel.addReservation(name,smokingRoom, bedsize);
	
	
	}
	
	public static  void remove(Hotel hotel) throws ClassNotFoundException, SQLException {
		
		System.out.println("Please enter the name of the person that youd like to cancel the reservation for");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		
	    hotel.cancelReservation(name);
		
	}
}
