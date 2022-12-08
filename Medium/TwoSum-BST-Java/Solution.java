/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class Solution {
    public boolean findTarget(TreeNode root, int k) {

        TreeNode tempNode = root;

        if (k - tempNode.val < tempNode.val) {
            tempNode = tempNode.left;
        } else {
            tempNode = tempNode.right;
        }
        while (tempNode.left != null) {
            tempNode = tempNode.left;
        }


        return true;
    }
}