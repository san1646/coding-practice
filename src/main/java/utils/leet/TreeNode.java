package utils.leet;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void print() {
        System.out.println("Val::" + this.val);
        if (this.left == null) {
            System.out.println("Val::null");
        } else {
            this.left.print();
        }

        if (this.right == null) {
            System.out.println("Val::null");
        } else {
            this.right.print();
        }
        //System.out.println("---");
    }
}
