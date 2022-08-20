package leetcode.easy;

public class ValidPalindrome {
    private static final String ALPHA_NUM_REGEX = "[^A-Za-z0-9]";

    public boolean isPalindrome(String s) {
        String sClean = getCleanInput(s);
        if (sClean.isEmpty()) {
            return true;
        } else {
            return checkIfPalindrome(sClean);
        }
    }

    private String getCleanInput(String s) {
        return s.toLowerCase().replaceAll(ALPHA_NUM_REGEX, "");
    }

    private boolean checkIfPalindrome(String s) {
        char[] letters = s.toCharArray();
        int lastIndex = letters.length - 1;
        for (int i = 0; i < letters.length / 2; i++) {
            if (letters[i] != letters[lastIndex - i]) {
                return false;
            }
        }
        return true;
    }
}
