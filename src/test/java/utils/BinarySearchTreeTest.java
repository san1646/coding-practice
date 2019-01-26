package utils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BinarySearchTreeTest {
    BinarySearchTree tree = new BinarySearchTree();

    @Test
    public void testPostOrderTraversal1() {

        int in[] = new int[]{4, 2, 5, 1, 6, 3};
        int pre[] = new int[]{1, 2, 4, 5, 3, 6};
        int len = in.length;
        tree.root = tree.buildTree(in, pre, 0, len - 1);
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.postOrderTraversal(tree.root);
        System.out.println();
    }
    
    @Test
    public void testSizeOfTree() {

        int in[] = new int[]{4, 2, 5, 1, 6, 3};
        int pre[] = new int[]{1, 2, 4, 5, 3, 6};
        int len = in.length;
        tree.root = tree.buildTree(in, pre, 0, len - 1);
        int size = tree.sizeOfTree(tree.root);
        System.out.println("\nSize of binary tree is "+6);
        Assert.assertEquals(6, size);
    }
    
    @Test
    public void testPostAndInOrderTraversal() {

        int in[] = new int[]{4, 2, 5, 1, 6, 3};
        int pre[] = new int[]{1, 2, 4, 5, 3, 6};
        int len = in.length;
        tree.root = tree.buildTree(in, pre, 0, len - 1);
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.postOrderTraversal(tree.root);
        
        System.out.println("\nInorder traversal of binary tree is ");
        tree.inOrderTraversal(tree.root);
        System.out.println();
    }
}
