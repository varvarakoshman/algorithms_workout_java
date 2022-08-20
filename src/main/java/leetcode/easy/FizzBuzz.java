package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> nStr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                nStr.add("FizzBuzz");
            } else if (i % 3 == 0) {
                nStr.add("Fizz");
            } else if (i % 5 == 0) {
                nStr.add("Buzz");
            } else {
                nStr.add(String.valueOf(i));
            }
        }
        return nStr;
    }
}
