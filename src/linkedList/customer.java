/* Purpose: customer.java is a container that holds customer data including first name, last name, and phone number. 
 * 	For primary documentation, see phonedir.java.
 */
package linkedList;

public class customer {

	String fName, lName, phone;
	
	
	public customer(){ 
		//default constructor
		fName = "John";
		lName = "Doe";
		phone = "111-111-1111";
	}
	
	
	public customer(String f,String l,String p) {
		//constructor with all variables
		fName = f;
		lName = l;
		phone = p;
	}
	
	
	public customer(customer x) {
		//constructor used to clone a customer
		fName = x.getFirstName();
		lName = x.getLastName();
		phone = x.getPhone();
				
	}
	
	public void display() {
		//formatted print statement
		System.out.format("%-3s%-23s%-13s","",lName+",  "+fName,phone + "\n");
	}
	
	public void setFirstName(String f) {
		fName = f;
	}
	
	public void setLastName(String l) {
		lName = l;
	}
	
	public void setPhone(String p) {
		phone = p;
	}
	public String getFirstName() {
		return fName;
	}
	public String getLastName() {
		return lName;
	}
	public String getPhone() {
		return phone;
	}

	


	
}
