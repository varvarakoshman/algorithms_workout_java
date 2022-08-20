package leetcode.medium;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (num > sum + num) {
                sum = num;
            } else {
                sum += num;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
