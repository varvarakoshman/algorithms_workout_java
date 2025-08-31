//package leetcode.medium;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FindKclosestElements {
//    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> result = new ArrayList<>();
//        if (arr.length == k) {
//            for (int i = 0; i < arr.length; i++) {
//                result.add(arr[i]);
//            }
//            return result;
//        }
//
//        int left = getClosestIndex(arr, x);
//        int right = left + 1;
//
//        while (right - left) {
//
//        }
//    }
//
//    private static int getClosestIndex(int[] arr, int x) {
//        int left = 0;
//        int right = arr.length - 1;
//        while (left <= right) {
//            int mid = (right + left) / 2;
//            if (arr[mid] >= x) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left - 1;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
//        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
//    }
//}
