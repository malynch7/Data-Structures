package linkedList;
import java.util.*;

public class RecursiveSize {
	static LinkedList<Integer> list = new LinkedList();

	public static void main(String[] args) {

		Random r = new Random();
		int l = r.nextInt(16) + 10;
		for (int i = 0; i<l; i++) {
			list.add(r.nextInt(100) + 1);
		}
		System.out.print("reference size: " + list.size());
		System.out.println("method size: " + size(list);
	}
	
	public static int size(LinkedList list) {
		if (list.getFirst() == null) {
			return 0;
		}
		else {
			return 1 + size(list.subList(1,list.indexOf(list.getLast())));
		}
	}
}
