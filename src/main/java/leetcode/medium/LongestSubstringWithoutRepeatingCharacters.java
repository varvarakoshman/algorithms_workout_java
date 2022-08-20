package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] letters = s.toCharArray();
        List<Character> groupMembers = new ArrayList<>();
        int maxLength = 0;
        for (char letter: letters) {
            if (groupMembers.contains(letter)) {
                maxLength = Math.max(groupMembers.size(), maxLength);
                int newBound = groupMembers.indexOf(letter);
                groupMembers.subList(0, newBound + 1).clear();
            }
            groupMembers.add(letter);
        }
        return Math.max(groupMembers.size(), maxLength);
    }
}
