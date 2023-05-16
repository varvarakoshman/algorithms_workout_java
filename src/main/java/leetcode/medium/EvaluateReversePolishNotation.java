package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        List<String> operations = List.of("*", "+", "-", "/");
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token: tokens) {
            if (operations.contains(token)) {
                int firstValue = stack.removeFirst();
                int secondValue = stack.removeFirst();
                int result = applyOperation(firstValue, secondValue, token);
                stack.addFirst(result);
            } else {
                stack.addFirst(Integer.valueOf(token));
            }
        }
        return stack.removeFirst();
    }

    private int applyOperation(int firstValue, int secondValue, String token) {
        if (Objects.equals("*", token)) {
            return firstValue * secondValue;
        } else if (Objects.equals("+", token)) {
            return firstValue + secondValue;
        } else if (Objects.equals("-", token)) {
            return secondValue - firstValue;
        } else {
            return secondValue / firstValue;
        }
    }
}
