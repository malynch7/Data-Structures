import java.util.Random;

public class BSTree {
	
	node root;
	
	public BSTree(int data) {
		root = new node(data);
	}
	
	public void add(int data) {
		node currentNode = root;
		boolean stop = false;
		while(stop != true) {
			if(data < currentNode.data) {
				if(currentNode.left != null)
					currentNode = currentNode.left;
				else {
					currentNode.left = new node(data);
					stop = true;
				}
			}
			else {
				if(currentNode.right != null)
					currentNode = currentNode.right;
				else {
					currentNode.right = new node(data);
					stop = true;
				}
					
			}
		}
	}
	
	public void printInOrder(node currentNode) {
		if (currentNode == null)
			return;
		printInOrder(currentNode.left);
		System.out.print(currentNode.data + " ");
		printInOrder(currentNode.right);
	}
	
	public static void main(String[] args) {
		
		int[] randoms = new int[100];
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			randoms[i] = r.nextInt(98) + 1;
			System.out.print(randoms[i] + " ");
		}
		System.out.println("\n\nGenerating binary search tree...\n\nInorder display:");
		BSTree bst = new BSTree(randoms[0]);
		for (int i = 1; i < 100; i++)
			bst.add(randoms[i]);
		bst.printInOrder(bst.root);
	}
}

class node {

	int data;
	node left, right;
	
	public node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
