import java.util.ArrayList;

class BST2MinHeap {

	static class Node {
		int data;
		Node left, right;

		public Node() {

			this.data = 0;
			this.left = this.right = null;
		}

		public Node(int data) {

			this.data = data;
			this.left = this.right = null;
		}
	}

	static void preOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	static void convert2Min(Node root) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		storeInOrder2Array(root, arr);
		array2MinHeap(root, arr);
	}
	
	private static int index = 0;
	private static void array2MinHeap(Node root, ArrayList<Integer> arr) {
		if(root == null) {
			return;
		}
		root.data = arr.get(index ++);
		array2MinHeap(root.left, arr);
		array2MinHeap(root.right, arr);
	}

	private static void storeInOrder2Array(Node root, ArrayList<Integer> arr) {
		if(root == null) {
			return;
		}
		storeInOrder2Array(root.left, arr);
		arr.add(root.data);
		storeInOrder2Array(root.right, arr);
	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		convert2Min(root);
		
		preOrder(root);
	}
}
