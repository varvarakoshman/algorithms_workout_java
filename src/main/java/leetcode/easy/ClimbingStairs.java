package leetcode.easy;

import java.math.BigInteger;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int nCombinations = 0;
        int nTwos = n / 2;
        int nOnes;
        int m;
        int k;
        BigInteger cMk;
        for (int i = nTwos; i >= 0; i--) {
            nOnes = n - i * 2;
            if (nOnes != 0 && i != 0) {
                m = i + nOnes;
                k = nOnes;
                if (m - k > k) {
                    cMk = getFactorial(m, m - k).divide((getFactorial(k, 1)));
                } else {
                    cMk = getFactorial(m, k).divide(getFactorial(m - k, 1));
                }
                nCombinations += cMk.intValue();
            } else {
                nCombinations++;
            }
        }
        return nCombinations;
    }

    private BigInteger getFactorial(int number, int bound) {
        BigInteger result = BigInteger.valueOf(1);
        for (int factor = bound + 1; factor <= number; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }
        return result;
    }
}
