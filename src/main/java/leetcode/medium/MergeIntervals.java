package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[][] merged = new int[intervals.length + 1][];
        result.add(intervals[0]);
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if (curr[0] > prev[1]) {
                result.add(curr);
                prev = curr;
            } else if (curr[1] > prev[1]) {
                result.get(result.size() - 1)[1] = curr[1];
                prev[1] = curr[1];
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
