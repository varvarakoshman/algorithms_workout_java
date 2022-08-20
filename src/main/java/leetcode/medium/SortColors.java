package leetcode.medium;

public class SortColors {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int lower, int higher) {
        if (lower < higher) {
            int pivotIndex = partition(nums, lower, higher);
            quickSort(nums, lower, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, higher);
        }
    }

    private int partition(int[] nums, int lower, int higher) {
        int i = lower - 1;
        int pivot = nums[higher];
        for (int j = lower; j < higher; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, higher);
        return i + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
