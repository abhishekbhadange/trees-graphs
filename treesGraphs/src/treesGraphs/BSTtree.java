package treesGraphs;

public class BSTtree {
	private Node root;
	public Node getRoot() {
		return root;
	}
	public Node find(int key) {
		Node current = root;
		while(current.data != key) {
			if(key < current.data)
				current = current.left;
			else
				current = current.right;
			if(current == null)
				return null;
		}
		return current;
	}
	public void insert(int data) {
		Node newNode = new Node(data);
		if(root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while(true) {
				parent = current;
				if(data < current.data) {
					current = current.left;
					if(current == null) {
						parent.left = newNode;
						return;
					}
				}
				else {
					current = current.right;
					if(current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	public void inOrder(Node current) {
		if(current != null) {
			inOrder(current.left);
			System.out.print(current.data + " ");
			inOrder(current.right);
		}
	}
	public void preOrder(Node current) {
		if(current != null) {
			System.out.print(current.data + " ");
			preOrder(current.left);
			preOrder(current.right);
		}
	}
	public void postOrder(Node current) {
		if(current != null) {
			postOrder(current.left);
			postOrder(current.right);
			System.out.print(current.data + " ");
		}
	}
}
