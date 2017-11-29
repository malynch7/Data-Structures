/* Purpose: BSTree.java is designed to generate and sort a list of 100 integers, using a binary search tree.
 * 
 * Solution: The program first creates an array of 100 randomly generated integers, and displays the contents of the array. A binary search tree is then created
 *  using a linked list made of nodes containing the integer data, a left node, and a right node. The first passed integer is used to build a node containing 2
 *  null nodes, left and right, and the integer data. This node is the root of the tree and the first current node. Each subsequent value is compared to the 
 *  current node's data. If the value is smaller, the current node's left child is checked. If it is null, then the current node's left child is set to a new 
 *  node containing the passed value and null left and right nodes. If it is not null, then it becomes the current node. If the passed value is greater than, or 
 *  equal to, the current node's data, Then the right child is checked. If null, it is set to a new node containing the passed value and null left and right 
 *  nodes. If not, then it becomes the current node. Once all values are added, They are printed in order using a recursive method that calls itself on its own 
 *  left node, then prints the current node's value, then calls itself on its right node. If the current node is null then the function returns as a base case.
 * 
 * Data structures used:
 *  -Binary search tree
 *  -Linked List
 * 	-Integer
 * 	-Array
 * 	-Boolean
 * 
 * How to use: The program does not require any user input. The contents of the unsorted array will be printed to the screen, followed by the inorder print-out 
 *  of the sorted binary search tree. 
*/
import java.util.Random;

public class BSTree {
	//This class provides the linked list structure for the binary search tree.
	node root;
	
	public BSTree(int data) {
		root = new node(data);
	}
	
	public void add(int data) {
	//creates a new node containing the passed value and adds it to the binary search tree.
	//Pre: data and BSTree must be initialized.
	//post: Value will be added to the binary search tree.
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
	//Recursive function that prints an in-order traversal of the binary search tree.
	//Pre: Passed currentNode must be the root of BSTree
	//Post: Prints in order traversal of binary search tree
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
// This class acts as a node for the custom linked list used by the binary search tree.
	int data;
	node left, right;
	
	public node(int data) {
		
		this.data = data;
		left = null;
		right = null;
	}
}
