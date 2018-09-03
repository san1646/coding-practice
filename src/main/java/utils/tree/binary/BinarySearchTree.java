package utils.tree.binary;

import utils.Node1;

public class BinarySearchTree {
    Node1 root;

    public BinarySearchTree(Node1 root) {
        this.root = root;
    }

    public void insertNode(Node1 node) {
        if (this.root.val > node.val) {
            insertNode(this.root.left);
        }else if(this.root.val < node.val){
            insertNode(this.root.right);
        }
    }
}
