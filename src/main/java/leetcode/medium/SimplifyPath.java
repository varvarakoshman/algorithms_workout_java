package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] pathParts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String part: pathParts) {
            if ("".equals(part) || ".".equals(part)) {
                continue;
            }
            if ("..".equals(part) && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(part);
            }
        }

        StringBuilder canonicalPath = new StringBuilder();
        while (!stack.isEmpty()) {
            canonicalPath.append("/");
            canonicalPath.append(stack.pop());
        }
        return !canonicalPath.isEmpty() ? canonicalPath.toString() : "/";
    }

    public static void main(String[] args) {
        simplifyPath("/a//b////c/d//././/..");
    }
}
