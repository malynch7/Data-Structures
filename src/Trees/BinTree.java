package Trees;

public class BinTree {
node root;
	
	public BinTree(int data) {
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
}
