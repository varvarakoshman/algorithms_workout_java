package leetcode.medium;

import java.util.Arrays;

public class SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int pointerOne = 0;
        int pointerTwo = 0;
        int[] optimalPair = new int[]{};
        int smallestDifference = - Integer.MAX_VALUE;
        while (pointerOne < arrayOne.length && pointerTwo < arrayTwo.length) {
            int firstNum = arrayOne[pointerOne];
            int secondNum = arrayTwo[pointerTwo];
            int currDifference = Math.abs(firstNum - secondNum);
            if (firstNum < secondNum) {
                pointerOne += 1;
            } else if (secondNum < firstNum) {
                pointerTwo += 1;
            } else {
                return new int[] {firstNum, secondNum};
            }
            if (currDifference < smallestDifference) {
                smallestDifference = currDifference;
                optimalPair = new int[]{firstNum, secondNum};
            }
        }
        return optimalPair;
    }
}
