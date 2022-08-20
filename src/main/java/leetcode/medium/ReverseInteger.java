package leetcode.medium;

public class ReverseInteger {
    public int reverse(int x) {
        int reversedNumber = 0;
        int sign = getSign(x);
        x = x * sign;
        int power = (int) Math.log10(x);
        while (x > 0) {
            int delta = (int) (x % 10 * Math.pow(10, power));
            if (reversedNumber + delta < 0) {
                return 0;
            }
            reversedNumber += delta;
            power--;
            x /= 10;
        }
        return reversedNumber * sign;
    }

    private int getSign(int x) {
        return (x > 0) ? 1 : -1;
    }
}
