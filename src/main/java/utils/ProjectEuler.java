package utils;

import java.util.HashMap;
import java.util.Map;

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
     * numbers is 9009 = 91 Ã— 99.
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

    /**
     * The sum of the squares of the first ten natural numbers is,
     * 
     * numbers is,
     * 1² + 2² + ... + 10² = 385 The square of the sum of the first ten natural
     * 
     * (1 + 2 + ... + 10)² = 55² = 3025 Hence the difference between the sum of the
     * squares of the first ten natural numbers and the square of the sum is 3025 −
     * 385 = 2640.
     * 
     * Find the difference between the sum of the squares of the first one hundred
     * natural numbers and the square of the sum. 
     * 
     * https://projecteuler.net/problem=6
     */
    int sumSquareDifference(int n) {
	int sumOfSquares = 0;
	int squareOfSum = 0;
	for(int i=1; i<=n;i++) {
	    sumOfSquares += Math.pow(i, 2);
	}
	
	for(int i=1; i<=n;i++) {
	    squareOfSum += i;
	}
	squareOfSum = (int) Math.pow(squareOfSum, 2);
	
	return - sumOfSquares + squareOfSum;
    }
    
    /**
     * 
     * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
     * that the 6th prime is 13.
     * 
     * What is the 10 001st prime number? https://projecteuler.net/problem=7
     * 
     * @return
     * hint: 
     * // Entry k in the array represents the number 2*k+3, so we have to do
	// a bit of arithmetic to get the indices right.
	public static int nthPrime(int n) {
            if (n < 2) return 2;
            if (n == 2) return 3;
            int limit, root, count = 1;
            limit = (int)(n*(Math.log(n) + Math.log(Math.log(n)))) + 3;
            root = (int)Math.sqrt(limit) + 1;
            limit = (limit-1)/2;
            root = root/2 - 1;
            boolean[] sieve = new boolean[limit];
            for(int i = 0; i < root; ++i) {
                if (!sieve[i]) {
                    ++count;
                    for(int j = 2*i*(i+3)+3, p = 2*i+3; j < limit; j += p) {
                        sieve[j] = true;
                    }
                }
            }
            int p;
            for(p = root; count < n; ++p) {
                if (!sieve[p]) {
                    ++count;
                }
            }
            return 2*p+1;
        }
        
        NOT WORKING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
     */
    int findNthPrime(int x) {
        if (x <= 1)
            return 1;
        if (x <= 3)
            return 3;

/*        if (x % 2 == 0 || x % 3 == 0)
            return false;
*/
        for (Long i = 5L; i * i <= x; i = i + 6) {
            if (x % i == 0 || x % (i + 2) == 0) {
                return x;
            }
        }
	return 0;
    }
    
    /**
     * brute force 
     * @see utils.ProjectEuler.findNthPrime(int)
     * @param n
     * @return
     */
    public int nthPrime(int n) {
	    int candidate, count;
	    for(candidate = 2, count = 0; count < n; ++candidate) {
	        if (isPrime(new Long(candidate))) {
	            ++count;
	        }
	    }
	    // The candidate has been incremented once after the count reached n
	    return candidate-1;
	}

    /**
     * Highest product of n adjacent numbers
     * 
     * Note: This seems right, but Project Euler does not like the answer.
     * 20180715 WORKING!!! I was using int to store the product, it overflew, duh
     * I think it is though.
     * https://projecteuler.net/problem=8
     * @param n
     * @param thousandDigits
     * @return
     */
    public Long productOfAdjacentN(int n, String thousandDigits) {
        String[] arr = thousandDigits.split("");

        Long highest = 0L;
        for (int i = 0; i <= arr.length - n; i++) {
            Long product = 1L;
            for (int k = i; k < i + n; k++) {
                product *= Integer.valueOf(arr[k]);
            }
            
            if (product > highest) {
                highest = product;
                System.out.println("i when highest="+highest+" is found="+i);
            }
            if (i > 985) {
                System.out.println("For i=" + i + ", arr[i]=" + arr[i]+"; product="+product);
            }
        }
        return highest;
    }

    /**
     * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
     * a2 + b2 = c2
     * For example, 32 + 42 = 9 + 16 = 25 = 52.
     * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
     * Find the product abc.
     * <br/> https://projecteuler.net/problem=9
     * 
     * NOT COMPLETE YET
     */
    public int specialPythagoreanTripletProblem9(int limit) {

        Long a = 0L, b = 0L, c = 0L;
        Long m = 2L;
        while (c < limit) {
            for (Long n = 1L; n < limit; n++) {
                a = m * m - n * n;
                b = 2 * m * n;
                c = m * m + n * n;
                if (c > limit) {
                    break;
                }
                System.out.println("a,b,c=" + a + "," + b + "," + c);
                /*if ((a + b + c) == 1000) {
                    System.out.println("a,b,c=" + a + "," + b + "," + c);
                    System.out.println("a^2 + b^2 = "
                            + (Long.valueOf(a) * Long.valueOf(a)) + (Long.valueOf(b) * Long.valueOf(b)));
                    System.out.println("c^2 = " + Long.valueOf(c) * Long.valueOf(c));
                    System.out.println("Product is : " + (Long.valueOf(a) * Long.valueOf(b) * Long.valueOf(c)));
                }*/
            }
            m++;
        }

        return 0;
    }
    
    public float calculateIncrementalAverage(float average, float x, int n) {
        float diff = (x - average) / n;
        return average + diff;
    }
    
    /**
     * Problem 17
     * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 =
     * 19 letters used in total.
     * 
     * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be
     * used?
     * 
     * 
     * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115
     * (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with
     * British usage.
     * 
     * STATUS: 201808231414 Not working
     */
    public int numberLetterCounts(int n) {
        /*
         * Map<Integer, String> num_words = new HashMap<Integer, String>();
         * num_words.put(0, "zero");
         * num_words.put(1, "one");
         * num_words.put(2, "two");
         * num_words.put(3, "three");
         * num_words.put(4, "four");
         * num_words.put(5, "five");
         * num_words.put(6, "six");
         * num_words.put(7, "seven");
         * num_words.put(8, "eight");
         * num_words.put(9, "nine");
         */
        Map<Integer, Integer> num_words = new HashMap<Integer, Integer>();
        num_words.put(0, 4);// "zero");
        num_words.put(1, 3);// "one");
        num_words.put(2, 3);// "two");
        num_words.put(3, 5);// "three");
        num_words.put(4, 4);// "four");
        num_words.put(5, 4);// "five");
        num_words.put(6, 3);// "six");
        num_words.put(7, 5);// "seven");
        num_words.put(8, 5);// "eight");
        num_words.put(9, 4);// "nine");
        num_words.put(10, 3);// "ten");
        num_words.put(11, 6);// "eleven");
        num_words.put(12, 6);// "twelve");
        num_words.put(13, 8);// "thirteen");
        num_words.put(14, 8);// "fourteen");
        num_words.put(15, 7);// "fifteen");
        num_words.put(16, 7);// "sixteen");
        num_words.put(17, 9);// "seventeen");
        num_words.put(18, 8);// "eighteen");
        num_words.put(19, 8);// "nineteen");
        num_words.put(20, 6);// "twenty");
        num_words.put(30, 6);// "thirty");
        num_words.put(40, 5);// "forty");
        num_words.put(50, 5);// "fifty");
        num_words.put(60, 5);// "sixty");
        num_words.put(70, 7);// "seventy");
        num_words.put(80, 6);// "eighty");
        num_words.put(90, 6);// "ninety");
        

        int andCount = 3;
        int hundredCount = 7;
        int kCount = 8;// thousand

        int total = 0;
        
        for (int i = 1; i <= n; i++) {
            String[] digits = extractDigits(i);
            for (int k = 0; k < digits.length; k++) {
                Integer val = Integer.parseInt(digits[k]);
                int wordCount = num_words.get(val);
                if(digits.length==3) {
                    wordCount += hundredCount + andCount;
                }else if(digits.length==4){
                    wordCount += kCount;
                }
                total += wordCount;
            }
        }
        
        
        

        return total;
    }

    


    /**
     * Given an Integer, extract the digits
     * Returns a string array with all the digits
     * @param number
     * @return
     */
    String[] extractDigits(Integer number) {
        
        Integer m, n;
        m=n= Math.abs(number);
        
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        
        String[] digits = new String[count];
        while (m > 0) {
            digits[count-1] = m % 10 + "";
            m = m / 10;
            count--;
        }
        return digits;
    }
    
}
