package leetcode.easy;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int leftBorder = 0;
        int rightBorder = nums.length - 1;
        int centerIndex;
        int pivot;
        while (leftBorder <= rightBorder) {
            centerIndex = (leftBorder + rightBorder) / 2;
            pivot = nums[centerIndex];
            if (target > pivot) {
                leftBorder = centerIndex + 1;
            } else if (target < pivot) {
                rightBorder = centerIndex - 1;
            } else {
                return centerIndex;
            }
        }
        return -1;
    }
}
