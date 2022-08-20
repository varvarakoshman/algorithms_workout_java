package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        int nPairs = 0;
        Map<Integer, Integer> differences = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            if (differences.containsKey(nums[i])) {
                nPairs += differences.get(nums[i]);
            }
            int remainder1 = nums[i] - k;
            int remainder2 = k + nums[i];
            differences.merge(remainder1, 1, (v1, v2) -> v1 + v2);
            differences.merge(remainder2, 1, (v1, v2) -> v1 + v2);
        }
        return nPairs;
    }
}
