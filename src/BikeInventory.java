// -------------------------------------------------------
// Assignment 4
// Written by: Raphael Gurgand 40331439
// For COMP 248 Section U – Winter 2026
// --------------------------------------------------------



public class BikeInventory {
	
	// variable that stores the type of bike
	private String bikeType;
	
	// variable that stores the number of bikes for each hour of the day
	private int[] bikeNum;
	
	// constructor method, taking two arguments to return a correct instance of the class BikeInventory
	public BikeInventory(String bikeType, int[] bikeNum) {
		
		this.bikeType = bikeType;
		this.bikeNum = bikeNum;
	}
	
	// returns the number of bikes at a specified time
	public int getNumOfBikes(int time) {
		
		return this.bikeNum[time];
	}
	
	// method that adds the desired amount of bikes at a specified time and for the rest of the day, doesn't return anything
	public void addBike(int time, int num) {
		
		for ( int i = time ; i < 24; i++) {
			
			this.bikeNum[i] += num;
		}
	}
	
	// method that removes the desired amount of bikes at a specified time and for the rest of the day, returns true if the action was possible and false otherwise
	public boolean removeBike(int time, int num) {
		
			if (this.bikeNum[time] >= num) {
				
				for (int i = time; i < 24; i++) {
					
					this.bikeNum[i] -= num;
				}
				
				return true;
				
			} else {
				
				return false;
			}

	}
	
	@Override
	public String toString() {
		// method that returns a display of the instance of BikeInventory, with the bikeType, and then the number of bikes for each hour in a clear way
		
		String display = String.format("%8s", this.getBikeType());
		
		for (int i = 0; i < 24; i++) {
			
			display+= "\t" + this.bikeNum[i];
		}
		
		return display;
		
	}
	
	// method that returns the type of bike of the class
	public String getBikeType() {
		
		return this.bikeType;
		
	}
	
}
