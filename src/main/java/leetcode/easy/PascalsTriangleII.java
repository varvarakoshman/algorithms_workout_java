package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            triangle.add(getRow(triangle, i));
        }
        return triangle.get(rowIndex);
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
