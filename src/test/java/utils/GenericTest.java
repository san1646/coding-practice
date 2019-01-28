package utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GenericTest {

    Test1 test1 = new Test1();
    Test2 test2 = new Test2();
    
    @Test
    public void testFactorial() {
        int n=225;
        System.out.println(n+">>>"+test1.factorial(n));
    }
    
    
    @Test
    public void testCountWaysToClimbStairs() {
        int n=2;
        int ways = test1.countWaysToClimbStairs(n);
        System.out.println(n+">>>"+ways);
        Assert.assertEquals(2, ways);
        
        
        n=3;
        ways = test1.countWaysToClimbStairs(n);
        System.out.println(n+">>>"+ways);
        Assert.assertEquals(3, ways);
    }
    
    @Test
    public void testQuickSort() {
        int[] arr = {4,3,2,1};
        System.out.println("Before:"+Arrays.toString(arr));
        test1.quickSort(arr);
        System.out.println("After:"+Arrays.toString(arr));
        
        arr = new int[] {7,6,5,4,3,2,2,21,3,4,5,6,7,8,9989,8,6,5,5,4,43,32,2,21,66666663,4,5,6,7,8,9989,8,6,5,5,4,43,2,2,331,3,4,5,6,7,8,9454549,8,6,5,5,4,43,33,32,4,5,5,6,7,8,8};
        System.out.println("Before:"+Arrays.toString(arr));
        test1.quickSort(arr);
        System.out.println("After:"+Arrays.toString(arr));
        
        
        arr = new int[] {0};
        System.out.println("Before:"+Arrays.toString(arr));
        test1.quickSort(arr);
        System.out.println("After:"+Arrays.toString(arr));
    }

    @Test
    public void testFindAllSubstrings() {
        String s = "abc";
        test2.findAllSubstrings(s, "");
    }

    @Test
    public void testJewelsAndStones1() {
        String J = "aA";
        String S = "aAAbb";
        int res = test1.jewelsAndStones(J, S);
        System.out.println(res);
        Assert.assertEquals(res, 3);
    }

    @Test
    public void testJewelsAndStones2() {
        String J = "z";
        String S = "ZZ";
        int res = test1.jewelsAndStones(J, S);
        System.out.println(res);
        Assert.assertEquals(res, 0);
    }

    @Test
    public void testJewelsAndStones3() {
        String J = "abcdefghijklmnopqrstuvwxyz";
        String S = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        int res = test1.jewelsAndStones(J, S);
        System.out.println(res);
        Assert.assertEquals(res, 37);
    }


    @Test(groups = "detectCapital")
    public void testDetectCapitalUse1() {
        String word = "USA";
        boolean res = test1.detectCapitalUse(word);
        Assert.assertTrue(res);
    }

    @Test(groups = "detectCapital")
    public void testDetectCapitalUse2() {
        String word = "Google";
        boolean res = test1.detectCapitalUse(word);
        Assert.assertTrue(res);
    }

    @Test(groups = "detectCapital")
    public void testDetectCapitalUse3() {
        String word = "FlaG";
        boolean res = test1.detectCapitalUse(word);
        Assert.assertFalse(res);
    }

    @Test(groups = "detectCapital")
    public void testDetectCapitalUse4() {
        String word = "ore";
        boolean res = test1.detectCapitalUse(word);
        Assert.assertTrue(res);
    }

    @Test(groups = "detectCapital")
    public void testDetectCapitalUse5() {
        String word = "So";
        boolean res = test1.detectCapitalUse(word);
        Assert.assertTrue(res);
    }

    @Test(groups = "detectCapital")
    public void testDetectCapitalUse6() {
        String word = "mL";
        boolean res = test1.detectCapitalUse(word);
        Assert.assertFalse(res);
    }


    @Test(groups = "detectCapital")
    public void testDetectCapitalUse7() {
        String word = "Roe";
        boolean res = test1.detectCapitalUse(word);
        Assert.assertTrue(res);
    }

    @Test(groups = "detectCapital")
    public void testDetectCapitalUse8() {
        String word = "oRe";
        boolean res = test1.detectCapitalUse_Elegant(word);
        Assert.assertFalse(res);
    }


    @Test(groups = "smallestIntegerNotIn")
    public void testSmallestIntegerNotIn1() {
        int[] ints = {1,3,6,4,1,2};
        int res = test1.smallestIntegerNotIn(ints);
        Assert.assertEquals(res,5);
    }

    @Test(groups = "smallestIntegerNotIn")
    public void testSmallestIntegerNotIn2() {
        int[] ints = {1,2,3};
        int res = test1.smallestIntegerNotIn(ints);
        Assert.assertEquals(res,4);
    }

    @Test(groups = "smallestIntegerNotIn")
    public void testSmallestIntegerNotIn3() {
        int[] ints = {-1,-2,-3};
        int res = test1.smallestIntegerNotIn(ints);
        Assert.assertEquals(res,1);
    }

    @Test(groups = "smallestIntegerNotIn")
    public void testSmallestIntegerNotIn4() {
        int[] ints = {-1,-3};
        int res = test1.smallestIntegerNotIn(ints);
        Assert.assertEquals(res,1);
    }

    @Test(groups = "aliveFish")
    public void testAliveFish1() {
        int[] A = {4,3,2,1,5};
        int[] B = {0,1,0,0,0};
        int res = test1.aliveFish(A, B, 5);
        System.out.println("result::"+res);
        Assert.assertEquals(res,2);
    }



    @Test
    public void testSortingBySecondArray(){

        int[] fishSizeArray = {100, 1200, 300, 400, 500};
         int[] arr = {3,2,1};

            Integer[] unsortedArray =
                    IntStream.of(arr).boxed().toArray(Integer[]::new);
            Arrays.sort(unsortedArray, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(fishSizeArray[o1], fishSizeArray[o2]);
                }
            });


        System.out.println(Arrays.toString(unsortedArray));


    }


}
