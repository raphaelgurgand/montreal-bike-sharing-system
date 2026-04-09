// -------------------------------------------------------
// Assignment 4
// Written by: Raphael Gurgand 40331439
// For COMP 248 Section U – Winter 2026
// --------------------------------------------------------


public class BikeSharingSystem {
	
    private Station concordia;
    private Station mcgill;
    private Station udem;
    private Station uqam;
    private Station ets;

    public BikeSharingSystem() {
        this.concordia = new Station("Concordia", 5, 5, 5, 5);
        this.mcgill = new Station("McGill", 5, 5, 5, 5);
        this.udem = new Station("UdeM", 5, 5, 5, 5);
        this.uqam = new Station("UQAM", 5, 5, 5, 5);
        this.ets = new Station("ETS", 5, 5, 5, 5);
    }

    public void run() {

    	System.out.println(concordia); 					// Print the inventory of Concordia Station
    	
    	Rider rider1 = new Rider(1, "Adult"); 
    	Rider rider2 = new Rider(2, "Student"); 		// Create one adult rider object: Rider1 (ID: 1) and one student rider object: Rider2 (ID: 2)
    	
    	System.out.println();
    	
    	rider1.startTrip("Standard", concordia, 5); 	// Rider1 checks out a Standard bike from 
    	System.out.println(rider1.endTrip(mcgill, 10)); // Concordia at 05:00 and returns it to McGill at 10:00.  Print the trip details
    	
    	System.out.println();
    	
    	rider1.startTrip("E-bike", udem, 12);			// Rider1 checks out an E-Bike from UdeM at 12:00 
    	System.out.println(rider1.endTrip(udem, 15));	// and returns it to UdeM at 15:00. Print the trip details

    	System.out.println();
    	
    	System.out.println(rider1);						//  Print the summary of Rider1
    	
    	System.out.println();
    	
    	System.out.println(mcgill);						// Print the inventory of McGill Station
    	
    	System.out.println();
    	
    	rider2.startTrip("Tandem", uqam, 2);			// Rider2 checks out a Tandem from UQAM at 02:00
    	System.out.println(rider2.endTrip(udem, 14));	// and returns it to UdeM at 14:00. print the details.
    	
    	System.out.println();
    	
    	System.out.println(rider2);						//  Print the summary of Rider2
    	
    	System.out.println();
    	
    	System.out.println(udem);						// Print the inventory of UdeM Station.
    	
    	System.out.println();
    	
    	System.out.println(udem.getRevenue());			// Print the revenue of UdeM Station.
    }

    public static void main(String[] args) {

        BikeSharingSystem system = new BikeSharingSystem();
        system.run();
        
    }
}
