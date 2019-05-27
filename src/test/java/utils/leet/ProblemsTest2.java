package utils.leet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProblemsTest2 {

    Problems2 problems2 = new Problems2();


    @Test
    public void test1() {

        TreeNode root = new TreeNode(11);

        root.add(12);
        root.add(11);
        root.add(14);

        root.add(5);

        root.add(3);
        root.add(2);
        root.add(4);

        root.add(6);
        root.add(7);
        root.add(8);

        root.inOrderTraversal();
        System.out.println(root.toString());
        BTreePrinter.printNode(root);
    }

    @Test
    public void testRangeSumBST() {

        TreeNode root = new TreeNode(11);

        root.add(12);
        root.add(11);
        root.add(14);

        root.add(5);

        root.add(3);
        root.add(2);
        root.add(4);

        root.add(6);
        root.add(7);
        root.add(8);

//        root.inOrderTraversal();
//        System.out.println(root.toString());
//        BTreePrinter.printNode(root);

        int res = problems2.rangeSumBST(root, 2, 4);
        Assert.assertEquals(9, res);
    }

    @Test
    public void testReverseString(){
        Assert.assertEquals("cba",problems2.reverseString("abc"));
    }

    @Test()
    public void testMultiplyComplexNumbers1(){
        Assert.assertEquals("0+2i",problems2.complexNumberMultipy("1+1i","1+1i"));
    }

    @Test
    public void testMultiplyComplexNumbers2(){
        Assert.assertEquals("0+-2i",problems2.complexNumberMultipy("1+-1i","1+-1i"));
    }

    @Test
    public void testMultiplyComplexNumbers3(){
        Assert.assertEquals("0+-2i",problems2.complexNumberMultipy("1+-1i","1+-1i"));
    }

}
