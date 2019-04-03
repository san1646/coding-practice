package utils.leet;

import java.util.LinkedList;

/**
 * This is a BST
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void inOrderTraversal() {
        if (this == null) {
            return;
        }
        System.out.println(this.val);
        if (this.left != null) {
            this.left.inOrderTraversal();
        }
        if (this.right != null) {
            this.right.inOrderTraversal();
        }
    }

    public void add(int val) {
//        TreeNode newNode ;
        if (val < this.val) {
            if(this.left == null){
                this.left = new TreeNode(val);
            }else{
                this.left.add(val);
            }
        } else {
            if(this.right == null){
                this.right = new TreeNode(val);
            }else{
                this.right.add(val);
            }
        }
    }


    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if(right!=null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(val).append("\n");
        if(left!=null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }
}
