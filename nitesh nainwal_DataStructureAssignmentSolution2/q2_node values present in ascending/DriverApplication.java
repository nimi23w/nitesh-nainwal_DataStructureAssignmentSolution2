package app;

class Node {
	int key;
	Node left, right;
	
	Node(int data) {
		this.key = data;
		left = right = null;
	}
}
public class DriverApplication{
	Node node;
	Node previousNode = null;
	Node newHead = null;
	void processBST(Node root) {
		if(root == null) {
			return;
		}
		// loop till left leaf
		processBST(root.left);
		
		Node rightNode = root.right;
		Node leftNode = root.left;
		
		// update new head to hold new root
		if(newHead == null) {
			newHead = root;
			root.left = null;
			previousNode = root;
		} else {
			previousNode.right = root;
			root.left = null;
			previousNode = root;
		}
		processBST(rightNode);
	}
	
	void traverse(Node root) {
		// traverse till leaf
		if(root == null) {
			return;
		}
		System.out.print(root.key + " ");
		traverse(root.right);
	}
	
	
	
	
	public static void main(String[] args) {
		DriverApplication tree = new DriverApplication();
		
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);
		
		tree.processBST(tree.node);
		tree.traverse(tree.newHead);
	}
	
}