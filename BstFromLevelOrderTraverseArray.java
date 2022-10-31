
public class BstFromLevelOrderTraverseArray {

	static class Node {
		int data;
		Node left, right;

		public Node() {
			data = 0;
			left = right = null;
		}

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	static int[] arr = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };

	public static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static Node createBST(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data <= root.data) {
			root.left = createBST(root.left, data);
		} else {
			root.right = createBST(root.right, data);
		}

		return root;
	}

	public static void main(String[] args) {
		Node root = new Node(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			createBST(root, arr[i]);
		}

		preOrder(root);
	}

}
