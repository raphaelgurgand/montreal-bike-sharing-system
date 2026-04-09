// -------------------------------------------------------
// Assignment 4
// Written by: Raphael Gurgand 40331439
// For COMP 248 Section U – Winter 2026
// --------------------------------------------------------


public class Trip {
	
	// variable that stores the type of the bike used
	private String bikeType;
	
	// variable that stores the station of depart 
	private Station startStation; 
	
	// variable that stores the station of arrival
	private Station endStation;
	
	// variable that stores the time of depart
	private int startTime;
	
	// variable that stores the time of arrival 
	private int endTime;
	
	// variable that stores the discountRate 
	private double discountRate;
	
	
	// constructor method, taking parameters and creating a correct instance of the class Trip
	public Trip(String bikeType, double discountRate) {
		
		this.bikeType = bikeType;
		this.discountRate = discountRate;
		
	}

	public boolean checkIn(Station startStation, int startTime) {
		// checks out a bike from a specified station at a specified time and returns true if it was possible and false otherwise
		
		boolean possible = startStation.checkOutBike(this.bikeType, startTime);
		
		if (possible) {
			
			this.startStation = startStation;
			this.startTime = startTime;
			
		}
		
		return possible;
	} 
	
	public double checkOut(Station endStation, int endTime) {
		// checks in one bike from a specified station at a specified time and returns the cost of the trip 
		
		// sets the end Station and end time to the trip
		this.endStation = endStation;
		this.endTime = endTime;
				
		// returns the bike to the station
		endStation.returnBike(this.bikeType, endTime);
		
		double revenue = getAmountDue();
		
		// adds half of the revenue to each station used
		this.startStation.addToRevenue(revenue/2);
		this.endStation.addToRevenue(revenue/2);
		
		// returns the amount due
		return revenue;
		
	}
	
	public double getAmountDue() {
		// returns the cost of an instance of the class trip
		
		// if statement to determine which tariffs are going to be applied depending on the type of bike used
		if (this.bikeType.equals("Standard")) {
			// base rate == 1
			
			return (this.endTime - this.startTime) * this.discountRate;
			
		} else if (this.bikeType.equals("E-bike")) {
			// base rate == 5
			
			return (this.endTime - this.startTime) * this.discountRate * 5;
			
		} else if (this.bikeType.equals("Kids")) {
			// base rate == 0.5
			
			return (this.endTime - this.startTime) * this.discountRate * 0.5;
			
		} else {
			// base rate == 3
			
			return (this.endTime - this.startTime) * this.discountRate * 3;
			
		}
		
	}
	
	public Station getStartStation() {
		// returns the start station of an instance of Trip
		
		return this.startStation;
		
	}
	
	public Station getEndStation() {
		// returns the end station of an instance of Trip
		
		return this.endStation;
		
	}
	
	public int getStartTime() {
		// returns the start time of an instance of Trip
		
		return this.startTime;
		
	}
	
	public int getEndTime() {
		// returns the end time of an instance of Trip
		
		return this.endTime;
				
	}
	
	@Override
	public String toString() {
		// override of the toString method that returns a clear display of the informations concerning an instance of Trip
		
		return "[Start: " + startStation.getName() + " at " + startTime + ", End: " + endStation.getName() + " at " + endTime + ", Bike: " + bikeType 
				+ ", Amount due: " + String.format("%.2f]", getAmountDue());
	}
	
}
