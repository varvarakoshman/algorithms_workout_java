package leetcode.medium;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            count++;
            // odd
            count += getPalindromeCount(i - 1, i + 1, letters);
            // even
            count += getPalindromeCount(i - 1, i, letters);
        }
        return count;
    }

    private int getPalindromeCount(int left, int right, char[] letters) {
        int count = 0;
        while (left >= 0 && right < letters.length && letters[left] == letters[right]) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
