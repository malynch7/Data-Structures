package Trees;

public class node {

	int data, leftChild, rightChild, parent;
	
	public node(int data) {
		this.data = data;
		this.data = data;
		leftChild = 1;
		rightChild = 2;
		parent = 0;
	}
	
	public node(int data, int index) {
		this.data = data;
		leftChild = (2 * index) + 1;
		rightChild = ( 2 * index) + 2;
		parent = (index - 1) / 2;
	}
	
}
