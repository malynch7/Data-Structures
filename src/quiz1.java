import java.util.*;

public class quiz1 {

	static ArrayList<Integer> x = new ArrayList<Integer>(15);
	
	public static void main(String[] args) {
		
		Random r = new Random();
		while(x.size() < 15) {
			x.add(r.nextInt(50) + 1);
		}
		System.out.println(x);
		sorting(x);
		System.out.println(x);
		
	}

	public static void sorting(ArrayList<Integer> n) {
		int index = 0;
		int max = 0;
		for(int j = 0; j < 15; j++) {
			max = 0;
			for(int i = 0; i < 15 - j; i++) {
				if(n.get(i)>max) {
				max = n.get(i);
				index = i;
				}
			}
			n.set(index, n.get( 14 - j));
			n.set( 14 - j, max);
		}
		
	}
}

