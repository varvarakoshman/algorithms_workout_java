package leetcode.medium;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        List<Character> letters = getLetters(s);
        for (int i = 0; i < letters.size(); i++) {
            String longestOdd = getLongestPalindrome(i - 1, i + 1, letters);  // odd
            String longestEven = getLongestPalindrome(i - 1, i, letters); // even
            if (longestOdd.length() > longestPalindrome.length()) {
                longestPalindrome = longestOdd;
            }
            if (longestEven.length() > longestPalindrome.length()) {
                longestPalindrome = longestEven;
            }
        }
        return longestPalindrome;
    }

    private String getLongestPalindrome(int left, int right, List<Character> letters) {
        while (left >= 0 && right < letters.size() && letters.get(left) == letters.get(right)) {
            left--;
            right++;
        }
        return IntStream.range(left + 1, right)
                .mapToObj(i -> letters.get(i).toString())
                .collect(Collectors.joining());
    }

    private List<Character> getLetters(String s) {
        return s.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
    }
}
