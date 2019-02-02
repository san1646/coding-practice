package utils.leet;

public class Problems {

    /**
     * https://leetcode.com/problems/flipping-an-image/
     *
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {

        int[][] fnr = new int[A.length][];
        for (int i = 0; i < A.length; i++) {
            fnr[i] = new int[A[i].length];
            for (int j = A[i].length - 1; j >= 0; j--) {
                fnr[i][fnr[i].length - 1 - j] = A[i][j] == 0 ? 1 : 0;
            }
        }

        return fnr;
    }

    /**
     * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
     *
     * Accepted
     * Note: can improve memory usage
     * 2019-02-02T15:12:36.136EST
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] topView = new int[grid[0].length];
        int[] sideView = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (sideView[i] < grid[i][j]) {
                    sideView[i] = grid[i][j];
                }
                if (topView[j] < grid[i][j]) {
                    topView[j] = grid[i][j];
                }
            }
        }

        print1DArray(sideView, "sideView");
        print1DArray(topView, "topView");

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int minHeight = sideView[i] < topView[j] ? sideView[i] : topView[j];
//                System.out.println("minHeight:::" + minHeight);
                if (grid[i][j] < minHeight) {
                    sum += minHeight - grid[i][j];
                }
            }
        }

        return sum;
    }

    private void print1DArray(int[] A, String name) {
        System.out.print("<<" + name + "--");
        for (int i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
        System.out.println(">>");
    }

    private void print2DArray(int[][] A, String name) {
        System.out.println("--" + name + "--");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println("--" + i);
        }
    }
}
