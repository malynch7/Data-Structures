//For primary documentation, see bank.java.
package queue;

import java.util.*;

public class customer {
//This class represents a customer object for use with bank.java.
	
	int helpTime;
	long startTime;
	long waitTime;
	Random r = new Random();
	
	public customer() {
	//default constructor
		startTime = System.nanoTime();
		helpTime = r.nextInt(4) + 2; 
	}
	
	public customer(long currentTime) {
	/* Constructor requiring a valid current time.
	 * Pre: currentTime must be initialized.
	 * Post: customer contains start time and help time*/
		startTime = currentTime;
		helpTime = r.nextInt(4) + 2; 
	}
	
	public int getHelpTime() {
		return helpTime;
	}
}
