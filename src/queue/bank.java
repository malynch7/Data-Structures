package queue;

import java.util.*;

public class bank {

	public static void main(String[] args) {
		
		String restart = " ";
		Scanner input = new Scanner(System.in);
		while (!restart.equals("n")) {
			int numberOfCustomers = 5;
			long totalWaitTime = 0;
			teller[] tellers = new teller[5];
			Queue<customer> line = new LinkedList<customer>();
			for (int i = 0; i < 5; i++) {
				tellers[i] = new teller();
				line.add(new customer());
			}
			Random r = new Random();
			System.out.print("\nBeginning simulation...\n\n120s remaining\n");
			long startTime = System.nanoTime();
			long nextArrival = (1000000000 * (long)(r.nextInt(5) + 2));
			long lastArrival = startTime;
			long elapsedTime;
			while((elapsedTime = System.nanoTime() - startTime)/1000000000 < 120) {
				if (elapsedTime / 10 % (1000000000)  == 0)
					System.out.println((120 - (elapsedTime/1000000000)) + "s remaining ");
				if(System.nanoTime() > lastArrival + nextArrival ) {
					lastArrival = System.nanoTime();
					line.add(new customer());
					numberOfCustomers++;
					nextArrival = 1000000000 * (r.nextInt(5) + 2);
				}
				for (int i = 0; i < 5; i++) {
					if(tellers[i].isAvailable()) {
						if (!line.isEmpty())
							totalWaitTime += tellers[i].help(line.poll());
					}else{
						if (System.nanoTime() >= tellers[i].nextAvailable) {
							tellers[i].available = true;
						}
												}
				}
				
				}
				System.out.println("\n\nSimulation complete. \n\nTotal number of customers: " + numberOfCustomers + "\nAverage wait time: " + (totalWaitTime / 1000000000 /numberOfCustomers) + "s");
				for (int i = 0; i < 5; i++) {
					System.out.println("teller " + (i + 1) + " helped " + tellers[i].customersHelped + " customers, and was occupied for " + tellers[i].timeOccupied + "s.");
				}
				System.out.println(line.size() + " customers did not see a teller.\n");
				System.out.println("Restart simulation (y/n)?");
				restart = input.next();
		}
	}

}
