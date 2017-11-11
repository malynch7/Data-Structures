package queue;

import java.util.*;

public class bank {

	public static void main(String[] args) {
		
		String restart = "y";
		Scanner input = new Scanner(System.in);
		while (!restart.equals("n")) {
			int numberOfCustomers = 5;
			double totalWaitTime = 0;
			teller[] tellers = new teller[5];
			Queue<customer> line = new LinkedList<customer>();
			for (int i = 0; i < 5; i++) {
				tellers[i] = new teller();
				line.add(new customer());
			}
			Random r = new Random();
			System.out.println("\nBeginning Simulation...");
			double startTime = System.nanoTime();
			double nextArrival = 1000000000 * (r.nextInt(5) + 2);
			double lastArrival = startTime;
			
			while((System.nanoTime() - startTime)/1000000000 < 120) {
				System.out.println("elapsed time: " + (System.nanoTime() - startTime));
				if(System.nanoTime() > lastArrival + nextArrival ) {
					lastArrival = System.nanoTime();
					line.add(new customer());
					numberOfCustomers++;
					nextArrival = 1000000000 * (r.nextInt(5) + 2);
				}
				for (int i = 0; i < 5; i++) {
					if(tellers[i].isAvailable()) {
						totalWaitTime += tellers[i].help(line.poll());
					}
				}
				System.out.println("Simulation conplete. \nTotal number of customers: " + numberOfCustomers);
				for (int i = 0; i < 5; i++) {
					System.out.println("teller " + (i + 1) + " helped " + tellers[i].customersHelped + " customers, and was occupied for " + tellers[i].timeOccupied + "s.");
				}
				System.out.println(line.size() + " customers did not see a teller");
			}
			System.out.println("Restart simulation (y/n)?");
			restart = input.next();
		}
	}

}
