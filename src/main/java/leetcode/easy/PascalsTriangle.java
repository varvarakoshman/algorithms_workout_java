package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            triangle.add(getRow(triangle, i));
        }
        return triangle;
    }

    private List<Integer> getRow(List<List<Integer>> triangle, int nNums) {
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        if (nNums == 0) {
            return newRow;
        }
        List<Integer> prevRow = triangle.get(nNums - 1);
        for (int i = 0; i < prevRow.size() - 1; i++) {
            newRow.add(prevRow.get(i) + prevRow.get(i + 1));
        }
        newRow.add(1);
        return newRow;
    }
}
