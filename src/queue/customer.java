package queue;

import java.util.*;

public class customer {

	int helpTime;
	long startTime;
	long waitTime;
	
	public customer() {
		startTime = System.nanoTime();
		Random r = new Random();
		helpTime = r.nextInt(5) + 2; 
	}
	
	public int getHelpTime() {
		return helpTime;
	}
}
