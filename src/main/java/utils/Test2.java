package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        //System.out.println("" + roundRotation("abc", "bcabc"));
        
        int[] arr = {4, 5, 15, 1, 3};
        int [] arr2 = {1, 3, 4, 2, 6, 5, 8, 7,66, 67, 76, 34, 55, 888};
        System.out.println("Median is :"+findMedian(arr2));
    }

    /**
     * 1) Given two words, find if second word is the round rotation of first word.
     * For example: abc, cab
     * return 1
     * since cab is round rotation of abc
     * 
     * Example2: ab, aa
     * return -1
     * 
     * @param a
     * @param b
     * @return
     */
    static int roundRotation(String a, String b) {
        String t = a + a;
        boolean r = false;
        for (int i = 0; i < t.toCharArray().length; i++) {
            r = t.regionMatches(i, b, 0, b.length());
            if (r)
                return 1;
        }
        return -1;
    }
    
    static double findMedian(int[] arr) {
        List<Double> list = new ArrayList<Double>();
        
        for (int i = 0; i < arr.length; i++) {
            for(int j = i+1;j<=arr.length-1;j++) {
                if(arr[j] < arr[i]) {
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        if(arr.length % 2 != 0) {
            return (double)arr[arr.length/2];
        }else {
            return (double)(arr[(arr.length/2)-1] + arr[(arr.length/2)])/2;
        }
        //list.sort(null);
        
    }

    



}
