package utils.array;

import java.util.Arrays;
import org.testng.annotations.Test;

public class MyArraysTest {

    MyArrays arrays = new MyArrays();

    /**
     * 1 1 1 0 0 0
     * 0 1 0 0 0 0
     * 1 1 1 0 0 0
     * 0 0 2 4 4 0
     * 0 0 0 2 0 0
     * 0 0 1 2 4 0
     */
    @Test
    public void testHourGlass1() {
        int[][] arrInt = {{1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};

        for (int i = 0; i < arrInt.length; i++) {
            System.out.println(Arrays.toString(arrInt[i]));
        }
        int sum = arrays.hourglassSum(arrInt);
        // [7, 4, 2, 0, 8, 10, 8, 7, 6, 14]
        System.out.println("first sum = " + sum);
    }

    /**
     * 0 -4 -6 0 -7 -6
     * -1 -2 -6 -8 -3 -1
     * -8 -4 -2 -8 -8 -6
     * -3 -1 -2 -5 -7 -4
     * -3 -5 -3 -6 -6 -6
     * -3 -6 0 -8 -6 -7
     * ---------------------
     * 
     * -1 -1 0 -9 -2 -2
     * -2 -1 -6 -8 -2 -5
     * -1 -1 -1 -2 -3 -4
     * -1 -9 -2 -4 -4 -5
     * -7 -3 -3 -2 -9 -9
     * -1 -3 -1 -2 -4 -5
     * not working test cases
     */
    @Test
    public void testHourGlass2() {

    }

}
