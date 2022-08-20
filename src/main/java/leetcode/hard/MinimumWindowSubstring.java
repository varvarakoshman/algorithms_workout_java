package leetcode.hard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        String minWindow = "";
        List<Character> tChars = getChars(t);
        Map<Character, Integer> tFreqs = getLetterFrequencies(tChars);
        Map<Character, Integer> sFreqs = new HashMap<>();
        TreeMap<Integer, Character> windowIndexChar = new TreeMap<>();
        int leftPointer = 0;
        int rightPointer = 0;
        int minWindowLen = s.length() + 1;
        List<Character> sChars = getChars(s);
        int endIndex = sChars.size() - 1;
        while (leftPointer < sChars.size()) {
            Character letter = sChars.get(rightPointer);
            if (tChars.contains(letter) && !windowIndexChar.containsKey(rightPointer)) {
                if (sFreqs.size() == 0) {
                    leftPointer = rightPointer;
                }
                sFreqs.merge(letter, 1, Integer::sum);
                windowIndexChar.put(rightPointer, letter);
            }
            int currWindowLen = rightPointer - leftPointer + 1;
            boolean isTargetContaint = checkIfContained(sFreqs, tFreqs);
            if (isTargetContaint && currWindowLen < minWindowLen) {
                minWindowLen = currWindowLen;
                minWindow = s.substring(leftPointer, rightPointer + 1);
            }
            boolean isLeftShifted = false;
            if (isTargetContaint || rightPointer == endIndex) {
                int newLeftPointer = shiftLeftBound(windowIndexChar, sFreqs, leftPointer);
                isLeftShifted = leftPointer != newLeftPointer;
                leftPointer = newLeftPointer;
            }
            if ((!isLeftShifted || leftPointer >= rightPointer) && rightPointer < sChars.size() - 1) {
                rightPointer++;
            }
        }
        return minWindow;
    }

    private List<Character> getChars(String s) {
        return s.chars()
                .mapToObj(e->(char)e)
                .collect(Collectors.toList());
    }

    private Map<Character, Integer> getLetterFrequencies(List<Character> letters) {
        Map<Character, Integer> letterFreqs = new HashMap<>();
        for (char letter: letters) {
            letterFreqs.merge(letter, 1, (v1, v2) -> v1 + v2);
        }
        return letterFreqs;
    }

    private int shiftLeftBound(TreeMap<Integer, Character> windowIndexChar, Map<Character, Integer> sFreqs, int leftBound){
        Map.Entry<Integer, Character> first = windowIndexChar.pollFirstEntry();
        Map.Entry<Integer, Character> second = windowIndexChar.firstEntry();
        if (first == null) {
            return leftBound + 1;
        }
        Character firstValue = first.getValue();
        if (sFreqs.get(firstValue) > 1) {
            sFreqs.put(firstValue, sFreqs.get(firstValue) - 1);
        } else {
            sFreqs.remove(firstValue);
        }
        return second != null ? second.getKey() : leftBound + 1;
    }

    private boolean checkIfContained(Map<Character, Integer> source, Map<Character, Integer> target) {
        return target.entrySet().stream()
                .allMatch(entry -> source.containsKey(entry.getKey()) &&
                        entry.getValue() <= source.get(entry.getKey()));
    }
}
