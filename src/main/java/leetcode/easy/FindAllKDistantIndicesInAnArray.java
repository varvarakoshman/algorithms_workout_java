package leetcode.easy;

import java.util.*;

public class FindAllKDistantIndicesInAnArray {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> kDistantIndices = new HashSet<>();
        int arrLen = nums.length;
        int lastCheckedIndex = 0;
        int leftBoarder;
        int rightBoarder;
        for (int j = 0; j < arrLen; j++) {
            if (nums[j] == key) {
                leftBoarder = Math.max(lastCheckedIndex, j - k);
                rightBoarder = Math.min(arrLen - 1, j + k);
                for (int i = leftBoarder; i < rightBoarder + 1; i++) {
                    kDistantIndices.add(i);
                }
                lastCheckedIndex = rightBoarder;
            }
        }
        List<Integer> result = new ArrayList<>(kDistantIndices);
        Collections.sort(result);
        return result;
    }
}
