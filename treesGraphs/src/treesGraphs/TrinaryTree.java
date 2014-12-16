// Implement insert and delete in a tri-nary tree 

package treesGraphs;

public class TrinaryTree {
	private TriNode root;
	public void insert(int data) {
		TriNode newNode = new TriNode(data);
		if(root == null) {
			root = newNode;
		}
		else {
			TriNode current = root;
			TriNode parent;
			while(true) {
				parent = current;
				if(data < current.data) {		// go left
					current = current.left;
					if(current == null) {
						parent.left = newNode;
						return;
					}
				}
				else if(data == current.data) {	// go center
					current = current.center;
					if(current == null) {
						parent.center = newNode;
						return;
					}
				}
				else {							// go right
					current = current.right;
					if(current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	// returns node with next highest value after delNode
	// goes to right child, then right child's left descendants
	private TriNode getSuccessor(TriNode delNode) {
		TriNode successorParent = delNode;
		TriNode successor = delNode;
		TriNode current = delNode.right;
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		if(successor != delNode.right) {
			successorParent.left = successor.right;
			successor.right = delNode.right;
		}
		return successor;
	}
	// delete node with given key
	public boolean delete(int key) {
		TriNode current = root;
		TriNode parent = root;
		boolean isLeft = true;
		while(current.data != key) {
			parent = current;
			if(key < current.data) {
				isLeft = true;
				current = current.left;
			}
			else {
				isLeft = false;
				current = current.right;
			}
			if(current == null)
				return false;
		}
		// if center child exists, delete the last one in the center node list
		if(current.center != null) {
			TriNode slow = current;
			TriNode fast = current.center;
			while(fast.center != null) {
				slow = fast;
				fast = fast.center;
			}
			slow.center = null;
		}
		// if no children, simply delete it
		else if(current.left == null && current.right == null) {
			if(current == root)
				root = null;
			else if(isLeft)
				parent.left = null;
			else
				parent.right = null;
		}
		// if no left child, replace with right subtree
		else if(current.left == null) {
			if(current == root)
				root = current.right;
			else if(isLeft)
				parent.left = current.right;
			else
				parent.right = current.right;
		}
		// if no right child, replace with left subtree
		else if(current.right == null) {
			if(current == root)
				root = current.left;
			else if(isLeft)
				parent.left = current.left;
			else
				parent.right = current.left;
		}
		// if two children, then replace with inorder successor
		else {
			TriNode successor = getSuccessor(current);
			if(current == root)
				root = successor;
			else if(isLeft)
				parent.left = successor;
			else
				parent.right = successor;
			successor.left = current.left;
		}
		return true;
	}
}