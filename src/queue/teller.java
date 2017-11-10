package queue;

import java.util.concurrent.TimeUnit;

public class teller {

	boolean available;
	int customersHelped;
	int timeOccupied;
	
	
	public teller() {
		available = true;
		customersHelped = 0;
	}
	
	public void help(customer customer) {
		available = false;
		timeOccupied += customer.getHelpTime();
		customer.waitTime = System.nanoTime() - customer.startTime; 
		try{
			TimeUnit.SECONDS.sleep(customer.getHelpTime());
		}catch(InterruptedException ie) {
			
		}
		customersHelped++;
		available = true;
	}
	
	public boolean isAvailable() {
		return available;
	}
}