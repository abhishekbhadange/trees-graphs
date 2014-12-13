// Function to check if a binary tree is balanced

package treesGraphs;

import java.lang.Math;

public class IsBalanced {
	public static void main (String[] args) {
		BSTtree theTree = new BSTtree();
		theTree.insert(15);
		theTree.insert(8);
		theTree.insert(20);
		theTree.insert(11);
		BSTtree theTree2 = new BSTtree();
		theTree2.insert(16);
		theTree2.insert(5);
		theTree2.insert(22);
		theTree2.insert(10);
		theTree2.insert(7);
		System.out.println("Is Tree1 balanced: " + isBalanced(theTree.getRoot()));
		System.out.println("Is Tree2 balanced: " + isBalanced(theTree2.getRoot()));
	}
	public static boolean isBalanced(Node root) {
		if(checkHeight(root) == -1)
			return false;
		else
			return true;
	}
	public static int checkHeight(Node root) {
		if(root == null)
			return 0;
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1)
			return -1;
		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1)
			return -1;
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1)
			return -1;
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}
}