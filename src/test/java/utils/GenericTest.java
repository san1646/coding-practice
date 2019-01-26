package utils;

import java.util.Arrays;

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
}
