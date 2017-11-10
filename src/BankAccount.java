
public class BankAccount {

	String name;
	double balance;
	
	public BankAccount() {
		name = null;
		balance = 0;
	}
	public BankAccount(String n,double x) {
		name = n;
		balance = x;
	}
	public void deposit(double x) {
		balance += x;
	}
	public void withdraw(double x) {
		balance -= x;
	}
	public String toString() {
		return name + ", " + balance;
	}
	public String getName() {
		return name;
	}
	public double getBalance() {
		return balance;
	}
}
