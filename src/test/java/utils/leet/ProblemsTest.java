package utils.leet;

import org.junit.Test;

public class ProblemsTest {

    Problems problems = new Problems();

    @Test
    public void test1FlipAndInvertImage_1() {

        int[][] A = {{1, 1, 0},
                {0, 0, 1},
                {1, 0, 1}};

        int[][] B = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] res = problems.flipAndInvertImage(A);
    }

    @Test
    public void test1FlipAndInvertImage_2() {

        int[][] A = {{1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}};
        print2DArray(A, "A");
        int[][] res = problems.flipAndInvertImage(A);
        print2DArray(res, "res");

    }

    private void print2DArray(int[][] A, String name) {
        System.out.println("--" + name + "--");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println("--" + i);
        }
    }

    @Test
    public void testBitWiseOperator() {

        int k = 1;
        int j = k ^ 0;
        System.out.println("j-" + j);
    }

    @Test
    public void testMaxIncreaseKeepingSkyline() {

        int[][] A = {{3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}};
        //print2DArray(A, "A");
        int res = problems.maxIncreaseKeepingSkyline(A);
        System.out.println("Sum for grid:::" + res);
    }

    @Test
    public void testFlattenBinaryTreeToList() {
        TreeNode root = new TreeNode(1);

        buildBinaryTree(root, 2);
//        preOrderPrintTree(root);

        buildBinaryTree(root, 3);
//        preOrderPrintTree(root);

        buildBinaryTree(root, 4);
//        preOrderPrintTree(root);

        buildBinaryTree(root, 5);
//        preOrderPrintTree(root);

        buildBinaryTree(root, 6);
        preOrderPrintTree(root);
        problems.flattenBinaryTreeToLinkedList(root);

    }

    private TreeNode buildBinaryTree(TreeNode root, int addThis) {
        if (root==null) {
            return new TreeNode(addThis);
        }

        if (root.val < addThis) {
            root.right = buildBinaryTree(root.right, addThis);
        } else {
            root.left = buildBinaryTree(root.left, addThis);
        }
        return  root;
    }

    private void preOrderPrintTree(TreeNode root) {
        if (root != null) {
            System.out.println("Val::" + root.val);
            preOrderPrintTree(root.left);
            preOrderPrintTree(root.right);
        }
        System.out.println("---");
    }


    @Test
    public void testFlattenBinaryTreeToListInPlace() {
        TreeNode root = new TreeNode(1);

        buildBinaryTree(root, 2);
//        preOrderPrintTree(root);

        buildBinaryTree(root, 3);
//        preOrderPrintTree(root);

        buildBinaryTree(root, 4);
//        preOrderPrintTree(root);

        buildBinaryTree(root, 5);
//        preOrderPrintTree(root);

        buildBinaryTree(root, 6);
//        preOrderPrintTree(root);
        System.out.println("in place");
        problems.flattenBinaryTreeToLinkedListInPlace(root);
        root.print();
    }

    @Test
    public void testFlattenBinaryTreeToListInPlace2() {
        TreeNode root = new TreeNode(1);

        buildBinaryTree(root, 2);
        buildBinaryTree(root, 3);
        buildBinaryTree(root, 4);
        buildBinaryTree(root, 5);
        buildBinaryTree(root, 6);

        root.print();
        problems.flattenBinaryTreeToLinkedListInPlace(root);

        System.out.println("in place");
        root.print();
    }

}
