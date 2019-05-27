package utils.leet;

import java.util.Date;
import java.util.StringJoiner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Problems2 {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        inOrderTraversal(root, L, R);
        return sum;
    }

    /*      11
            5
            3
            2
            4
            6
            7
            8
            12
            11
            14*/
    private void inOrderTraversal(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }

        if (root.left != null) {
            inOrderTraversal(root.left, L, R);
        }
        if (root.right != null) {
            inOrderTraversal(root.right, L, R);
        }
    }

    public String reverseString(String x) {
        char[] rr = new char[x.length()];
        for (int i = x.length() - 1; i >= 0; i--) {
            rr[x.length() - i - 1] = x.charAt(i);
        }
        return String.valueOf(rr);
    }

    /**
     * https://leetcode.com/problems/complex-number-multiplication/
     *
     * @return
     */
    public String complexNumberMultipy(String one, String two) {
        String[] ones = one.split("\\+");
        String[] twos = two.split("\\+");
        //(a+b) * (c+d) = ac+ad+bc+bd
        String imaginary = "0";
        String real = "0";
        for (int i = 0; i < ones.length; i++) {
            for (int j = 0; j < ones.length; j++) {
                String x = multiplyComplex(ones[i], ones[i].contains("i"), twos[j], twos[j].contains("i"));
                if (x.contains("i")) {
                    imaginary = String.valueOf(
                            Integer.parseInt(x.replace("i", ""))
                                    + Integer.parseInt(imaginary)
                    );
                } else {
                    real = String.valueOf(Integer.parseInt(x) + Integer.parseInt(real));
                }
            }
        }
        return real + "+" + imaginary + "i";
    }

    /**
     * Input = 2, 3i Result = 6i
     *
     * @param a
     * @param b
     * @return
     */
    private String multiplyComplex(String a, boolean ia, String b, boolean ib) {
        String val = "";
        int numA = Integer.parseInt(a.replace("i", ""));
        int numB = Integer.parseInt(b.replace("i", ""));
        if (ia && ib) {
            val = String.valueOf(-1 * numA * numB);
        } else {
            if (ia != ib) {
                val = String.valueOf(numA * numB) + "i";
            } else {
                val = String.valueOf(numA * numB);
            }
        }
        return val;
    }

}
