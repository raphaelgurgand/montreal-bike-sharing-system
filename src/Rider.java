// -------------------------------------------------------
// Assignment 4
// Written by: Raphael Gurgand 40331439
// For COMP 248 Section U – Winter 2026
// --------------------------------------------------------


public class Rider {

	// variable that stores the ID 
	private int riderID;
	
	// variable that stores the membership 
	private String riderMembership;
	
	private Trip[] trip = new Trip[30];
			
	// constructor method 
	public Rider( int riderID, String riderMembership) {
		
		this.riderID = riderID;
		this.riderMembership = riderMembership;
	
	}
	
	public double getDiscountRate() {
		// associates a discount rate depending on the membership that the rider has.
		
		if (riderMembership.equals("Kids")) {
			
			return 0.5;
			
		} else if (riderMembership.equals("Student")) {
			
			return 0.8;
			
		} else if (riderMembership.equals("Senior")) {
			
			return 0.6;
			
		} else {
			
			return 1;
		}
	}
	
	public double getTotalAmountDue() {
		// returns the total amount for a rider's finished trips
		
		double totalAmount = 0;
		
		// for loop that runs through every trip that the rider has possibly done and adds its amount due
		for (int i = 0; i< trip.length; i++) {
			
			// verifying that the trip exists
			if (trip[i] != null)
				totalAmount += trip[i].getAmountDue();
			
		}
		
		return totalAmount;
    }

    public boolean startTrip(String bikeType, Station startStation, int startTime) {
    	// method starting a trip for a specified bike type, starting station and starting time and returning true if possible,  false otherwise
    	
    	// while loop to get the index of the next available slot in the trip array
    	int i = 0;
    	while (i < trip.length && trip[i] != null) 
    		i++;
    	
    	
    	// creation of a new trip in the available spot
    	trip[i] = new Trip(bikeType, getDiscountRate());
    	

    	boolean possible = trip[i].checkIn(startStation, startTime);
    	
    	// if there weren't any bikes left, deleting the new trip.
    	if (!possible) {
    		
    		trip[i] = null;
    		
    	}
    	
    	return possible;
    	
    }
    
    public String endTrip(Station endStation, int endTime) {
    	// method ending a trip for a specified end station and end time, 
    	
    	// while loop to get the index of the last unavailable slot in the trip array
    	int i = 0;
    	
    	while (i < trip.length && trip[i] != null) 
    		i++;
    		
    	i--;
    	
    	// verifying that the trip is not already terminated
    	if (trip[i].getEndStation() == null)
    		trip[i].checkOut(endStation, endTime);
    	
    	return trip[i].toString();
    
    }

    @Override
    public String toString() {
    	// override of the toString() method, displaying a clear visual of the user's history as well as their ID and type of membership
    	
    	String display = String.format("ID: %d, Membership: %s\n", riderID, riderMembership);
    	
    	int i = 0;
    	while (i < trip.length && trip[i] != null) {
    		
    		display += trip[i].toString() + "\n";
    		i++;
    		
    	}
    	
    	display += String.format("Total amount due: %.2f", getTotalAmountDue());
    	
    	return display;
    	
    }
    
}
