

class AVLTree {
    class Node {
        int height;
        int value;
        Node left;
        Node right;

        Node() {
            this.value = 0;
            this.height = 0;
            this.left = null;
            this.right = null;
        }
        
        Node(int value) {
            this.value = value;
            this.height = 0;
            this.left = null;
            this.right = null;
        }
    }

    Node root;
    int balanceFactor;

    AVLTree() {
        this.root = null;
        this.balanceFactor = 0;
    }

    AVLTree(Node root) {
        this.root = root;
        this.balanceFactor = 0;;
    }


    public void preorder(Node head) {
        if (head == null) return;
        System.out.println(head);
        preorder(head.left);
        preorder(head.right);
    }

    private int getMax(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalanceFactor(Node node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private void insertElement(int value) {
        this.root = insertElement(root, value);
    }

    private Node rightRotate(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.height = getMax(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height =  getMax(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }

    private Node leftRotate(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node.height = getMax(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height =  getMax(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }


    public Node insertElement(Node node, int element) {
        if (node == null) {
            return new Node(element);
        }

        if (element < node.value) {
            node.left = insertElement(node.left, element);
        } else if (element > node.value) {
            node.right = insertElement(node.right, element);
        } else {
            return node;
        }

        node.height = getMax(getHeight(node.left), getHeight(node.right)) + 1;
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (element < node.left.value) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balanceFactor < -1) {
            if (element > node.right.value) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }



    public AVLTree convertToAvl(int[] arr) {        
        AVLTree avlHead = new AVLTree(new Node(arr[0]));
        
        for (int i = 1; i < arr.length; i++) {
            
        }

    
        return new AVLTree();
    }

}

class Solution {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
         * Add Both Arrays, 
         *      Get Median O(n)
         * Use BFS To find the value from num2 in num1
        */
        

        return nums1[0];
    }
}