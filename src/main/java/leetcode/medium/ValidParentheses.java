package leetcode.medium;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> bracketsMapping = getBracketsMapping();
        Deque<Character> stack = new ArrayDeque<>();
        for (char bracket: s.toCharArray()) {
            if (bracketsMapping.containsKey(bracket)) {
                Character targetOpening = bracketsMapping.get(bracket);
                if (stack.size() == 0 || !Objects.equals(targetOpening, stack.removeFirst())) {
                    return false;
                }
            } else {
                stack.addFirst(bracket);
            }
        }
        return stack.size() == 0;
    }

    private Map<Character, Character> getBracketsMapping() {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('}', '{');
        brackets.put(']', '[');
        brackets.put(')', '(');
        return brackets;
    }
}
