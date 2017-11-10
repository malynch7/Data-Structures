/* Purpose: phonedir.java is a program that functions as a telephone directory. As such, it handles the input of new telephone records including name and telephone number,  
 * 	as well as the storing, editing, and deletion of records.
 * 
 * Solution: The program creates a linked list to hold customer objects containing Strings for first name, last name, and phone number. The program then enters 
 * 	a while loop filled with a switch statement, where it can accept various commands from the user for the selection, input, manipulation, and deletion of records in the 
 * 	linked list. The menu is displayed after each switch case completes. The current record is tracked by a pointer. Any new input is checked for validity by comparing to all 
 * 	records to ensure there is no duplication as well as checking the phone number format using regex. Then the program does a selective insert using a for-loop to keep the 
 * 	records organized by last name, and is set as the current record. The same process occurs when customer data fields are altered. There is also search functionality 
 * 	built-in that checks for customers containing data matching user input. The program terminates when the command "q" is given.
 * 
 * Data structures used:
 *  -LinkedList
 * 	-Integer
 * 	-String
 * 	-boolean
 * 
 * How to use: The program will prompt the user with a list of commands as well as display the currently selected record and do so after the execution of each command other 
 * 	than "q". Input will execute the corresponding command. The manipulation or deletion of data will apply to current record which will be set to any new/altered customer 
 * 	upon creation or can be selected using the "s" command via a list or search feature. The success or failure of a command will be displayed on screen. The command "q" 
 * 	will terminate the program.
*/
package linkedList;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class phonedir {

	static LinkedList<customer> directory = new LinkedList();
	static int currentRecord = -1 ;
	
	public static void main(String[] args) {
		System.out.println(" Phone Directory");
		System.out.println("-----------------");
		String command = "";
		Scanner input = new Scanner(System.in);
		customer tmp = new customer();
		while(!command.equals("q")) {
			menu();
			command = input.next().toLowerCase();
			switch(command) {
			case "a": //display directory
				if(directory.size() == 0) {
					System.out.println("The Directory is empty");
					break;
				}
				System.out.format("%-5s%-23s%-13s","ID","Name","Phone Number\n");
				System.out.format("%-5s%-23s%-13s","--","----","------------\n");
				int i = 1; 
				for(customer c: directory) {
					System.out.print(i + ")");
					c.display();
					i++;
				}
				break;
			case "d": //delete current record
				if(currentRecord < 0) {
					System.out.println("No record selected");
					break;
				}
				System.out.print("Record deleted: ");
				directory.get(currentRecord).display();
				directory.remove(currentRecord);
				currentRecord = -1;
				break;
			case "f": //Edit first name of current record
				if(currentRecord < 0) {
					System.out.println("No record selected");
					break;
				}
				tmp = new customer(directory.get(currentRecord));
				System.out.print("Input new first name: ");
				tmp.setFirstName(input.next());
				if(isValid(tmp)) {
					directory.remove(currentRecord);
					insert(tmp);
					break;
				}
				
				break;
			case "l": //Edit last name of current record
				if(currentRecord < 0) {
					System.out.println("No record selected");
					break;
				}
				tmp = new customer(directory.get(currentRecord));
				System.out.print("Input new last name: ");
				tmp.setLastName(input.next());
				if(isValid(tmp)) {
					directory.remove(currentRecord);
					insert(tmp);
					break;
				}
				break;
			case "p": //Edit phone number of current record
				if(currentRecord < 0) {
					System.out.println("No record selected");
					break;
				}
				tmp = new customer(directory.get(currentRecord));
				System.out.print("Input new phone number (xxx-xxx-xxxx): ");
				tmp.setPhone(input.next());
				if(isValid(tmp)) {
					directory.remove(currentRecord);
					insert(tmp);
					break;
				}
				break;
			case "n": //create new record
				System.out.print("Input new first name: ");
				String f = input.next();
				System.out.print("Input new last name: ");
				String l = input.next();
				System.out.print("Input new phone number (xxx-xxx-xxxx): ");
				String p = input.next();
				tmp = new customer(f,l,p);
				if(isValid(tmp)) {
					insert(tmp);
				}
				break;
			case "s": //select new current record
				if(directory.size() == 0) {
					System.out.println("The Directory is empty");
					break;
				}
				System.out.print("Select from list or search by name (l/s)? ");
				command = input.next().toLowerCase();
				if(command.equals("l")) { //select from list
					System.out.format("%-5s%-23s%-13s","ID","Name","Phone Number\n");
					System.out.format("%-5s%-23s%-13s","--","----","------------\n");
					int x = 1; 
					for(customer c: directory) {
						System.out.print(x + ")");
						c.display();
						x++;
					}
					System.out.print("\nSelect record (1-" + (x-1) + "): " );
					int r = input.nextInt();
					if( r< x) {
						currentRecord = r - 1;
						break;
					}else {
						System.out.println("Invalid");
						break;
					}
				}else if(command.equals("s")) { //search by name
					System.out.print("Input first name: ");
					String fn = input.next();
					System.out.print("Input last name: ");
					String ln = input.next();
					i=0;
					for(customer c: directory) {
						if(c.getFirstName().equalsIgnoreCase(fn) && c.getLastName().equalsIgnoreCase(ln)) {
							System.out.println("Match found");
							currentRecord = i;
							break;
						}
						i++;
					}
					if(i!=directory.size()) {
						break;
					}
					System.out.println("Match not found");
					break;
				}else {
					System.out.println("Illegal Command");
					break;
				}
				
			case "q":
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Illegal Command");
				break;
			}
		}
	}
	
	
	public static void menu() {
		/* Displays the current record as well as the command menu
		 *Pre: Current record and directory must be initialized
		 *Post: Current record and menu are output and printed on screen */
		System.out.print("\nCurrent record: ");
		if(currentRecord >= 0) {
		directory.get(currentRecord).display();
		}else {
			System.out.println("None");
		}
		System.out.println("\n Menu\n------");
		System.out.println("a) Show all records\nd) Delete current record\nf) Edit the first name in the current record\nl) Edit the last name in the current record\np) Edit phone number in the current record\nn) Create new record\ns) Select record from the record list to become the current record\nq) Quit");
		System.out.print("\nEnter a command from the list above:");
	}
	
	
	public static void insert(customer c) {
		/* Inserts new customer in correct alphabetical position by last name.
		 *Pre: Customer and directory must be initialized.
		 *Post: Directory will now include customer c in correct alphabetical order.*/
		for(int i = 0; i < directory.size(); i++) {
			if (c.getLastName().compareToIgnoreCase(directory.get(i).getLastName()) < 0) {
				directory.add(i, c);
				currentRecord = i;
				return;
			}
			if(c.getLastName().compareToIgnoreCase(directory.get(i).getLastName()) == 0) {
				if(c.getFirstName().compareToIgnoreCase(directory.get(i).getFirstName()) < 0) {
					directory.add(i, c);
					currentRecord = i;
					return;
				}
			}
		}
		directory.add(c);
		currentRecord = directory.size()-1;
	}
	
	
	public static boolean isValid(customer c) {
		/* Checks the validity of the phone number format and checks the directory to ensure this customer is not a duplicate.
		 *Pre: Customer and directory must be initialized.
		 *Post: Invalid printed if customer is a duplicate or contains an incorrectly formated phone number, and the function will return false. Otherwise, true is returned.*/
		Pattern p = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{4}");
		Matcher m = p.matcher(c.getPhone());
		if(!m.find()) {
			System.out.println("Invalid phone number. Please use format xxx-xxx-xxxx");
			return false;
		}
		for(customer x: directory ) {
			if(c.getFirstName().equalsIgnoreCase(x.getFirstName()) && c.getLastName().equalsIgnoreCase(x.getLastName()) && c.getPhone().equalsIgnoreCase(x.getPhone())) {
				System.out.println("Invalid: duplicate name and phone number already exists");
				return false;
			}
		}
		return true;
	}
	
}
