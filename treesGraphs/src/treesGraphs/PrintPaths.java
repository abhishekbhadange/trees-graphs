package treesGraphs;

public class PrintPaths {
	public static void main(String[] args) {
		BinaryTree T1 = new BinaryTree(2);
		Node root = T1.getRoot();
		T1.setLeft(root, 3);
		T1.setRight(root, 1);
		Node leftChild = T1.getLeft(root);
		T1.setLeft(leftChild, 8);
		Node leftsLeftChild = T1.getLeft(leftChild);
		T1.setRight(leftsLeftChild, -7);
		Node rightChild = T1.getRight(root);
		T1.setLeft(rightChild, 5);
		T1.setRight(rightChild, 3);
		printPaths(root, 6);
	}
	public static void printPaths(Node root, int sum) {
		if(root == null)
			return;
		int depth = depth(root);
		int[] path = new int[depth];
		printPaths(root, sum, path, 0);
	}
	public static int depth(Node n) {
		if(n == null)
			return 0;
		else
			return 1 + Math.max(depth(n.left), depth(n.right));
	}
	public static void printPaths(Node n, int sum, int[] path, int level) {
		if(n == null)
			return;

		/* Insert current node into path */
		path[level] = n.data;	
		
		/* Look for paths with a sum that ends at this node */
		int t = 0;
		for(int i = level; i >= 0; i--) {
			t += path[i];
			if(t == sum)
				print(path, i, level);
		}
		
		/* Search nodes beneath this one */
		printPaths(n.left, sum, path, level + 1);
		printPaths(n.right, sum, path, level + 1);
		
		/* Remove current node from path. Not strictly necessary, since
		   we would ignore this value, but it's good practice. */
		path[level] = Integer.MIN_VALUE;
	}
	public static void print(int[] path, int start, int end) {
		for(int i = start; i <= end; i++)
			System.out.println(path[i] + " ");
		System.out.println("");		
	}
}