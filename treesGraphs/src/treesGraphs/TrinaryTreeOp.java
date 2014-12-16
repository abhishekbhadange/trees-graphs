package treesGraphs;

public class TrinaryTreeOp {
	public static void main(String[] args) {
		TrinaryTree theTree = new TrinaryTree();
		theTree.insert(5);
		theTree.insert(4);
		theTree.insert(9);
		theTree.insert(5);
		theTree.insert(7);
		theTree.insert(2);
		theTree.insert(2);
		theTree.insert(10);
		theTree.insert(1);
		theTree.insert(3);
		theTree.insert(2);
		theTree.insert(2);
		System.out.println("Deleted 2? " + theTree.delete(2));
		System.out.println("Deleted 9? " + theTree.delete(9));
	}
}