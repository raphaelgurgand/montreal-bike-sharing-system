// -------------------------------------------------------
// Assignment 4
// Written by: Raphael Gurgand 40331439
// For COMP 248 Section U – Winter 2026
// --------------------------------------------------------


public class Station {
	
	// variable that stores the name of the station
	private String name;
	
	// variable that stores a list of objects BikeInventory for each type of bike (there are 4 so the array size is 4)
	private BikeInventory[] inventory = new BikeInventory[4];
	
	// variable that stores the total revenue of the station, initialized to 0
	private double revenue = 0.0;
	
	// constructor method, taking a name and the amount of bikes of each type at the start, creating a correct instance of the class Station
	public Station(String name, int standard, int ebike, int kid, int tandem){
		
		this.name = name;
		
		this.inventory[0] = new BikeInventory("Standard", new int[24]);
		this.inventory[0].addBike(0, standard);
		
		this.inventory[1] = new BikeInventory("E-bike", new int[24]);
		this.inventory[1].addBike(0, ebike);
		
		this.inventory[2] = new BikeInventory("Kids", new int[24]);
		this.inventory[2].addBike(0, kid);
		
		this.inventory[3] = new BikeInventory("Tandem", new int[24]);
		this.inventory[3].addBike(0, tandem);
	}
	
	
	public String getName() {
		// returns the name of the Station
		
		return this.name;
		
	}
	
	
	public int getTotalBikes(int time) {
		// returns the number of TOTAL bikes at a given time at this station
		
		int total = 0;
		
		for (int i = 0; i < 4; i++) {
			
			total += this.inventory[i].getNumOfBikes(time);
		}
		
		return total;
	}
	
	
	public BikeInventory getInventoryOfType(String bike) {
		// returns the inventory of a bike type given its name
		
		if (bike.equals("Standard")) {
			
			return this.inventory[0];
			
		} else if (bike.equals("E-bike")) {
			
			return this.inventory[1];
			
		} else if (bike.equals("Kids")) {
			
			return this.inventory[2];
			
		} else {
			
			return this.inventory[3];
		}
		
	}
	
	
	public int checkInventory(String bike, int time) {
		// returns the number of bikes of a specified type at a specified time
		
		return this.getInventoryOfType(bike).getNumOfBikes(time);
		
	}
	
	
	public boolean checkOutBike(String bike, int time) {
		// removes if possible one bike of a specified type and at a specified time from the station and returns true if it was possible, false otherwise
		
		return this.getInventoryOfType(bike).removeBike(time, 1);
		
	}
	
	
	public void returnBike(String bike, int time) {
		// adds one bike of a specified type at specified time to the station and returns nothing
		
		this.getInventoryOfType(bike).addBike(time, 1);
	}
	
	public double getRevenue() {
		// returns the revenue of a station

		return this.revenue;
	}
	
	public void addToRevenue(double revenue) {
		// adds to the revenue of a station

		this.revenue += revenue;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		// override of the default equals method, returns true if both stations have the same revenue and false otherwise
		
		// making sure that two Stations are compared
		if (!(obj instanceof Station))
			return false;
		
		// converting the object to a station in order to compare
		Station other = (Station) obj;
		
		return other.revenue == this.revenue;
		
	}
	
	@Override
	public String toString() {
		// returns a display of a table representing the station, printing the amount of each type of bike at each hour of the day as well as the total
		
		String display = "											=== Bike inventory of " + this.name + " station ===\n\n" + "hour\t";
		
		for (int i = 0; i < 24; i++) {
			
			display += "\t" + i;
			
		}
		
		display += "\n\t\t------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
		
		for (int i = 0; i < 4; i++) {
			
			display += this.inventory[i].toString() + "\n";
		}

		
		display += String.format("%8s", "Total");
		
		for (int i = 0; i < 24; i++) {
			
			display += "\t" + this.getTotalBikes(i);
			
		}
		
		return display;
	}
	
}

