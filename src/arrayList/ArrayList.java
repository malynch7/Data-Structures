//For primary documentation see testarray.java.
package arrayList;
import java.util.*;

//This class contains the ArrayList Data Structure and its related methods. 
public class ArrayList {
	Object[] a;
	
	//Default constructor
	
	
	public ArrayList() {
		Object[] tmp = new Object[10];
		a = tmp;
	}
	
	//Constructor that sets initial array size to value n
	public ArrayList(int n) {
		Object[] tmp = new Object[n];
		a = tmp;
	}
	
	//Adds object x to the array at the first available null position. If no null position exists, the array will double in size and attempt
	//again.
	//Pre-conditions: The ArrayList must be initialized
	//Post-conditions: The ArrayList will increase in size
	public void add(Object x) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == null) {
				a[i] = x;
				return;
			}
		}
		grow();
		add(x);
	}
	
	//Adds 'object x' to the array at index 'index', shifting all object behind it by an index of one. If no null position exists at the end 
	//of the array the array will double in size and attempt again.
	//Pre-conditions: The ArrayList must be initialized and index must be smaller than the current array size.
	//Post-conditions: The ArrayList will now contain Object x and increase in size.
	public void add(int index, Object x) {
		if(a[a.length-1] == null) {
			for (int i = a.length -2; i >= index; i--) {
				a[i+1] = a[i];
			}
			a[index] = x;
		}else {
			grow();
			add(index,x);
		}
	}
	
	//Returns the object found at index 'index'. 
	//Pre-conditions: The ArrayList must be initialized and index must be smaller than the current array size.
	//Post-conditions:
	public Object get(int index) {
		return a[index];
	}
	
	//Returns the number of none-null elements in the array. 
	//Pre-conditions: The ArrayList must be initialized
	//Post-conditions:
	public int size() {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == null)
				return i;
		}
		return a.length;
	}
	
	//Returns true if all values of the array are null and false otherwise. 
	//Pre-conditions: The ArrayList must be initialized
	//Post-conditions:	
	public boolean isEmpty() {
		for (Object i: a) {
			if(i != null) {
				return false;
			}
		}
		return true;
	}
	
	//Returns true if the Object 'ob' is currently in the array and false otherwise. 
	//Pre-conditions: The ArrayList must be initialized
	//Post-conditions:	
	public boolean isIn(Object ob) {
		for (Object i: a) {
			if(i == ob) {
				return true;
			}
		}
		return false;
	}
	
	//Searches array for Object 'n' and returns its index if found. 
	//Pre-conditions: The ArrayList must be initialized
	//Post-conditions: Will return -1 if not found
	public int find(Object n) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == n) {
				return i;
			}
		}
		return -1;
	}
	
	//Removes the first instance of Object n within the array if any. 
	//Pre-conditions: The ArrayList must be initialized
	//Post-conditions: The Arraylist will decrease in size and no longer contain Object 'n'.
	public void remove(Object n) {
		for (int i = 0; i < a.length; i++) {
			if(a[i] == n) {
				if(i == a.length-1) {
					a[i] = null;
				}else{
				for(; i < a.length-1;i++) {
					a[i] = a[i+1];	
				}
				}
			}
		}
	}
	
	//Doubles the currents array's size. 
	//Pre-conditions: The ArrayList must be initialized
	//Post-conditions: The Arraylist will double in size.	
	private void grow(){
		Object[] tmp = new Object[a.length*2];
		for( int i = 0; i < a.length; i++) {
			tmp[i] = a[i];
		}
		a = tmp;
	}
	
	//Renders the ArrayList to a String. 
	//Pre-conditions: The ArrayList must be initialized
	//Post-conditions:	
	public String toString() {
		String s = "[";
		for(int i = 0; i < a.length; i++) {
			if(a[i] == null) {
				return s + " ]";
			}else {
				s+= " " + a[i];
			}
		}
		return s + "]";
	}

}
