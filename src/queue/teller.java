package queue;

import java.util.concurrent.TimeUnit;

public class teller {

	boolean available;
	int customersHelped;
	int timeOccupied = 0;
	long nextAvailable;
	
	
	public teller() {
		available = true;
		customersHelped = 0;
	}
	
	public long help(customer customer, long currentTime) {
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
