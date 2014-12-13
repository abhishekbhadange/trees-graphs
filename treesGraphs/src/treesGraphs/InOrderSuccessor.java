//Algorithm to find the next node (in-order successor) of a given node in a BST,
//assuming that each node has a link to its parent 

package treesGraphs;

public class InOrderSuccessor {
	public Node inOrderSucc(Node n) {
		if(n == null)
			return null;
		if(n.right != null)
			return leftmostChild(n.right);
		else {
			Node q = n;
			Node x = q.parent;
			while(x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
	public Node leftmostChild(Node n) {
		if(n == null)
			return null;
		while(n.left != null)
			n = n.left;
		return n;
	}
}