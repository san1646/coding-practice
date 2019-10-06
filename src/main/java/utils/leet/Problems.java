package utils.leet;

import java.lang.reflect.Array;
import java.util.*;
import java.util.*;
import java.util.stream.IntStream;

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
     * <p>
     * Accepted Note: can improve memory usage 2019-02-02T15:12:36.136EST
     *
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

    private void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.println(">" + i);
        }
        System.out.println("---");
    }

    /**
     * /** * Definition for a binary tree node. * public class TreeNode { *     int val; *     TreeNode left; *
     * TreeNode right; *     TreeNode(int x) { val = x; } * }
     * <p>
     * Understood the question wrong; This creates a new list https://leetcode
     * .com/problems/flatten-binary-tree-to-linked-list/
     */
    public void flattenBinaryTreeToLinkedList(TreeNode root) {
        List<Integer> flattenedList = new LinkedList<>();
        flattenedList = flattenTree(root, flattenedList);
        printList(flattenedList);
    }

    private List<Integer> flattenTree(TreeNode curr, List<Integer> flattenedList) {
        if (curr != null) {
            flattenedList.add(curr.val);
            flattenTree(curr.left, flattenedList);
            flattenTree(curr.right, flattenedList);
        }
        return flattenedList;
    }

    /**
     * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
     *
     *    1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * @param node
     */
    public void flattenBinaryTreeToLinkedListInPlace(TreeNode node) {
        if(node==null) return;

        TreeNode left = node.left;
        TreeNode right = node.right;
        flattenBinaryTreeToLinkedListInPlace(node.left);
        flattenBinaryTreeToLinkedListInPlace(node.right);

        if(left!=null){
            node.left=null;
        }
        if(left!=null && right!=null){
            left.right=right;
            flattenBinaryTreeToLinkedList(right);
            node.right=left;
        }

        return;
    }

    /**
     * https://leetcode.com/problems/encode-and-decode-tinyurl/
     * Uses Base64 API
     * @param longUrl
     * @return
     */
    Map<Integer, String> encodedStrings = new HashMap<>();
    public String encode(String longUrl) {

        Map<Integer, String> map = new HashMap<>();
        Random r=new Random();
        int key=r.nextInt(10000);
            while(map.containsKey(key)) {
                key = r.nextInt(10000);
            }
            map.put(key,longUrl);
            return "http://tinyurl.com/"+key;
        /*public String decode(String shortUrl) {
            return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
        }*/

    }

    /**
     * https://leetcode.com/problems/maximum-product-of-three-numbers/
     * @param nums
     * @return
     *
     * TODO not working for negative numbers
     */
    public int maximumProduct(int[] nums) {
        if(nums.length>=3) {
            Arrays.sort(nums);
            System.out.println("after sort: "+Arrays.toString(nums));
            return nums[nums.length-1]
                    * nums[nums.length-2]
                    *nums[nums.length-3];
        }
        else return 0;
    }

    /**
     * https://leetcode.com/problems/backspace-string-compare/
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        return compile(S).equalsIgnoreCase(compile(T));
    }

    private String compile(String S) {
        final char b = '#';
        StringBuilder compiledS = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (b == c && compiledS.length() == 0) {
                continue;
            } else if (b == c) {
                compiledS.deleteCharAt(compiledS.length() - 1);
            } else {
                //non backspace char
                compiledS.append(c);
            }
        }
        return compiledS.toString();
    }

    /**
     *
     * In Pramp interview 20190407
     * input:  text = “(()”
     * output: 1
     *
     * input:  text = “(())”
     * output: 0
     *
     * input:  text = “())(”
     * output: 2
     * @param text
     * @return
     */
        public int bracketMatch(String text) {
            // your code goes here
            char[] arr = text.toCharArray();

            int ans=0;
            int replace=0;

            Stack<Integer> stk = new Stack<Integer>();

            for(char c: arr){
                if(c == '('){
                    replace +=1;

                } else if(c == ')' ){
                    replace -= 1;
                }
                if(replace < 0){
                    replace += 1;
                    ans += 1;
                }

            }//end for

            return replace + ans;
        }

   /* Array Index & Element Equality
    Given a sorted array arr of distinct integers,
    write a function indexEqualsValueSearch that
    returns the lowest index i for which arr[i] == i. Return -1
            if there is no such index.
    Analyze the time and space complexities of your solution and explain its correctness.

            Examples:

    input: arr = [-8,0,2,5]
    output: 2 # since arr[2] == 2

    input: arr = [-1,0,3,6]
    output: -1 # since no index in arr satisfies arr[i] ==

    }*/

    /**
     * https://leetcode.com/problems/third-maximum-number/
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        List<Integer> list = removeDuplicates(nums);
        if(list.size()==1){
            return list.get(0);
        }
        if(list.size()==2){
            return list.get(0)>list.get(1) ? list.get(0) : list.get(1);
        }
        Collections.sort(list);
        return list.get(list.size()-3);
    }

    private List<Integer> removeDuplicates(int[] ii) {
        Set<Integer> numSet = new HashSet<>();
        for (int i : ii) {
            numSet.add(i);
        }
        List<Integer> list = new ArrayList<Integer>(numSet);
        Collections.sort(list);
        return list;
    }
}
