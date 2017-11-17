package quiz3;

public class Child extends Mother {

	int valueC, valueD;
	
	public Child(int c, int d) {
		valueC = c;
		valueD = d;
	}
	
	public Child(int a, int b, int c, int d) {
		super(a,b);
		valueA = super.getValueA();
		valueB = super.getValueB();
		valueC = c;
		valueD = d;
	}
	
	public int Add(int a, int b, int c) {
		return (a / b) - c;
	}
	
	public int getValueC() {
		return valueC;
	}
	
	public int getValueD() {
		return valueD;
	}
	
	public void setValueC(int c) {
		valueC = c;
	}
	
	public void setValueD(int d) {
		valueD = d;
	}
}
