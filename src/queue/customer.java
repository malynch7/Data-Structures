package queue;

import java.util.*;

public class customer {

	int helpTime;
	long startTime;
	long waitTime;
	Random r = new Random();
	
	public customer(long currentTime) {
		startTime = currentTime;
		
		helpTime = r.nextInt(5) + 2; 
	}
	
	public int getHelpTime() {
		return helpTime;
	}
}
