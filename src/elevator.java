/*
Purpose: elevator.java is a program designed to simulate the behavior and movement pattern of a 12-story building's elevator. All required methods are contained in this 
	class.

Solution: The Program will build two ArrayLists. It will fill the first with 8 randomly generated floors, using java's Random utility to generate integers, 2-12, within a 
	"while" loop, and using an  "if" loop to check for and eliminate redundancy. The second ArrayList will be created using the same process to generate 5 unique floors, 
	1-11. These will be the elevator's up and down queues, respectively. The elevator will iterate through each list concurrently, checking to ensure the corresponding queue
	is not empty, the pulling the next floor. The program then calls the "moveUp" or "moveDown" method, which uses a "for" loop to display the direction of movement for the 
	elevator as well as iterate through the floors, at 2 second intervals, until the desired floor is reached. The elevator will then stop for 3 seconds before proceeding, 
	remove that floor from its ArrayList, and proceed to the next floor until the queue is empty. When the program is complete, it will prompt the user to either restart or 
	terminate the program.
	
Data Structures Used: 
	-Arraylists
	-Integers
	-Strings

How To Use The Program:
	The program requires no initial input. It will display the randomly generated queues and begin the simulation, outputting the direction of motion,current floor and wait 
	time. The only user input is prompted for and used, after both queues are empty, in order to restart the program.


*/
import java.util.*;
import java.util.concurrent.TimeUnit;

public class elevator {

	static int currentFloor;
	static String restart = "y";
	
	public static void main(String[] args) {
		while(restart.equals("y")) {
			currentFloor = 1;
			ArrayList<Integer> upQueue= new ArrayList<Integer>(12);
			ArrayList<Integer> downQueue= new ArrayList<Integer>(12);
			Random r = new Random();
			while(upQueue.size() < 8) {
				int floorRequest = r.nextInt(11)+2;
				if(!upQueue.contains(floorRequest))
				upQueue.add(floorRequest);
			}
			Collections.sort(upQueue);
			while(downQueue.size() < 5) {
				int floorRequest = r.nextInt(11)+1;
				if(!downQueue.contains(floorRequest))
				downQueue.add(floorRequest);
			}
			Collections.sort(downQueue);
			Collections.reverse(downQueue);
			System.out.println("Up Queue:");
			System.out.println(upQueue);
			System.out.println("Down Queue:");
			System.out.println(downQueue);
			System.out.println();
			while(!upQueue.isEmpty()) {
				moveUp(upQueue.get(0));
				upQueue.remove(0);
			}
			while(!downQueue.isEmpty()) {
				moveDown(downQueue.get(0));
				downQueue.remove(0);
			}
			System.out.println();
			System.out.println("Up Queue:");
			System.out.println(upQueue);
			System.out.println("Down Queue:");
			System.out.println(downQueue);
			System.out.println();
			System.out.println("Do you want to run the elevator again? (y/n)");
			Scanner input = new Scanner(System.in);
			restart = input.nextLine();
		}	
		System.out.println("Turning off elevator... Goodbye.");
	}
	
	public static void moveUp(int nextStop) {
		/* This method simulates the upward motion of the elevator, iterating sequentially from the current floor to the next stop.
		 * 
			Preconditions: The current floor must be initialized and lower than the integer passed as the next stop.
			
			Post conditions: The method will display the direction of motion as well as current floor and wait time of the elevator. The current floor will now be equal to 
			the integer passed as the next stop.
		*/
		System.out.println("Starting at floor " + currentFloor);
		for( ; currentFloor < nextStop; ) {
			currentFloor++;
			System.out.print("Going up... ");
			try{
				TimeUnit.SECONDS.sleep(2);
			}catch(InterruptedException ie) {
				
			}
			System.out.println("Now at floor " + currentFloor);
		}
		System.out.print("Stopping at floor " + currentFloor + " for 3 seconds... ");
		for(int i = 1; i < 4; i++) {
			try{
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException ie) {
				
			}
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
	}
	
	public static void moveDown(int nextStop) {
		/* This method simulates the downward motion of the elevator, iterating reverse-sequentially from the current floor to the next stop.
		 * 
			Preconditions: The current floor must be initialized and higher than the integer passed as the next stop.
			
			Post conditions: The method will display the direction of motion as well as current floor and wait time of the elevator. The current floor will now be equal to 
			the integer passed as the next stop.
		*/
		System.out.println("Starting at floor " + currentFloor);
		for( ; currentFloor > nextStop; ) {
			currentFloor--;
			System.out.print("Going down... ");
			try{
				TimeUnit.SECONDS.sleep(2);
			}catch(InterruptedException ie) {
				
			}
			System.out.println("Now at floor " + currentFloor);
		}
		System.out.print("Stopping at floor " + currentFloor + " for 3 seconds... ");
		for(int i = 1; i < 4; i++) {
			try{
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException ie) {
				
			}
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
	}
}
