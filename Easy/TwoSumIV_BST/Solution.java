import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) {this.val = val;}
	TreeNode(int val, TreeNode left, TreeNode right) {this.val = val; this.left = left; this.right = right;}
}



class Solution {	
	public static boolean findTarget(TreeNode node, int k) {

		/*
		 * If value + right is above, try value + left
		 * 
		 */

		ArrayList mainList = new ArrayList<>();
		Stack mainStack = new Stack<>();
		TreeNode tempNode = node;


		while (tempNode != null) {
			if (tempNode.left) {
				mainStack.push(tempNode.left);
			}
			if (tempNode.right) {
				mainStack.push(tempNode.right);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);

		System.out.println(findTarget(root, 9));
	}
}
