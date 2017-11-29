package Trees;

import java.util.*;

public class BSTree {
	
	public static void main(String[] args) {
		
		int[] randoms = new int[100];
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			randoms[i] = r.nextInt(98) + 1;
			System.out.print(randoms[i] + " ");
		}
		System.out.println("\n\nGenerating binary search tree...\n\nInorder display:");
		BinTree bst = new BinTree(randoms[0]);
		for (int i = 1; i < 100; i++)
			bst.add(randoms[i]);
		bst.printInOrder(bst.root);
	}

}
