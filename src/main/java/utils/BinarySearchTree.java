package utils;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {

    Node1 root;
    static int preIndex = 0;

    public BinarySearchTree() {
    }

    void postOrderTraversal(Node1 node) {
        while (true) {
            if (node.left != null) {
                postOrderTraversal(node.left);
            }

            if (node.right != null) {
                postOrderTraversal(node.right);
            }

            System.out.print(node.val+"-");
            return;
        }
    }
    

    /**
     * Not working yet
     * @param node
     */
    void inOrderTraversal(Node1 node) {
        while (true) {
            if (node.left != null) {
                postOrderTraversal(node.left);
            }

            System.out.print(node.val + "-");
            
            if (node.right != null) {
                postOrderTraversal(node.right);
            }

            
            return;
        }
    }

    int sizeOfTree(Node1 node) {
        if (node == null)
            return 0;
        return 1 + sizeOfTree(node.left) + sizeOfTree(node.right);
    }

    /* UTILITY FUNCTIONS */

    /*
     * Function to find index of value in arr[start...end]
     * The function assumes that value is present in in[]
     */
    int search(int arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    /**
     * Build a tree from in-order and post-order traversals
     */
    Node1 buildTree(int[] in, int[] pre, int start, int end) {
        if (/* in.length<1 || pre.length < 1 || */start > end) {
            return null;
        }

        // first char of pre-order is the root
        Node1 r = null; //TODO new Node1(pre[preIndex++]);

        if (start == end)
            return r;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, start, end, r.val);

        r.left = buildTree(in, pre, start, inIndex - 1);
        r.right = buildTree(in, pre, inIndex + 1, end);

        return r;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        // Build a tree directly
        /*
         * tree.root = new Node(1);
         * tree.root.left = new Node(2);
         * tree.root.right = new Node(3);
         * tree.root.right.left= new Node(6);
         * tree.root.right.right = new Node(7);
         * tree.root.left.left = new Node(4);
         * tree.root.left.right = new Node(5);
         */

        // System.out.println("Preorder traversal of binary tree is ");
        // tree.printPreorder();

        // System.out.println("\nInorder traversal of binary tree is ");
        // tree.printInorder();
        //DBEAFC
        //425163
        //ABDECF
        //124536
        int in[] = new int[]{4, 2, 5, 1, 6, 3};
        int pre[] = new int[]{1, 2, 4, 5, 3, 6};
        int len = in.length;
        tree.root = tree.buildTree(in, pre, 0, len - 1);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.postOrderTraversal(tree.root);

        System.out.println("\nSize of binary tree is :" + tree.sizeOfTree(tree.root));
    }
}

class Node {
    int val;
    Node1 left;
    Node1 right;

    public Node(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
