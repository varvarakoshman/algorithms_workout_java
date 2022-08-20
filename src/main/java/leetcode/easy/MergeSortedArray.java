package leetcode.easy;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left1 = 0;
        for (int num2: nums2) {
            while (left1 < m && num2 > nums1[left1]) {
                left1++;
            }
            insertAndShift(num2, left1, nums1);
            m++;
            left1++;
        }
    }

    private void insertAndShift(int value, int position, int[] nums1) {
        int prev = nums1[position];
        nums1[position] = value;
        for (int i = position + 1; i < nums1.length; i++) {
            int temp = nums1[i];
            nums1[i] = prev;
            prev = temp;
        }
    }
}
