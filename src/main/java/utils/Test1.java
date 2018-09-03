package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
* Test 1 is a class for practice code
* */
public class Test1 {

    public static void main(String[] args) {
        // System.out.println(anagramCount("abc", "abcd"));

        // int[] pop = {15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        // System.out.println(minimumSwaps(pop));

        // int[] a = {7, 2, 3, 10, 2, 4, 8, 1};
        // System.out.println(maxDifference(a));

        // Merge sort
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array:");
        System.out.print(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array: ");
        System.out.print(Arrays.toString(arr));
        
        
    }

    /**
     * private method for mergeSort()
     * 
     * @param arr
     * @param l
     * @param m
     * @param r
     */
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        // int[] sortedArr = new int[arr.length];
        int[] lArr = new int[n1];
        int[] rArr = new int[n2];

        // copy into temp arrays
        for (int i = 0; i < n1; ++i) {
            lArr[i] = arr[l + i];
        }
        for (int i = 0; i < n2; ++i) {
            rArr[i] = arr[m + 1 + i];
        }

        // merge the temp arrays
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = lArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }

    /**
     * implementation of merge sort
     * 
     * @param arr
     * @param l
     * @param r
     */
    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            // midpoint
            int m = (l + r) / 2;

            // sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // merge the second halves
            merge(arr, l, m, r);

        }
    }
    
    /**
     * Quick sort using median as pivot
     * 
     * @param arr
     * @return
     * 
     *         STATUS: WORKING
     */
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if(left >=right) return;
        int pIndex = (left + right ) / 2;
        
        int ind = partition(arr, left, right, pIndex);
        quickSort(arr, left, ind - 1);
        quickSort(arr, ind, right);
        
        return;
    }
    
    private int partition(int [] arr, int left, int right, int pIndex) {
        while(left <=right) {
            while(arr[left] < arr[pIndex]) {
                left++;
            }
            while(arr[right] > arr[pIndex]) {
                right--;
            }
            if(left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    
    private void swap(int[] arr, int left, int right) {
        int t = arr[left];
        arr[left]=arr[right];
        arr[right] = t;
    }
    
    
    /**
     * removes duplicates from the arr
     * @param popularity
     * @return
     */
    private static int[] getMinArray(int[] popularity) {
        Set<Integer> set1 = new LinkedHashSet<Integer>();
        int index = 0;

        for (int i = 0; i < popularity.length; i++) {
            try {
                set1.add(popularity[i]);
            } catch (Exception e) {
                // Do nothing
            }
        }

        int[] minArr = new int[set1.size()];
        for (Integer integer : set1) {
            minArr[index++] = integer;
        }
        return minArr;
    }

    /**
     * Min number of swaps to sort
     * This uses bubble sort
     * @param popularity
     * @return
     */
    public int minimumSwaps(int[] popularity) {
        int[] minArr = getMinArray(popularity);
        int swapCount = 0;

        for (int i = 0; i < minArr.length; i++) {
            for (int j = 1; j < minArr.length - 1; j++) {
                if (minArr[j - 1] < minArr[j]) {
                    Integer tmp = minArr[j - 1];
                    minArr[j - 1] = minArr[j];
                    minArr[j] = tmp;
                    swapCount++;
                }
            }
        }

        return swapCount;
    }

    static int maxDifference(int[] a) {
        int maxDiff = -1;
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < i; k++) {
                // diffArray[k] = a[i]-a[i-1];
                if (a[i] > a[k] && maxDiff < (a[i] - a[k])) {
                    maxDiff = a[i] - a[k];
                }
            }

        }
        return maxDiff;
    }

    public static Integer anagramCount(String f, String s) {
        Collections.emptyList();
        int[] aa = new int[9];
        int t = aa.length;
        Map<Character, Integer> count = new HashMap<Character, Integer>();

        for (int i = 0; i < f.toCharArray().length; i++) {
            Integer value = count.containsKey(f.charAt(i)) ? count.get(f.charAt(i)) : 0;
            count.put(f.charAt(i), value + 1);
        }

        for (int i = 0; i < s.toCharArray().length; i++) {
            Integer value = count.containsKey(s.charAt(i)) ? count.get(s.charAt(i)) : 0;
            count.put(s.charAt(i), value - 1);
        }

        Integer total = 0;
        for (Iterator iterator = count.keySet().iterator(); iterator.hasNext();) {
            Character c = (Character) iterator.next();
            total += count.get(c);
        }

        return total;
    }

    /**
     * [2,3,5,1,7,9]
     * 
     * @param arr
     */
    static void selectionSort(int[] arr, int start) {
        if (arr.length < 1)
            return;

        if (start >= arr.length)
            return;

        int min = arr[start];
        int minIndex = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        int t = arr[0];
        arr[0] = arr[minIndex];
        arr[minIndex] = t;

    }

    /**
     * OLD - NOT WORKING
     * @param arr
     * @param low
     * @param high
     */
    static void quickSort1(int[] arr, int low, int high) {
        if (arr.length < 1)
            return;
        int p = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < p) {
                int t = arr[i];
                arr[i] = p;

            }
        }
    }
    
    public int factorial(int n) {
        if(n==1) return 1;
        return n * factorial(n-1);
    }

    
    /**
     * https://leetcode.com/problems/climbing-stairs/description/
     * 
     * You are climbing a stair case. It takes n steps to reach to the top.
     * 
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * 
     * Note: Given n will be a positive integer.
     * 
     * Example 1:
     * 
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     * 
     * Input: 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     * 
     * Notes: permutation (n, k) = n! / (n - k)!
     * @return
     * @param n
     * 
     * STATUS: not working
     */
    public int countWaysToClimbStairs(int n) {

        int one = 1, two = 2;
        int total=0;
        total += countWaysToClimbStairs(n - one);
        return 0;
    }

    
    

}
