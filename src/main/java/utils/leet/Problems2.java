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
        for (int i=x.length()-1;i>=0;i--) {
            rr[x.length()-i-1] = x.charAt(i);
        }
        return String.valueOf(rr);
    }

    /**
     * https://leetcode.com/problems/complex-number-multiplication/
     * @return
     */
    public String complexNumberMultipy(String one, String two){
        //a+bi
        String[] ones = parse(one);
        String[] twos = parse(two);
        //(a+b) * (c+d) = ac+ad+bc+bd
        String imaginary = "0";
        String real = "0";
        for(int i =0;i<ones.length;i++){
            for(int j =0;j<ones.length;j++){
                String x = multiplyComplex(ones[i], twos[j]);
                if(x.contains("i")){
                    imaginary = String.valueOf(
                            Integer.parseInt(x.replace("i", ""))
                            + Integer.parseInt(imaginary)
                    );
                }else{
                    real = String.valueOf(Integer.parseInt(x) + Integer.parseInt(real));
                }
            }
        }
        //11i1i-1

        String value = real +"+" + imaginary +"i";

        return value;
    }

    private String[] parse(String sss){
        String [] parts = sss.split("\\+");
        String[] complete = new String[2];
        complete[0] = parts[0];
        complete[1] = parts[1];
        return complete;
    }

    private String multiplyComplex(String a, String b) {
        int numA, numB;
        //-12+-13i
        //eg a = [-,1,2]
        //b=[-,1,3,i]
        boolean ia = false, ib = false;
        if (a.contains("i")) {
            numA = Integer.parseInt(a.replace("i", ""));
            ia = true;
        } else {
            numA = Integer.parseInt(a);
        }
        if (b.contains("i")) {
            numB = Integer.parseInt(b.replace("i", ""));
            ib = true;
        } else {
            numB = Integer.parseInt(b);
        }

        String val = "";
        if (ia && ib) {
            val = String.valueOf(-1 * numA * numB);
        } else {
            if (ia && ib == false || ia == false && ib) {
                val = String.valueOf(numA * numB) + "i";
            }else{
                val = String.valueOf(numA * numB);
            }
        }
        return val;
    }

}
