//Design an algorithm to find the first common ancestor of two nodes in a binary tree. Avoid storing additional nodes 
//in a data structure. NOTE: This is not necessarily a binary search tree

package treesGraphs;

public class CommonAncestor {
	public static Node parentNode1 = null, parentNode2 = null, originalRoot = null;
	public static int flag = 0;
	public static void main(String[] args) {
		BinaryTree theTree = new BinaryTree(20);
		Node root = theTree.getRoot();
		theTree.setLeft(root, 25);
		theTree.setRight(root, 11);
		Node leftChild = theTree.getLeft(root);
		theTree.setLeft(leftChild, 12);
		theTree.setRight(leftChild, 15);
		Node rightChild = theTree.getRight(root);
		theTree.setLeft(rightChild, 7);
		Node result = commonAncestor(root, theTree.getLeft(rightChild), theTree.getRight(leftChild));
		if(result != null)
			System.out.println("Common Ancestor node value: " + result.data);
		else
			System.out.println("Null value returned!");
		System.out.println("\nUsing efficient implementation:");
		Node result2 = effiCommonAncestor(root, theTree.getLeft(leftChild), theTree.getRight(leftChild));
		if(result2 != null)
			System.out.println("Common Ancestor node value: " + result2.data);
		else
			System.out.println("Null value returned!");
	}
	public static Node commonAncestor(Node root, Node p, Node q) {
		if(root == null)
			return null;
		// Error check
		if(!covers(root, p) || !covers(root, q))
			return null;
		return commonAncestorHelper(root, p , q);
	}
	/* Returns true if p is a descendent of root */
	public static boolean covers(Node root, Node p) {
		if(root == null)
			return false;
		if(root == p)
			return true;
		return covers(root.left, p) || covers(root.right, p);
	}
	public static Node commonAncestorHelper(Node root, Node p, Node q) {
		if(root == null)
			return null;
		if(root == p || root == q)
			return root;
		boolean is_p_on_left = covers(root.left, p);
		boolean is_q_on_left = covers(root.left, q);
		/* If p and q are on different sides, return root. */
		if(is_p_on_left != is_q_on_left)
			return root;
		/* Else, they are on the same side. Traverse this side. */
		Node child_side = is_p_on_left ? root.left : root.right;
		return commonAncestorHelper(child_side, p, q);
	}
	public static class Result {
		public Node node;
		public boolean isAncestor;
		public Result(Node n, boolean isAnc) {
			node = n;
			isAncestor = isAnc;
		}
	}
	public static Node effiCommonAncestor(Node root, Node p, Node q) {
		Result r = effiCommonAncestorHelper(root, p, q);
		if(r.isAncestor)
			return r.node;
		return null;
	}
	public static Result effiCommonAncestorHelper(Node root, Node p, Node q) {
		if(root == null)
			return new Result(null, false);
		if(root == p && root == q)
			return new Result(root, true);
		Result rx = effiCommonAncestorHelper(root.left, p, q);
		if(rx.isAncestor)
			return rx;		// Found common ancestor
		Result ry = effiCommonAncestorHelper(root.right, p, q);
		if(ry.isAncestor)
			return ry;		// Found common ancestor
		if(rx.node != null && ry.node != null) 
			return new Result(root, true);		// This is the common ancestor
		else if(root == p || root == q) {
			/* If we are currently at p or q, and we also found one of those 
			   nodes in a subtree, then this is truly an ancestor and the 
			   flag should be true. */
			boolean isAncestor = (rx.node != null || ry.node != null) ? true : false;
			return new Result(root, isAncestor);
		}
		else 
			return new Result(rx.node != null ? rx.node : ry.node, false);
	}
}