package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

//    public static int longestConsecutive(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        for (int num : nums) {
//            max = Math.max(max, num);
//            min = Math.min(min, num);
//        }
//        int[] positive = new int[Math.max(max + 1, 0)];
//        int[] negative = new int[Math.abs(Math.min(min - 1, 0))];
//        for (int num : nums) {
//            if (num >= 0) {
//                positive[num] = 1;
//            } else {
//                negative[Math.abs(num)] = 1;
//            }
//        }
//        int maxLen = 0;
//        int currLen = 0;
//        for (int i = negative.length - 1; i > 0; i--) {
//            if (negative[i] == 1) {
//                currLen += 1;
//            } else {
//                maxLen = Math.max(maxLen, currLen);
//                currLen = 0;
//            }
//        }
//        for (int present : positive) {
//            if (present == 1) {
//                currLen += 1;
//            } else {
//                maxLen = Math.max(maxLen, currLen);
//                currLen = 0;
//            }
//        }
//        return Math.max(maxLen, currLen);
//    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> distinctNums = new HashSet<>();
        for (int num: nums) {
            distinctNums.add(num);
        }
        Set<Integer> alreadySeen = new HashSet<>();
        int maxLen = 0;
        for (int num: nums) {
            if (!alreadySeen.contains(num)) {
                int currLen = 1;
                while (distinctNums.contains(num + currLen)) {
                    alreadySeen.add(num + currLen);
                    currLen += 1;
                }
                alreadySeen.add(num);
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
    }
}
