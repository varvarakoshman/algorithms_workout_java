package leetcode.easy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> letterNum = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            letterNum.put(letter, letterNum.getOrDefault(letter, 0) + 1);
        }
        Optional<Character> firstUniqueLetter = getFirstLetter(letterNum);
        return firstUniqueLetter.map(character -> s.indexOf(character.toString())).orElse(-1);
    }

    private Optional<Character> getFirstLetter(Map<Character, Integer> letterNum) {
        return letterNum.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }
}
