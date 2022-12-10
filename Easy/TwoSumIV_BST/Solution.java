import java.util.ArrayList;
import java.util.Stack;
import java.util.HashSet;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) {this.val = val;}
	TreeNode(int val, TreeNode left, TreeNode right) {this.val = val; this.left = left; this.right = right;}
}



class Solution {	
	public static boolean findTarget(TreeNode root, int k) {
        ArrayList mainList = new ArrayList<>();
		Stack <TreeNode> mainStack = new Stack<TreeNode>();
		HashSet mainMap = new HashSet();
		mainStack.push(root);


		while (true) {
			if (mainStack.size() == 0) {break;} 

			TreeNode tempNode = mainStack.pop();
			mainMap.add(k - tempNode.val);
			mainList.add(tempNode.val);

			if (tempNode.left != null) {
				mainStack.push(tempNode.left);
			}

			if (tempNode.right != null) {
				mainStack.push(tempNode.right);
			}
		}

        if (mainList.size() <= 1) {
			return false;
		}


		for (int i = 0; i < mainList.size(); i++) {
            int curr_val = (int) mainList.get(i);

            if (mainMap.contains(curr_val)) {
                if (k - curr_val == curr_val)  {
                    if (!mainList.contains((int) mainList.remove(i))){
                        continue;
                    }
                }
                return true;
            }
		}

		return false;
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
