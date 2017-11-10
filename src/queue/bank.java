package queue;

import java.util.*;

public class bank {

	public static void main(String[] args) {
		
		String restart = "y";
		Scanner input = new Scanner(System.in);
		while (!restart.equals("n")) {
			
			int numberOfCustomers = 0;
			teller[] tellers = new teller[5];
			for (int i = 0; i < 5; i++)
				tellers[i] = new teller();
			Queue<customer> line = new LinkedList<customer>();
			long startTime = System.nanoTime();
			while((System.nanoTime() - startTime) < 2000000000) {
				for (int i = 0; i < 5; i++)
					if(tellers[i].isAvailable()) {
						tellers[i].help(line.poll());
					}
						
			}
		}
		System.out.println("Restart simulation (y/n)?");
		restart = input.next();
	}

}
