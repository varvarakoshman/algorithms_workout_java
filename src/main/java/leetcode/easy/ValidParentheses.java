package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    private Map<Character, Character> map = new HashMap<>();

    {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid(String s) {
        Deque<Character> openBrackets = new ArrayDeque<>();
        for (Character bracket: s.toCharArray()) {
            if (map.keySet().contains(bracket)) {
                openBrackets.push(bracket);
            } else if (openBrackets.isEmpty() || !bracket.equals(map.get(openBrackets.pop()))) {
                return false;
            }
        }
        return openBrackets.isEmpty();
    }
}
