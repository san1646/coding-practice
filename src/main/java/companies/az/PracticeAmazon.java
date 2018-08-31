package companies.az;

import java.util.Arrays;

public class PracticeAmazon {

    /**
     * https://leetcode.com/problems/couples-holding-hands/hints/
     * 
     * N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps
     * so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and
     * switch seats.
     * 
     * The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first
     * couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).
     * 
     * The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the
     * i-th seat.
     * 
     * Example 1:
     * 
     * Input: row = [0, 2, 1, 3]
     * Output: 1
     * Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
     * Example 2:
     * 
     * Input: row = [3, 2, 0, 1]
     * Output: 0
     * Explanation: All couples are already seated side by side.
     * Note:
     * 
     * len(row) is even and in the range of [4, 60].
     * row is guaranteed to be a permutation of 0...len(row)-1.
     * 
     * @param row
     * @return
     * STATUS: not working
     */
    public int minSwapsCouples(int[] row) {

        
        return minSwap(row, 0);
    }

    private int minSwap(int[] row, int startIndex) {
        if (arePair(row[startIndex], row[startIndex+1])) {
            // no swap
            return minSwap(row, startIndex + 2);
        }
        // swap i+1 with pair of i get return val and undo
        // swap i with pair of i+1 get return val and undo
        int indexOfPair_i = getPairValueIndex(row, startIndex);
        row = swap(row, startIndex+1, indexOfPair_i);//swap the plus one and pair
        //undo
        
        int indexOfPair_iPlus1 = getPairValueIndex(row, startIndex+1);
        row = swap(row, startIndex+1, indexOfPair_iPlus1);//swap the one and plus one pair
        //undo
        
        return 1;// + Math.min(a, b);
    }

    /**
     * row - whole row
     * swapIndex - index at which we want to swap
     * swapWithIndex - this is the index we use to find pair to swap
     * 
     * @param row
     * @param swapIndex
     * @param pairOfIndexValue
     * @return
     */
    private int[] swap(int[] row, int swapIndex, int swapWithIndex) {

        int pairValue = row[getPairValueIndex(row, swapWithIndex)];
        return row;
    }

    private int getPairValueIndex(int[] row, int indexOfValue) {
        int pairValue = getPairOf(row[indexOfValue]);
        for (int i = 0; i < row.length; i++) {
            if (row[i] == pairValue) {
                return i;
            }
        }
        return -1;
    }

    private int getPairOf(int a) {
        return a % 2 == 0 ? a + 1 : a - 1;
    }

    private boolean arePair(int val1, int val2) {
        if (Math.abs(val2 - val1) == 1) {
            return true;
        }
        return false;
    }

}
