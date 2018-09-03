package utils.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import utils.Node1;

public class BinarySearchTree {

    Node1 root;

    public BinarySearchTree() {
    }

    public void add(int value) {
        root = insert(root, value);
    }

    private Node1 insert(Node1 curr, int value) {

        if (curr == null) {
            return new Node1(value, null, null);
        } else if (value < curr.val) {
            curr.left = insert(curr.left, value);
        } else if (value > curr.val) {
            curr.right = insert(curr.right, value);
        } else {
            return curr;
        }
        return curr;
    }

    void postOrderTraversal(Node1 node) {
        while (true) {
            if (node.left != null) {
                postOrderTraversal(node.left);
            }

            if (node.right != null) {
                postOrderTraversal(node.right);
            }

            System.out.print(node.val + "-");
            return;
        }
    }


}
