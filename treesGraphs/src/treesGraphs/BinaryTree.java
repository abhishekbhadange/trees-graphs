package treesGraphs;

public class BinaryTree {
	public Node root;
	public BinaryTree(int value) {
		root = new Node(value);
	}
	public Node getRoot() {
		return root;
	}
	public Node getRight(Node current) {
		return current.right;
	}
	public void setRight(Node current, int value) {
		Node n = new Node(value);
		current.right = n;
	}
	public Node getLeft(Node current) {
		return current.left;
	}
	public void setLeft(Node current, int value) {
		Node n = new Node(value);
		current.left = n;
	}
}
