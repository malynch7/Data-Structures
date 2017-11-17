package quiz3;

public class Mother {

	int valueA, valueB;
	
	public Mother() {
		valueA = 0;
		valueB = 0;
	}
	
	public Mother(int a, int b) {
		valueA = a;
		valueB = b;
	}
	
	public int Add(int a, int b, int c) {
		return (a * b) + c;
	}
	
	public int getValueA() {
		return valueA;
	}
	
	public int getValueB() {
		return valueB;
	}
	
	public void setValueA(int a) {
		valueA = a;
	}
	
	public void setValueB(int b) {
		valueB = b;
	}
}
