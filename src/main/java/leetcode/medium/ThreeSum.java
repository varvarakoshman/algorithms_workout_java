package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n^2) time | O(n) space
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curr = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum > -curr) {
                    right--;
                } else if (twoSum < -curr) {
                    left++;
                } else {
                    result.add(List.of(curr, nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4}); // [[-1,-1,2],[-1,0,1]]
        threeSum(new int[]{-2, 0, 0, 2, 2}); // [[-2, 0, 2]]
    }
}
