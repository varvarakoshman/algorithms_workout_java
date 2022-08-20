package leetcode.easy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int leftPointer = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[leftPointer]) {
                leftPointer = i;
            }
            maxProfit = Math.max(maxProfit, prices[i] - prices[leftPointer]);
        }
        return maxProfit;
    }
}
