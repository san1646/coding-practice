package utils.bst;

import org.testng.annotations.Test;

public class BinarySearchTreeTest {

    @Test
    public void testBinarySearchTreeInsert() {

            BinarySearchTree bst = new BinarySearchTree();
         
            bst.add(6);
            bst.add(4);
            bst.add(8);
            bst.add(3);
            bst.add(5);
            bst.add(7);
            bst.add(9);
         
            bst.postOrderTraversal(bst.root);
    }
}
