package leetcode.medium;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (s.length() < numRows) {
            return s;
        }
        char[] letters = s.toCharArray();
        int numDiagonal = Math.max(0, numRows - 2);
        int clmnDistance = numRows + numDiagonal;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(letters[i]);
            for (int step = clmnDistance - i; step < letters.length; step += clmnDistance) {
                if (i != 0 && i != numRows - 1) {
                    result.append(letters[step]);
                }
                if (step + 2*i >= letters.length) {
                    break;
                }
                result.append(letters[step + 2*i]);
            }
        }
        return result.toString();
    }
}
