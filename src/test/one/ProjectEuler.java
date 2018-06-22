package test.one;

import java.math.BigInteger;

/**
 * https://projecteuler.net/
 * 
 * @author sanket.bharaswadkar
 *
 */

public class ProjectEuler {
    public static void main(String[] args) {
        //System.out.println("largest prime: " + largestPrimeFactor(new Long("600851475143")));
        // System.out.println(isPrime(new Long("6857")));
        //System.out.println(isPalindrome("9009"));//"AManAPlanACanalPanama"
        //System.out.println(largestPalindromeProduct());
        //System.out.println(lengthOfNumber(123456789));
        System.out.println("Smallest multiple :"+smallestMultiple());
    }

    /**
     * https://projecteuler.net/problem=3
     * 
     * @return
     */
    static Long largestPrimeFactor(Long x) {
        if (x < 0)
            return 0L;
        Long elPrimo = 1L;
        double rt = Math.sqrt(x);
        for (Long i = 2L; i < rt; i++) {
            if (x % i == 0) {
                if (i > elPrimo && isPrime(i)) {
                    elPrimo = i;
                }
            }
        }
        return elPrimo;
    }

    /**
     * https://projecteuler.net/problem=4
     * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit
     * numbers is 9009 = 91 × 99.
     * 
     * Find the largest palindrome made from the product of two 3-digit numbers.
     * 913*993
     * @return
     */
    static int largestPalindromeProduct() {
        int P_999_999 = 999 * 999;
        int P_9999_9999 = 9999*9999;
        int P_100_100 = 100 * 100;
        int P_1000_1000 = 1000*1000;
        int i = P_999_999;
        int palindrome = 0;
        for (; i > P_100_100; i--) {
            if (isPalindrome("" + i)) {
                System.out.println("------------------");
                for (int j = 999; j > 99; j--) {
                    System.out.println("trying " + i + " for..." + j);
                    if (i % j == 0 && ((int) (Math.log10(i/j) + 1)==3) ) {
                        palindrome = i;
                        break;
                    }
                }
                if(palindrome!=0) break;
            }
        }
        return palindrome;
    }
    
    /**
     * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
     * 
     * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     * https://projecteuler.net/problem=5
     * 
     * @return
     */
    static int smallestMultiple() {
        int firstX = 20;
        int sm=0;
        for(int i=232792559; i < 232792561 ;i++) {
            int j =2;
            for (; j <= firstX; j++) {
                int ij = i%j;
                System.out.println("i : "+i+", j :"+j+", i%j :"+ij);
                if(ij==0) {
                    continue;
                }else {
                    break;
                }
            }
            if(j==firstX+1) {
                sm=i;
                break;
            }
        }
        
        return sm;
    }

    static boolean isPalindrome(String p) {
        if(p==null) return false;
        String s = p.toLowerCase();
        
        //if length is even, split and compare
        for (int i=0, j=s.toCharArray().length-1; i<=j; i++, j--) {
            if(s.toCharArray()[i]!=s.toCharArray()[j]) {
                return false;
            }
        }
        return true;
    }
    
    
    /**
     * Number of digits
     * 
     * @return
     */
    static int lengthOfNumber(int x) {
        int t = 1, l = 0;

        while (t < x) {
            t *= 10;
            l++;
        }
        return l;
    }
    
    /**
     * Primality test for positive number
     * @param x
     * @return
     */
    static boolean isPrime(Long x) {
        if (x <= 1)
            return false;
        if (x <= 3)
            return true;

        if (x % 2 == 0 || x % 3 == 0)
            return false;

        for (Long i = 5L; i * i <= x; i = i + 6) {
            if (x % i == 0 || x % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
