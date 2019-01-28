package utils;

import org.testng.collections.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

/** Test 1 is a class for practice code */
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
   * @return STATUS: WORKING
   */
  public void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private void quickSort(int[] arr, int left, int right) {
    if (left >= right) return;
    int pIndex = (left + right) / 2;

    int ind = partition(arr, left, right, pIndex);
    quickSort(arr, left, ind - 1);
    quickSort(arr, ind, right);

    return;
  }

  private int partition(int[] arr, int left, int right, int pIndex) {
    while (left <= right) {
      while (arr[left] < arr[pIndex]) {
        left++;
      }
      while (arr[right] > arr[pIndex]) {
        right--;
      }
      if (left <= right) {
        swap(arr, left, right);
        left++;
        right--;
      }
    }
    return left;
  }

  private void swap(int[] arr, int left, int right) {
    int t = arr[left];
    arr[left] = arr[right];
    arr[right] = t;
  }

  /**
   * removes duplicates from the arr
   *
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
   * Min number of swaps to sort This uses bubble sort
   *
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
    for (Iterator iterator = count.keySet().iterator(); iterator.hasNext(); ) {
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
    if (arr.length < 1) return;

    if (start >= arr.length) return;

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
   *
   * @param arr
   * @param low
   * @param high
   */
  static void quickSort1(int[] arr, int low, int high) {
    if (arr.length < 1) return;
    int p = arr[0];

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < p) {
        int t = arr[i];
        arr[i] = p;
      }
    }
  }

  public int factorial(int n) {
    if (n == 1) return 1;
    return n * factorial(n - 1);
  }

  /**
   * https://leetcode.com/problems/climbing-stairs/description/
   *
   * <p>You are climbing a stair case. It takes n steps to reach to the top.
   *
   * <p>Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the
   * top?
   *
   * <p>Note: Given n will be a positive integer.
   *
   * <p>Example 1:
   *
   * <p>Input: 2 Output: 2 Explanation: There are two ways to climb to the top. 1. 1 step + 1 step
   * 2. 2 steps Example 2:
   *
   * <p>Input: 3 Output: 3 Explanation: There are three ways to climb to the top. 1. 1 step + 1 step
   * + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
   *
   * <p>Notes: permutation (n, k) = n! / (n - k)!
   *
   * @return
   * @param n
   *     <p>STATUS: not working
   */
  public int countWaysToClimbStairs(int n) {

    int one = 1, two = 2;
    int total = 0;
    total += countWaysToClimbStairs(n - one);
    return 0;
  }

  /** https://leetcode.com/problems/jewels-and-stones/ */
  public int jewelsAndStones(String J, String S) {

    char[] arrj = J.toCharArray();
    char[] arrs = S.toCharArray();

    int res = 0;
    for (char c : arrs) {
      for (char j : arrj) {
        if (c == j) {
          res++;
          break;
        }
      }
    }

    return res;
  }

  /**
   * https://leetcode.com/problems/detect-capital/
   *
   * @param word
   * @return
   */
  public boolean detectCapitalUse(String word) {

    char[] letters = word.toCharArray();

    if (letters.length == 0) return false;
    if (letters.length == 1) return true;

    boolean allCaps = false, allSmalls = false;

    if (letters[0] >= 'A' && letters[0] <= 'Z') {
      allCaps = letters[1] >= 'A' && letters[1] <= 'Z';
    }

    if (letters[0] >= 'a' && letters[0] <= 'z') {
      allSmalls = letters[1] >= 'a' && letters[1] <= 'z';
    }

    if (letters.length == 2) {
      if (allCaps == allSmalls) {
        return letters[0] >= 'A' && letters[0] <= 'Z';
      }
      return allCaps || allSmalls;
    }

    for (int i = 2; i < letters.length; i++) {
      boolean val1 = isCapital((int) letters[i]);

      if (allCaps == allSmalls) { // both can be equal only on false i.e. mixed case
        if (letters[0] >= 'a' && letters[0] <= 'z') {
          return false;
        }
      }

      if ((allCaps != val1)) {
        return false;
      }
    }
    return true;
  }

  private boolean isCapital(int val) {
    return val >= 65 && val <= 90;
  }

  /**
   * Not my code, but nicely done
   *
   * @param word
   * @return
   */
  public boolean detectCapitalUse_Elegant(String word) {
    int cnt = 0;
    for (char c : word.toCharArray()) if ('Z' - c >= 0) cnt++;
    return ((cnt == 0 || cnt == word.length()) || (cnt == 1 && 'Z' - word.charAt(0) >= 0));
  }

  /**
   * not mine
   *
   * @param word
   * @return
   */
  public boolean detectCapitalUse_Elegant2(String word) {
    if (word == null || word.length() == 0) return true;

    char ch = word.charAt(0);
    boolean isFirstCap = isCap(ch);
    int countCap = isFirstCap ? 1 : 0;
    for (int i = 1; i < word.length(); i++) {
      countCap += isCap(word.charAt(i)) ? 1 : 0;
    }
    return countCap == 0 || countCap == word.length() || (countCap == 1 && isFirstCap);
  }

  private boolean isCap(char ch) {
    return ch >= 'A' && ch <= 'Z';
  }

  /**
   * Find the smallest integer not in the array For example, given A = [1, 3, 6, 4, 1, 2], the
   * function should return 5.
   *
   * <p>Given A = [1, 2, 3], the function should return 4.
   *
   * <p>Given A = [−1, −3], the function should return 1.
   *
   * <p>Write an efficient algorithm for the following assumptions:
   *
   * <p>N is an integer within the range [1..100,000]; each element of array A is an integer within
   * the range [−1,000,000..1,000,000].
   *
   * @param A
   * @return
   */
  public int smallestIntegerNotIn(int[] A) {
    // write your code in Java SE 8
    if (A.length == 0) {
      return 0;
    }

    Arrays.sort(A);
    int smallest = 1;
    for (int i = 0; i < A.length; i++) {
      if (smallest == A[i]) {
        smallest++;
      }
    }

    return smallest; // smallest==0? smallest+1: smallest;
  }

  /**
   * You are given two non-empty arrays A and B consisting of N integers. Arrays A and B represent N
   * voracious fish in a river, ordered downstream along the flow of the river.
   *
   * <p>The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q, then fish P is
   * initially upstream of fish Q. Initially, each fish has a unique position.
   *
   * <p>Fish number P is represented by A[P] and B[P]. Array A contains the sizes of the fish. All
   * its elements are unique. Array B contains the directions of the fish. It contains only 0s
   * and/or 1s, where:
   *
   * <p>0 represents a fish flowing upstream, 1 represents a fish flowing downstream. If two fish
   * move in opposite directions and there are no other (living) fish between them, they will
   * eventually meet each other. Then only one fish can stay alive − the larger fish eats the
   * smaller one. More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1
   * and B[Q] = 0, and there are no living fish between them. After they meet:
   *
   * <p>If A[P] > A[Q] then P eats Q, and P will still be flowing downstream, If A[Q] > A[P] then Q
   * eats P, and Q will still be flowing upstream. We assume that all the fish are flowing at the
   * same speed. That is, fish moving in the same direction never meet. The goal is to calculate the
   * number of fish that will stay alive.
   *
   * <p>For example, consider arrays A and B such that:
   *
   * <p>A[0] = 4 B[0] = 0 A[1] = 3 B[1] = 1 A[2] = 2 B[2] = 0 A[3] = 1 B[3] = 0 A[4] = 5 B[4] = 0
   * Initially all the fish are alive and all except fish number 1 are moving upstream. Fish number
   * 1 meets fish number 2 and eats it, then it meets fish number 3 and eats it too. Finally, it
   * meets fish number 4 and is eaten by it. The remaining two fish, number 0 and 4, never meet and
   * therefore stay alive.
   *
   * <p>Write a function:
   *
   * <p>class Solution { public int solution(int[] A, int[] B); }
   *
   * <p>that, given two non-empty arrays A and B consisting of N integers, returns the number of
   * fish that will stay alive.
   *
   * <p>For example, given the arrays shown above, the function should return 2, as explained above.
   *
   * <p>Write an efficient algorithm for the following assumptions:
   *
   * <p>N is an integer within the range [1..100,000]; each element of array A is an integer within
   * the range [0..1,000,000,000]; each element of array B is an integer that can have one of the
   * following values: 0, 1; the elements of A are all distinct.
   *
   * <p>https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
   *
   * @param A
   * @param B
   * @return
   */
  public int aliveFish(int[] A, int[] B, int N) {

    int currentDirection = 0; // upstream
    int aliveFish = A.length;

    // find all indices for upstream from B
    List<Integer> upstreamIndices = new ArrayList<>();
    List<Integer> downstreamIndices = new ArrayList<>();
    for (int i = 0; i < B.length; i++) {
      if (B[i] == currentDirection) {
        upstreamIndices.add(i);
      } else {
        downstreamIndices.add(i);
      }
    }

    //List<Integer> uIndices = sortBySize(upstreamIndices, A);
    //List<Integer> dIndices = sortBySize(downstreamIndices, A);
    List<Integer> uIndices = upstreamIndices;
    List<Integer> dIndices = downstreamIndices;

    printList("Start u",uIndices);
    printList("Start d",dIndices);
    // uIndices has all upstream fishes sorted by size
    for (int d = 0; d < dIndices.size(); d++) {
      for (int u = 0; u < uIndices.size(); u++) {

        if (dIndices.get(d) > uIndices.get(u)){
          continue;
        }
        if ( dIndices.get(d)>0 && uIndices.get(u)>0 &&
                A[dIndices.get(d)]-A[uIndices.get(u)]  > 0) {
          // dstream fish ate ustream fish
          // kill ustream fish

          uIndices.add(u, -1);
          uIndices.remove(u+1);
          printList("uIndices when if:",uIndices);
          printList("dIndices when if:",dIndices);
        } else { // no 2 fish are same size, no it can never be 0

          // upstream fish ate downstream fish
          // kill downstream fish
          printList("dIndices when else before remove:",dIndices);

          dIndices.add(d, -1);
          dIndices.remove(d+1);
          printList("uIndices when else:",uIndices);
          printList("dIndices when else:",dIndices);



        }
        // either case decrement count
        aliveFish--;
      }

      printList("End u",uIndices);
      printList("End d",dIndices);
    }

    return aliveFish;
  }

  private static int findSmallestFishInOneDirection(int[] A) {
    int smallest = 0;
    for (int i : A) {
      if (A[i] < A[smallest]) {
        smallest = i;
      }
    }
    return smallest;
  }

  private static List<Integer> sortBySize(List<Integer> list, final int[] fishSizeArray) {
    Collections.sort(
        list,
        new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return Integer.compare(fishSizeArray[o1], fishSizeArray[o2]);
          }
        });
    Integer[] arr = new Integer[list.size()];
    return list;
  }

  private void printList(String msg, List<?> list) {
    System.out.print(msg+"<<<");
    for (Object model : list) {
      if(model!=null){
        System.out.print(model.toString());
      }else{
        System.out.print("NULL");
      }

    }
    System.out.println(">>>");
  }
}
