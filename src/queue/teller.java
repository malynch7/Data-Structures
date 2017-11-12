//For primary documentation, see bank.java.
package queue;

public class teller {
//This class represents a teller object for use with bank.java, capable of interacting with a customer object.
	
	boolean available;
	int customersHelped;
	int timeOccupied = 0;
	long nextAvailable;
	
	
	public teller() {
	//default constructor	
		available = true;
		customersHelped = 0;
	}
	
	public long help(customer customer, long currentTime) {
	/* Sets availability to false, sets next available time, and returns the customer's wait time.
	 * Pre: customer and currentTime must be initialized.
	 * Post: teller's availability is set to false and next available is increased.*/
		available = false;
		timeOccupied += customer.helpTime;
		customer.waitTime = currentTime - customer.startTime; 
		nextAvailable = currentTime + ((long)customer.getHelpTime() * 1000000000);
		customersHelped++;
		return customer.waitTime;
	}
	
	public boolean isAvailable() {
		return available;
	}
}
