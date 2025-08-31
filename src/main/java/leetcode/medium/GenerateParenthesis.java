package leetcode.medium;

import java.util.*;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, result, 0, 0, new ArrayDeque<>());
        return result;
    }

    private void generateParenthesisHelper(int nTotal, List<String> result, int nOpen, int nClose, Deque<String> currStack) {
        if (nOpen == nClose && nOpen == nTotal) {
            List<String> newSeq = new ArrayList<>(currStack);
            Collections.reverse(newSeq);
            result.add(String.join("", newSeq));
            return;
        }
        if (nOpen < nTotal) {
            currStack.push("(");
            generateParenthesisHelper(nTotal, result, nOpen + 1, nClose, currStack);
            currStack.pop();
        }
        if (nClose < nOpen) {
            currStack.push(")");
            generateParenthesisHelper(nTotal, result, nOpen, nClose + 1, currStack);
            currStack.pop();
        }
    }
}
