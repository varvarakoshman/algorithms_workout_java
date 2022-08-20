package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> letterFrequenciesS = new HashMap<>();
        for (Character letter: s.toCharArray()) {
            if (letterFrequenciesS.containsKey(letter)) {
                letterFrequenciesS.replace(letter, letterFrequenciesS.get(letter) + 1);
            } else {
                letterFrequenciesS.put(letter, 1);
            }
            // letterFrequenciesS.merge(letter, 1, (v1, v2) -> v1 + v2);
        }
        int counter = 0;
        int counterCurr;
        for (Character letter: t.toCharArray()) {
            if (!letterFrequenciesS.containsKey(letter)) {
                return false;
            } else {
                counterCurr = letterFrequenciesS.get(letter);
                letterFrequenciesS.replace(letter, counterCurr - 1);
                if (counterCurr == 1) {
                    counter++;
                }
            }
        }
        return letterFrequenciesS.size() == counter;
    }
}
