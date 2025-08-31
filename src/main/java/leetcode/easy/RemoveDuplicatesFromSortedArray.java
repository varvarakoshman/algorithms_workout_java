package leetcode.easy;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int pointer1 = 1;
        int countUnique = 0;
        while (pointer1 < nums.length) {
            if (nums[pointer1] == nums[pointer1 - 1]) {
                int pointer2 = pointer1 + 1;
                while (pointer2 < nums.length && nums[pointer2] == nums[pointer1]) {
                    pointer2++;
                }
                if (pointer2 < nums.length) {
                    swap(nums, pointer1, pointer2);
                }
                pointer1 = pointer2;
            } else {
                countUnique++;
                pointer1++;
            }
        }
        return countUnique;
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static void main(String[] args) {
//        int[] test1= new int[]{1, 1, 2};
//        int k1 = removeDuplicates(test1);

        int[] test2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = removeDuplicates(test2);
        System.out.println(k2);
    }
}
