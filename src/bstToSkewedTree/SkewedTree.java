package bstToSkewedTree;

class Node {
	int val;
	Node left, right;
	Node(int item) {
		val = item;
		left = right = null;
	}
}

public class SkewedTree {
	public Node node;
	public Node prevNode = null;
	public Node headNode = null;

	public void flattenBTToSkewed(Node root, int order) {

		if (root == null) {
			return;
		}

		if (order > 0) {
			flattenBTToSkewed(root.right, order);
		} else {
			flattenBTToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		if (order > 0) {
			flattenBTToSkewed(leftNode, order);
		} else {
			flattenBTToSkewed(rightNode, order);
		}
	}

	public void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

}