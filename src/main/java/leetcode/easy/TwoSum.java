package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // key - remainder, value - index of the 1st number
        Map<Integer, Integer> remainderIndexesMap = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            int currentRemainder = target - nums[i];
            if (remainderIndexesMap.containsKey(nums[i])) {
                return new int[]{remainderIndexesMap.get(nums[i]), i};
            }
            if (!remainderIndexesMap.containsKey(currentRemainder)) {
                remainderIndexesMap.putIfAbsent(currentRemainder, i);
            }
        }
        return new int[]{};
    }
}
