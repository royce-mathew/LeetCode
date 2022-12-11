import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {};
	TreeNode(int val) {this.val = val;}
	TreeNode(int val, TreeNode left, TreeNode right) {this.left = left; this.right = right; this.val = val;}
}


class Solution {

	// Depth For Search
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		Stack <TreeNode> mainStack = new Stack<>();
		Stack <TreeNode> secondStack = new Stack<>();
		mainStack.push(p);
		secondStack.push(q);

		while (!mainStack.isEmpty() && !secondStack.isEmpty()) {
			TreeNode tempNode = mainStack.pop();
			TreeNode secondNode = secondStack.pop();


			System.out.println(mainStack.toString());
			System.out.println(secondStack.toString());

			if (tempNode == null && secondNode == null) continue;
			if (tempNode == null || secondNode == null) return false;
			if (tempNode != secondNode) return false;
			mainStack.push(tempNode.left);
			mainStack.push(tempNode.right);
			secondStack.push(secondNode.left);
			secondStack.push(secondNode.right);
		}

		if (mainStack.isEmpty() && secondStack.isEmpty())
			 return true;
		else  return false;
	}

	// Breadth For Search
	public static boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            q1.offer(t1.left);
            q1.offer(t1.right);
            q2.offer(t2.left);
            q2.offer(t2.right);
        }
        if(q1.isEmpty() && q2.isEmpty()) return true;
        else return false;
    }

	public static void main(String[] args) {
		// TreeNode root = new TreeNode(5);
		// root.left = new TreeNode(3);
		// root.right = new TreeNode(6);
		// root.left.left = new TreeNode(2);
		// root.left.right = new TreeNode(4);
		// root.right.right = new TreeNode(7);

		// TreeNode root2 = new TreeNode(5);
		// root2.left = new TreeNode(3);
		// root2.right = new TreeNode(6);
		// root2.left.left = new TreeNode(2);
		// root2.left.right = new TreeNode(4);
		// root2.right.right = new TreeNode(7);

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);

		TreeNode root2 = new TreeNode(1);
		root2.right = new TreeNode();
		root2.left = new TreeNode(2);





		System.out.println(isSameTree(root, root2));
	}

}
