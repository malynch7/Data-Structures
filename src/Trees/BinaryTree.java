package Trees;

import java.util.*;

public class BinaryTree {

	static ArrayList<node> tree = new ArrayList();
	
	public BinaryTree(int data) {
		ArrayList<node> tree = new ArrayList();
		tree.add(new node(data));
	}
	
	public BinaryTree(int[] array) {
		for( int data : array) {
			
		}
	}
	
	public void addLeft(int data, int parentIndex) {
		tree.add((parentIndex * 2) + 1, new node( data, (parentIndex * 2) + 1 ));
	}
	
	public void addRight(int data, int parentIndex) {
		tree.add((parentIndex * 2) + 2, new node( data, (parentIndex * 2) + 2));
	}
	
	public String preOrder() {
		String preOrder="";
		for(node n : tree) {
			preOrder += n + " ";
		}
		return preOrder;
	}
}
