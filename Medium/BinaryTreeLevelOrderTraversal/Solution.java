import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right)  {this.val = val; this.left = left; this.right = right;}
    public String toString() {return String.format("%d", val);}

}

class Solution {
    // public static List<List<Integer>> levelOrder(TreeNode root) {
    //     List <List<Integer>> mainList = new ArrayList<>();
    //     Queue<TreeNode> mainQueue = new LinkedList<>();
        
    //     if (root == null) return mainList;

    //     List<Integer> root_list = new ArrayList<Integer>();
    //     root_list.add(root.val);

    //     // mainList.add(root_list);
    //     mainQueue.add(root);

        
    //     int level = 1;

    //     while (!mainQueue.isEmpty()) {
    //         level++;
    //         if (level % 2 != mainQueue.size() % 2) {
    //             List sub_list = new ArrayList();
    //             for (TreeNode x : mainQueue) {
    //                 sub_list.add(x.val);
    //             }
    //             mainList.add(sub_list);
    //         }
            
    //         System.out.println(mainList.toString());
    //         TreeNode popNode = mainQueue.poll();
            
            
    //         if (popNode == null) continue;
    //         if (popNode.left != null) {
    //             mainQueue.add(popNode.left);
    //             System.out.println(popNode);
    //         }

    //         if (popNode.right != null) {
    //             mainQueue.add(popNode.right);
    //         }

    //     }

    //     mainList.remove(mainList.size() - 1);

    //     return mainList;
    // }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public static void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }


    public static void main(String[] args) {
        // First Test case
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        // Second Test Case
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.right.right = new TreeNode(5);

        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.left.left = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.left.left = new TreeNode(5);

        System.out.println(levelOrder(root).toString());



    }
}