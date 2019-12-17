// Say you have an array for which the i-th element is the price of a given stock on day i.
// Design an algorithm to find the maximum profit. You may complete at most k transactions.
//
// Note:
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//
// Example 1:
// Input: [2,4,1], k = 2
// Output: 2
// Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
//
// Example 2:
// Input: [3,2,6,5,0,3], k = 2
// Output: 7
// Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
//              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices.length == 0) {
            return 0;
        }

        if (k >= prices.length / 2) {
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }

        int[][] localProfit = new int[prices.length][k + 1];    // 第i天时，最多交易j次，且最后一次交易卖出在第i天的最大利润
        int[][] globalProfit = new int[prices.length][k + 1];   // 第i天时，最多交易j次的最大利润
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < prices.length; i++) {
                int profit = prices[i] - prices[i - 1];
                localProfit[i][j] = Math.max(globalProfit[i - 1][j - 1] + Math.max(profit, 0), localProfit[i - 1][j] + profit);
                globalProfit[i][j] = Math.max(localProfit[i][j], globalProfit[i - 1][j]);
            }
        }
        return globalProfit[prices.length - 1][k];
    }
}
