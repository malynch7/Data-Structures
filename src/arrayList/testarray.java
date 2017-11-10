/*Purpose: The purpose of the program is to create a class that emulates java's built-in ArrayList Data structure and test its functionality.
 *
 *Solution: The ArrayList class uses the array data structure as a container for the ArrayList's data. This array is then manipulated through
 * various methods, the most important of which is grow(). This method is called when the array is too full for a method to be completed. The
 * method creates a new array of double the original array's size, copies all existing elements from the old array at their proper index, and 
 * substitutes the new array for the old. The methods within the class only interact with current non-null elements, as well. This gives the 
 * ArrayList the illusion of having a variable size, as all non-null elements remain at the lowest index during methods such as add() or 
 * remove().
 *
 *Data Structures used:
 * -ArrayList (custom)
 * -Array
 * -Integer
 * -String
 * -boolean
 *
 *How to use the program:
 * The program will only prompt for input one time during the creation of ArrayList B. It will test the functionality of all methods and 
 * display their results on screen, as well as periodically printing the ArrayLists in cases where user verification is necessary.
*/

package arrayList;
import java.util.*;


public class testarray {
	//This is a driver program used to test the functionality of the ArrayList data structure and its contained methods.
	public static void main(String[] args) {
		System.out.println("Generating ArrayList A using default constructor...");
		ArrayList a = new ArrayList();
		System.out.println("\nArrayList A: " + a.toString());
		Scanner input = new Scanner(System.in);
		System.out.println("\nInput initial size for ArrayList B:");
		ArrayList b = new ArrayList(input.nextInt());
		System.out.println("\nGenerating ArrayList B using the ArrayList(int n) constructor...");
		System.out.println("\nArrayList B: " + b.toString()+"\n");
		System.out.println("Are the ArrayLists Empty? (isEmpty())\nA: " + a.isEmpty() + "\nB: " + b.isEmpty());
		System.out.println("\nFilling each ArrayList with 15 randomly generated integers using add(Object x)...");
		Random r = new Random();
		for(int i = 0; i < 15; i++) {
			a.add(r.nextInt(25)+1);
			b.add(r.nextInt(25)+1);
		}
		System.out.println("\nArrayList A: " + a.toString());
		System.out.println("ArrayList B: " + b.toString() + "\n");
		System.out.println("Are the ArrayLists Empty? (isEmpty())\nA: " + a.isEmpty() + "\nB: " + b.isEmpty());
		System.out.println("\nAdding a value of 1 to ArrayList A at index 0 using add(int index, Object x)...");
		a.add(0,1);
		System.out.println("\nArrayList A: " + a.toString());
		System.out.println("ArrayList B: " + b.toString() + "\n");
		System.out.println("Value at A[1] using get(int index): " + a.get(1));
		System.out.println("\nSize of ArrayLists using size():\nA: " + a.size() + "\nB: " + b.size());
		System.out.println("\nIs the value 1 in the ArrayLists? (isIn(Object ob))\nA: " + a.isIn(1) + "\nB: " + b.isIn(1));
		System.out.println("\nWhere is the value 1 in ArrayList A? (find(Object n))\nIndex " + a.find(1));
		System.out.println("\nRemoving value 1 from arraylist A using remove(Object n)...");
		a.remove(1);
		System.out.println("\nArrayList A: " + a.toString());
		System.out.println("ArrayList B: " + b.toString() + "\n");	
	}
}


