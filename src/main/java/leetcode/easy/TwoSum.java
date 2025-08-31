package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // key - remainder, value - index of the 1st number
        Map<Integer, Integer> remainderIndexesMap = new HashMap<>();
        for (int i=0; i < nums.length; ++i) {
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



//
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> remainders = new HashMap<>();
//        for (int i = 0; i < nums.length; i ++) {
//            if (remainders.containsKey(nums[i])) {
//                return new int[] {remainders.get(nums[i]), i};
//            }
//            remainders.put(target - nums[i], i);
//        }
//        return null;
//    }
















    public static void main(String[] args) {
        twoSum(new int[]{1, 2, 3, 4, 5}, 1);
    }
}
