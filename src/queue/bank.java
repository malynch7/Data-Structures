/* Purpose: bank.java simulates customer movement through a bank queue with 5 tellers. It calculates average wait time, time occupied by each teller,
 * 	and the number of customers served within a 120 second time period.
 * 
 * Solution: The program creates an array of 5 tellers and a queue of 5 customers, each with their own help time, in seconds, generated by a random
 *  integer. It then enters a while loop that repeats until the total elapsed time of the program exceeds 120 seconds. Within this loop, the program
 *  stores the new current time and prints out an updated elapsed time in increments of 10 seconds. It stores the next customer arrival time, using 
 *  a random integer between 2 and 6. If the current time exceeds or equals the last arrival time plus the next arrival time, a new customer is 
 *  added to the queue, the number of customers is incremented by 1, and a new next arrival time is generated. Then each teller is checked for 
 *  availability. If available, a customer is polled from the queue and the teller's next available time is set to the current time plus the 
 *  customer's help time. If unavailable, the teller's next available time is compared to the current time. If the current time exceeds or equals 
 *  the teller's next available time, the teller is set to available. After loop terminates, the simulation is done and a for loop prints out the 
 *  results. The program is contained in a while loop that allows the program to restart unless the user enters "n".
 * 
 * Data structures used:
 *  -Queue
 *  -LinkedList
 * 	-Integer
 *  -Long
 * 	-String
 * 	-Boolean
 * 
 * How to use: The program will begin simulation upon launch. The elapsed time will be printed in increments of 10 seconds, until the simulation is 
 * 	is complete. After which, the results will be printed on screen, and the user will be prompted to restart the program. A user entry of "n" will 
 * 	terminate the program.
 * 
*/
package queue;

import java.util.*;

public class bank {

	public static void main(String[] args) {
		
		String restart = "y";
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		
		while (!restart.equals("n")) {
			
			teller[] tellers = new teller[5];
			Queue<customer> line = new LinkedList<customer>();
			int numberOfCustomers = 5;
			long totalWaitTime = 0;
			long elapsedTime;
			long nextArrival = (1000000000 * (long)(r.nextInt(5) + 2));
			long currentTime = System.nanoTime();
			long startTime = currentTime;
			long lastArrival = startTime;
			
			for (int i = 0; i < 5; i++) {
				tellers[i] = new teller();
				line.add(new customer(currentTime));
			}
			
			System.out.print("\nBeginning simulation...\n\n120s remaining\n");
			while((elapsedTime = (currentTime = System.nanoTime()) - startTime)/1000000000 < 120) {
				if (elapsedTime / 10 % (1000000000)  == 0)
					System.out.println((120 - (elapsedTime/1000000000)) + "s remaining ");
				if(currentTime >= lastArrival + nextArrival ) {
					lastArrival = currentTime;
					line.add(new customer(currentTime));
					numberOfCustomers++;
					nextArrival = 1000000000 * (r.nextInt(5) + 2);
				}
				for (int i = 0; i < 5; i++) {
					if(tellers[i].isAvailable()) {
						if (!line.isEmpty())
							totalWaitTime += tellers[i].help(line.poll(), currentTime);
					}else{
						if (currentTime >= tellers[i].nextAvailable) 
							tellers[i].available = true;
					}
				}
			}
			System.out.println("\n\nSimulation complete. \n\nTotal number of customers: " + numberOfCustomers);
			System.out.println("Average wait time: " + (totalWaitTime / (numberOfCustomers - 5) / 1000000000 ) + "s");
			for (int i = 0; i < 5; i++) 
				System.out.println("teller " + (i + 1) + " helped " + tellers[i].customersHelped + " customers, and was occupied for " + tellers[i].timeOccupied + "s.");
			System.out.println(line.size() + " customers did not see a teller.\n");
			System.out.println("Restart simulation (y/n)?");
			restart = input.next();
		}
	}
}
