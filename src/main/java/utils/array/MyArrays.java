package utils.array;

import java.util.ArrayList;
import java.util.List;

public class MyArrays {

    /**
     * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
     * 
     * Sample Input
     * 
     * 1 1 1 0 0 0
     * 0 1 0 0 0 0
     * 1 1 1 0 0 0
     * 0 0 2 4 4 0
     * 0 0 0 2 0 0
     * 0 0 1 2 4 0
     * Sample Output
     * 
     * 19
     * 
     * The hourglass with the maximum sum () is:
     * 
     * 2 4 4
     * 2
     * 1 2 4
     * 
     * @param arr
     * @return
     * STATUS: works
     */
    public int hourglassSum(int[][] arr) {

        List<Integer> allsums = new ArrayList<>();
        int highest = 0;
       
        for (int i = 0; i <= arr.length - 3; i++) {// iterate horizontally
            
            for (int k = 0; k <= arr[i].length-3; k++) {// iterate vertically
                int sum = 0;
                sum += arr[i][k];
                sum += arr[i][k + 1];
                sum += arr[i][k + 2];

                sum += arr[i + 1][k + 1];

                sum += arr[i + 2][k];
                sum += arr[i + 2][k + 1];
                sum += arr[i + 2][k + 2];
                
                allsums.add(sum);
                if(sum>highest) highest = sum;

            }
        }

        return highest;
    }
}
