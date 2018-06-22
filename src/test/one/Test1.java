package test.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
    private static void merge(int[] arr, int l, int m, int r) {
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

    static int minimumSwaps(int[] popularity) {
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

    static void quickSort(int[] arr, int low, int high) {
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

}
