// Algorithm to decide if binary tree T2 (with hundreds of nodes) is a subtree of binary tree 
// T1 (with millions of nodes)

package treesGraphs;

public class IsSubtree {
	public static void main(String[] args) {
		BinaryTree T1 = new BinaryTree(12);
		Node root1 = T1.getRoot();
		T1.setLeft(root1, 2);
		T1.setRight(root1, 18);
		Node leftChild = T1.getLeft(root1);
		T1.setLeft(leftChild, 21);
		Node rightChild = T1.getRight(root1);
		T1.setLeft(rightChild, 2);
		T1.setRight(rightChild, 9);
		Node rightsLeftChild = T1.getLeft(rightChild);
		T1.setLeft(rightsLeftChild, 15);
		T1.setRight(rightsLeftChild, 30);
		BinaryTree T2 = new BinaryTree(2);
		Node root2 = T2.getRoot();
		T2.setLeft(root2, 15);
		T2.setRight(root2, 30);
		System.out.println("Is T2 a subtree of T1? " + containsTree(root1, root2));
	}
	public static boolean containsTree(Node T1, Node T2) {
		if(T2 == null)	// empty tree is always a subtree
			return true;	
		return isSubtree(T1, T2);
	}
	public static boolean isSubtree(Node T1, Node T2) {
		if(T1 == null)	
			return false;	// big tree empty & subtree still not found 
		if(T1.data == T2.data)
			if(matchTree(T1, T2))
				return true;
		return (isSubtree(T1.left, T2) || isSubtree(T1.right, T2));
	}
	public static boolean matchTree(Node n1, Node n2) {
		if(n2 == null && n1 == null)	// if both are empty
			return true;	// nothing left in the subtree
		// if one, but not both, is empty
		if(n1 == null || n2 == null)
			return false;
		if(n1.data != n2.data) 
			return false;	// data doesn't match
		return (matchTree(n1.left, n2.left) && matchTree(n1.right, n2.right));
	}
}