//Implement a function to check if a binary tree is a binary search tree

package treesGraphs;

public class CheckBST {
	public static Integer last_printed = null;
	public static void main(String[] args) {
		BSTtree theTree = new BSTtree();
		theTree.insert(15);
		theTree.insert(8);
		theTree.insert(20);
		theTree.insert(11);
		System.out.println("Is Tree1 a BST: " + checkBST(theTree.getRoot()));
		last_printed = null;
		BinaryTree tree2 = new BinaryTree(13);
		Node root2 = tree2.getRoot();
		tree2.setLeft(root2, 10);
		tree2.setRight(root2, 15);
		Node leftChild1 = tree2.getLeft(root2);
		tree2.setLeft(leftChild1, 6);
		tree2.setRight(leftChild1, 12);
		Node rightChild1 = tree2.getRight(root2);
		tree2.setLeft(rightChild1, 16);
		tree2.setRight(rightChild1, 17);
		System.out.println("Is Tree2 a BST: " + checkBST(root2));
		System.out.println("\nUsing min/max solution:");
		System.out.println("Is Tree1 a BST: " + checkBST2(theTree.getRoot()));
		System.out.println("Is Tree2 a BST: " + checkBST2(root2));
	}
	// assumption: tree has no duplicate values 
	public static boolean checkBST(Node root) {
		if(root == null)
			return true;
		
		// check/recurse left
		if(!checkBST(root.left))
			return false;
		
		// check current
		if(last_printed != null && root.data <= last_printed)
			return false;
		last_printed = root.data;
		
		// check/recurse right
		if(!checkBST(root.right))
			return false;
		
		// all good
		return true;
	}
	// min/max solution
	public static boolean checkBST2(Node root) {
		return checkBST2(root, null, null);
	}
	public static boolean checkBST2(Node root, Integer min, Integer max) {
		if(root == null)
			return true;
		if((min != null && root.data <= min) || (max != null && root.data > max))
			return false;
		if(!checkBST2(root.left, min, root.data) || !checkBST2(root.right, root.data, max)) 
			return false;
		return true;
	}
}
