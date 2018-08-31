package companies.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WeightedUniformStrings {

    /**
     * https://www.hackerrank.com/challenges/weighted-uniform-string/problem
     * 
     * @param s
     * @param queries
     * @return
     */
    public String[] weightedUniformStrings(String s, int[] queries) {
        String[] result = new String[queries.length];
         List<Integer> weights = new ArrayList<Integer>();
        String LETTER_WEIGHT = "abcdefghijklmnopqrstuvwxyz";//.indexOf('F');
        char[] arr = s.toCharArray();
        List<String> unifiedStrings = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        //aaa bbbb ccc ddd
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if(i!=arr.length-1 && arr[i]==arr[i+1]) {
                continue;
            }else {
                unifiedStrings.add(sb.toString());
                sb = null;
                sb = new StringBuilder();
            }
        }
        System.out.println(""+unifiedStrings.get(0));
        for (String ss : unifiedStrings) {
            for (int i = 1; i <= ss.toCharArray().length; i++) {
                weights.add((1+LETTER_WEIGHT.indexOf(ss.toCharArray()[0])) * i);
            }
            
        }
        System.out.println(""+weights.get(0));

        for (int i=0;i<queries.length;i++) {
            result[i] = weights.contains(queries[i]) ? "Yes" : "No";
            
        }
        return result;

    }

}
