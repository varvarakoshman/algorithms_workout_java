package leetcode.medium;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int leftBound = 0;
        int minLen = nums.length + 1;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            while (currSum >= target) {
                minLen = Math.min(minLen, i - leftBound + 1);
                currSum -= nums[leftBound];
                leftBound++;
            }
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}
