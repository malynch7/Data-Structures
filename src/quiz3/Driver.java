package quiz3;

public class Driver {

	public static void main(String[] args) {

		Child c = new Child( 1, 2, 3, 4);
		Mother m =  new Mother(5,6);
		
		System.out.println("Child \nA: " + c.getValueA() + " \nB: " + c.getValueB() + " \nC: " + c.getValueC() + " \nD: " + c.getValueD());
		System.out.println("\nMother \nA: " + m.getValueA() + "\nB: " + m.getValueB());
		
		System.out.println("\nCalling getters from Child object... \nA: " + c.getValueA() + " \nB: " + c.getValueB());
		System.out.println("\nCalling Add()... \nMother: " + m.Add(4, 2, 1) + " \nChild: " + c.Add(4, 2, 1));
		System.out.println("\nSetting values with child object...");
		c.setValueA(4);
		c.setValueA(3);
		c.setValueA(2);
		c.setValueA(1);
		System.out.println("\nNew \nA: " + c.getValueA() + " \nB: " + c.getValueB() + " \nC: " + c.getValueC() + " \nD: " + c.getValueD());
	}

}
