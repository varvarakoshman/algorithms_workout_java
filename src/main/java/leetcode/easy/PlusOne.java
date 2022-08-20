package leetcode.easy;

public class PlusOne {

    private int counterNines = 1;

    public int[] plusOne(int[] digits) {
        int lastDigitIndex = digits.length - 1;
        if (digits[lastDigitIndex] < 9) {
            digits[lastDigitIndex] = digits[lastDigitIndex] + 1;
            return digits;
        }
        modifyArray(digits);
        if (counterNines == digits.length) {
            return getBiggerArray(digits);
        } else {
            return digits;
        }
    }

    private int[] getBiggerArray(int[] digits) {
        int size = digits.length + 1;
        int[] result = new int[size];
        result[0] = 1;
        for (int i = 1; i < size; i++) {
            result[i] = 0;
        }
        return result;
    }

    private void modifyArray(int[] digits) {
        digits[digits.length - 1] = 0;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] == 9) {
                counterNines++;
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
    }
}
