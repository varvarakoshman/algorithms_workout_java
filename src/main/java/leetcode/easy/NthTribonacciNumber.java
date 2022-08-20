package leetcode.easy;

public class NthTribonacciNumber {
    public int tribonacci(int n) {
        int[] tribonacci = new int[n+3];
        tribonacci[0] = 0;
        tribonacci[1] = 1;
        tribonacci[2] = 1;
        for (int i = 3; i <= n; i++) {
            tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
        }
        return tribonacci[n];
    }
}
