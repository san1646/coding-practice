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
        System.out.println("largest prime: "+largestPrimeFactor(new Long("600851475143")));
        //System.out.println(isPrime(new Long("6857")));
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
