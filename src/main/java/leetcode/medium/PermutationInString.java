package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PermutationInString {

    private static final char[] alphabet = getAlphabet();

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> freq1 = getFrequenciesUntilIndex(s1, s1.length());
        Map<Character, Integer> freq2 = getFrequenciesUntilIndex(s2, s1.length());
        int equalsCount = computeInitEqualsCount(freq1, freq2);
        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++) {
            if (equalsCount == 26) {
                return true;
            }

            char newLetter = s2.charAt(right);
            freq2.put(newLetter, freq2.get(newLetter) + 1);
            if (freq2.get(newLetter).equals(freq1.get(newLetter))) {
                equalsCount++;
            } else if (freq2.get(newLetter) - freq1.get(newLetter) == 1) {
                equalsCount--;
            }

            char oldLetter = s2.charAt(left);
            freq2.put(oldLetter, freq2.get(oldLetter) - 1);
            if (freq2.get(oldLetter).equals(freq1.get(oldLetter))) {
                equalsCount++;
            } else if (freq2.get(oldLetter) + 1 == freq1.get(oldLetter)) {
                equalsCount--;
            }

            left++;
        }
        return equalsCount == 26;
    }

    private Map<Character, Integer> getFrequenciesUntilIndex(String s, int index) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char letter: alphabet) {
            freq.put(letter, 0);
        }
        for (int i = 0; i < index; i++) {
            char letter = s.charAt(i);
            freq.put(letter, freq.getOrDefault(letter, 0) + 1);
        }
        return freq;
    }

    private int computeInitEqualsCount(Map<Character, Integer> freq1, Map<Character, Integer> freq2) {
        int equalsCount = 0;
        for (char letter: alphabet) {
            if (Objects.equals(freq1.get(letter), freq2.get(letter))) {
                equalsCount++;
            }
        }
        return equalsCount;
    }

    private static char[] getAlphabet() {
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
        }
        return alphabet;
    }
}
